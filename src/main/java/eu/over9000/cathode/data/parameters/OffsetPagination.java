package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.data.meta.PaginatedContainer;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jan on 04.05.2016.
 */
public class OffsetPagination extends Pagination {

	private long offset = 0;

	public long getOffset() {
		return offset;
	}

	public OffsetPagination() {
	}

	public OffsetPagination(final long limit) {
		super(limit);
	}

	@Override
	public boolean hasMore(final PaginatedContainer<?> chunk) {
		return offset > chunk.getTotal();
	}

	@Override
	public void next(final PaginatedContainer<?> currentItem) {
		offset += getLimit();
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Arrays.asList(new BasicNameValuePair("limit", String.valueOf(limit)), new BasicNameValuePair("offset", String.valueOf(offset)));
	}

	@Override
	public PaginationType getType() {
		return PaginationType.OFFSET;
	}
}
