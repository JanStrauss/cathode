package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Video {

	private final String title;
	private final String description;
	private final long broadcastId;
	private final String broadcastType;
	private final String status;
	private final String tagList;
	private final long views;
	private final Date createdAt;
	@SerializedName("_id")
	private final String id;
	private final Date recordedAt;
	private final String game;
	private final long length;
	private final String preview;
	private final String url;
	private final Fps fps;
	private final Resolutions resolutions;
	private final ChannelName channel;
	private final List<Thumbnail> thumbnails;

	public Video(final String title, final String description, final long broadcastId, final String broadcastType, final String status, final String tagList, final long views, final Date createdAt, final String id, final Date recordedAt, final String game, final long length, final String preview, final String url, final Fps fps, final Resolutions resolutions, final ChannelName channel, final List<Thumbnail> thumbnails) {
		this.title = title;
		this.description = description;
		this.broadcastId = broadcastId;
		this.broadcastType = broadcastType;
		this.status = status;
		this.tagList = tagList;
		this.views = views;
		this.createdAt = createdAt;
		this.id = id;
		this.recordedAt = recordedAt;
		this.game = game;
		this.length = length;
		this.preview = preview;
		this.url = url;
		this.fps = fps;
		this.resolutions = resolutions;
		this.channel = channel;
		this.thumbnails = thumbnails;
	}

	@Override
	public String toString() {
		return "Video{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", broadcastId=" + broadcastId +
				", broadcastType='" + broadcastType + '\'' +
				", status='" + status + '\'' +
				", tagList='" + tagList + '\'' +
				", views=" + views +
				", createdAt=" + createdAt +
				", id='" + id + '\'' +
				", recordedAt=" + recordedAt +
				", Game='" + game + '\'' +
				", length=" + length +
				", preview='" + preview + '\'' +
				", url='" + url + '\'' +
				", fps=" + fps +
				", resolutions=" + resolutions +
				", channel=" + channel +
				", thumbnails=" + thumbnails +
				'}';
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public long getBroadcastId() {
		return broadcastId;
	}

	public String getBroadcastType() {
		return broadcastType;
	}

	public String getStatus() {
		return status;
	}

	public String getTagList() {
		return tagList;
	}

	public long getViews() {
		return views;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getId() {
		return id;
	}

	public Date getRecordedAt() {
		return recordedAt;
	}

	public String getGame() {
		return game;
	}

	public long getLength() {
		return length;
	}

	public String getPreview() {
		return preview;
	}

	public String getUrl() {
		return url;
	}

	public Fps getFps() {
		return fps;
	}

	public Resolutions getResolutions() {
		return resolutions;
	}

	public ChannelName getChannel() {
		return channel;
	}

	public List<Thumbnail> getThumbnails() {
		return thumbnails;
	}
}



