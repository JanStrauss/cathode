package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class ChannelList implements PaginatedContainer<Channel> {

	@SerializedName("_total")
	private final long total;
	private final List<Channel> channels;

	public ChannelList(final long total, final List<Channel> channels) {
		this.total = total;
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "ChannelList{" +
				"total=" + total +
				", channels=" + channels +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	@Override
	public List<Channel> getChunk() {
		return channels;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return channels.isEmpty();
	}
}
