package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.data.meta.PaginatedContainer;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jan on 04.05.2016.
 */
public class CursorPagination extends Pagination {

	enum Direction {ASC, DESC}

	private Direction direction = Direction.DESC;

	private String cursor = "";

	public CursorPagination() {
	}

	public CursorPagination(final long limit) {
		super(limit);
	}

	public CursorPagination(final Direction direction) {
		this.direction = direction;
	}

	public CursorPagination(final long limit, final Direction direction) {
		super(limit);
		this.direction = direction;
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
		return Arrays.asList(new BasicNameValuePair("limit", String.valueOf(limit)), new BasicNameValuePair("cursor", cursor), new BasicNameValuePair("direction", direction.name()));
	}

}