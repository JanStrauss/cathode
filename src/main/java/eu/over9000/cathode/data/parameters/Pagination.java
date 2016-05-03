package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.meta.PaginatedContainer;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Pagination implements Parameter {
	private static final int TWITCH_PAGINATION_MAX = 100;
	private long limit = 25;
	private long offset = 0;

	public Pagination() {

	}

	public Pagination(long limit) {
		if (limit > TWITCH_PAGINATION_MAX) {
			limit = TWITCH_PAGINATION_MAX;
		}
		this.limit = limit;
	}

	public void next() {
		offset += limit;
	}

	public long getLimit() {
		return limit;
	}

	public long getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return "Pagination{" +
				"limit=" + limit +
				", offset=" + offset +
				'}';
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Arrays.asList(new BasicNameValuePair("limit", String.valueOf(limit)), new BasicNameValuePair("offset", String.valueOf(offset)));
	}

	public static <Inner, Outer extends PaginatedContainer<Inner>> Response<List<Inner>> collectPaginated(final Pagination pagination, final Supplier<Response<Outer>> dataSource) {
		final List<Inner> result = new ArrayList<>();

		long total;
		do {
			final Response<Outer> chunkResponse = dataSource.get();

			if (chunkResponse.isSuccess()) {
				final Outer chunk = chunkResponse.getResultRaw();
				total = chunk.getTotal();
				result.addAll(chunk.getChunk());
			} else {
				return new Response<>(chunkResponse.getErrorRaw());
			}

			pagination.next();

		} while (pagination.getOffset() < total);

		return new Response<>(result);
	}
}
