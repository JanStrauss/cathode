package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class TopGameList implements PaginatedContainer<TopGame> {

	@SerializedName("_total")
	private final long total;
	private final List<TopGame> top;

	public TopGameList(final long total, final List<TopGame> top) {
		this.total = total;
		this.top = top;
	}

	@Override
	public String toString() {
		return "TopGameList{" +
				"total=" + total +
				", top=" + top +
				'}';
	}

	@Override
	public long getTotal() {
		return total;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public List<TopGame> getChunk() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		return top == null || top.isEmpty();
	}

	public List<TopGame> getTop() {
		return top;
	}


}
