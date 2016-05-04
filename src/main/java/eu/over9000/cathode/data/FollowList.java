package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class FollowList implements PaginatedContainer<Follow> {

	@SerializedName("_total")
	private final long total;
	@SerializedName("_cursor")
	private final String cursor;

	private final List<Follow> follows;


	public FollowList(final long total, final String cursor, final List<Follow> follows) {
		this.total = total;
		this.cursor = cursor;
		this.follows = follows;
	}

	@Override
	public String toString() {
		return "Follows{" +
				"total=" + total +
				", cursor='" + cursor + '\'' +
				", follows=" + follows +
				'}';
	}

	@Override
	public String getCursor() {
		return cursor;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	@Override
	public long getTotal() {
		return 0;
	}

	@Override
	public List<Follow> getChunk() {
		return follows;
	}


	@Override
	public boolean isEmpty() {
		return follows.isEmpty();
	}
}
