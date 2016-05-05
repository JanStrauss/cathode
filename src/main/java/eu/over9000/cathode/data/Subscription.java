package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Subscription {

	@SerializedName("_id")
	private final String id;
	private final User user;
	private final Channel channel;
	private final Date createdAt;

	public Subscription(final String id, final Channel channel, final Date createdAt) {
		this.id = id;
		this.user = null;
		this.channel = channel;
		this.createdAt = createdAt;
	}

	public Subscription(final String id, final User user, final Date createdAt) {
		this.id = id;
		this.user = user;
		this.channel = null;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Subscription{" +
				"id='" + id + '\'' +
				", user=" + user +
				", channel=" + channel +
				", createdAt=" + createdAt +
				'}';
	}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Channel getChannel() {
		return channel;
	}
}
