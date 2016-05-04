package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Jan on 04.05.2016.
 */
public class Subscription {

	@SerializedName("_id")
	private final String id;
	private final User user;
	private final Date createdAt;

	public Subscription(final String id, final User user, final Date createdAt) {
		this.id = id;
		this.user = user;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Subscription{" +
				"id='" + id + '\'' +
				", user=" + user +
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
}
