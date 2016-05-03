package eu.over9000.cathode.data;

import java.util.Date;

public class Stream {

	private final long id;
	private final String game;
	private final long viewers;
	private final Date createdAt;
	private final long videoHeight;
	private final double averageFps;
	private final long delay;
	private final boolean isPlaylist;
	private final Channel channel;
	private final Preview preview;

	public Stream(final long id, final String game, final long viewers, final Date createdAt, final long videoHeight, final double averageFps, final long delay, final boolean isPlaylist, final Channel channel, final Preview preview) {
		this.id = id;
		this.game = game;
		this.viewers = viewers;
		this.createdAt = createdAt;
		this.videoHeight = videoHeight;
		this.averageFps = averageFps;
		this.delay = delay;
		this.isPlaylist = isPlaylist;
		this.channel = channel;
		this.preview = preview;
	}

	@Override
	public String toString() {
		return "Stream{" +
				"id=" + id +
				", game='" + game + '\'' +
				", viewers=" + viewers +
				", createdAt=" + createdAt +
				", videoHeight=" + videoHeight +
				", averageFps=" + averageFps +
				", delay=" + delay +
				", isPlaylist=" + isPlaylist +
				", channel=" + channel +
				", preview=" + preview +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getGame() {
		return game;
	}

	public long getViewers() {
		return viewers;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public long getVideoHeight() {
		return videoHeight;
	}

	public double getAverageFps() {
		return averageFps;
	}

	public long getDelay() {
		return delay;
	}

	public boolean isPlaylist() {
		return isPlaylist;
	}

	public Channel getChannel() {
		return channel;
	}

	public Preview getPreview() {
		return preview;
	}
}
