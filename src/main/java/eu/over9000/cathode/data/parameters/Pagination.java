package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class Pagination implements Parameter {
	public enum PaginationType {OFFSET, CURSOR}

	private static final int TWITCH_PAGINATION_MAX = 100;

	protected long limit = 25;

	private String cursor;

	Pagination() {

	}

	Pagination(long limit) {
		if (limit > TWITCH_PAGINATION_MAX) {
			limit = TWITCH_PAGINATION_MAX;
		}
		this.limit = limit;
	}

	public abstract boolean hasMore(PaginatedContainer<?> chunk);

	public abstract void next(PaginatedContainer<?> currentItem);

	public long getLimit() {
		return limit;
	}

	public static <Inner, Outer extends PaginatedContainer<Inner>> Result<List<Inner>> collectPaginated(final Pagination pagination, final Supplier<Result<Outer>> dataSource) {

		final List<Inner> result = new ArrayList<>();

		Outer chunk;
		do {
			final Result<Outer> chunkResult = dataSource.get();

			if (chunkResult.isOk()) {
				chunk = chunkResult.getResultRaw();

				if (!chunk.isEmpty()) {
					result.addAll(chunk.getChunk());
				}

			} else {
				return new Result<>(chunkResult.getErrorRaw());
			}

			pagination.next(chunk);

		} while (pagination.hasMore(chunk));

		return new Result<>(result);
	}
}
