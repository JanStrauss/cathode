package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class VideoList implements PaginatedContainer<Video> {

	@SerializedName("_total")
	private final long total;
	private final List<Video> videos;

	public VideoList(final long total, final List<Video> videos) {
		this.total = total;
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "VideoList{" +
				"total=" + total +
				", videos=" + videos +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Video> getVideos() {
		return videos;
	}

	@Override
	public List<Video> getChunk() {
		return videos;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return videos.isEmpty();
	}
}
