package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;
import eu.over9000.cathode.data.parameters.Pagination;

import java.util.List;

public class StreamList implements PaginatedContainer<Stream> {

	@SerializedName("_total")
	private final long total;
	private final List<Stream> streams;

	public StreamList(final long total, final List<Stream> streams) {
		this.total = total;
		this.streams = streams;
	}

	@Override
	public String toString() {
		return "QueriedStreams{" +
				"total=" + total +
				", streams=" + streams +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Stream> getStreams() {
		return streams;
	}

	@Override
	public List<Stream> getChunk() {
		return streams;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public Pagination.PaginationType getPaginationType() {
		return Pagination.PaginationType.OFFSET;
	}

	@Override
	public boolean isEmpty() {
		return streams.isEmpty();
	}
}
