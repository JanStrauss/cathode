package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.data.meta.PaginatedContainer;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class CursorPagination extends Pagination {

	private String cursor = null;

	public CursorPagination() {
	}

	public CursorPagination(final long limit) {
		super(limit);
	}

	@Override
	public boolean hasMore(final PaginatedContainer<?> chunk) {
		return !chunk.isEmpty();
	}

	@Override
	public void next(final PaginatedContainer<?> currentItem) {
		cursor = currentItem.getCursor();
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();

		if (limit != 0) {
			result.add(new BasicNameValuePair("limit", String.valueOf(limit)));
		}
		if (cursor != null) {
			result.add(new BasicNameValuePair("cursor", cursor));
		}

		return result;
	}

}