package eu.over9000.cathode.data.parameters;

import eu.over9000.cathode.data.meta.PaginatedContainer;

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
}
