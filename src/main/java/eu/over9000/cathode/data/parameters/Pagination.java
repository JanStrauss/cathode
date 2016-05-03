package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.Response;
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

	public abstract PaginationType getType();

	public long getLimit() {
		return limit;
	}

	public static <Inner, Outer extends PaginatedContainer<Inner>> Response<List<Inner>> collectPaginated(final Pagination pagination, final Supplier<Response<Outer>> dataSource) {

		final List<Inner> result = new ArrayList<>();

		Outer chunk;
		do {
			final Response<Outer> chunkResponse = dataSource.get();

			if (chunkResponse.isSuccess()) {
				chunk = chunkResponse.getResultRaw();

				if (pagination.getType() != chunk.getPaginationType()) {
					return new Response<>(new IllegalStateException("Trying to paginate a " + chunk.getPaginationType() + " container " + " with a " + pagination.getType() + " pagination."));
				}

				if (!chunk.isEmpty()) {
					result.addAll(chunk.getChunk());
				}

			} else {
				return new Response<>(chunkResponse.getErrorRaw());
			}

			pagination.next(chunk);

		} while (pagination.hasMore(chunk));

		return new Response<>(result);
	}
}
