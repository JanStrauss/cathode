package eu.over9000.cathode;

import eu.over9000.cathode.data.meta.PaginatedContainer;
import eu.over9000.cathode.data.parameters.Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Jan on 05.05.2016.
 */
public class PaginationUtility {

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
