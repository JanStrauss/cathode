package eu.over9000.cathode.data;

import java.util.Date;

public class Follow {

	private final Date createdAt;
	private final boolean notifications;
	private final User user;

	public Follow(final Date createdAt, final boolean notifications, final User user) {
		this.createdAt = createdAt;
		this.notifications = notifications;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Follow{" +
				"createdAt=" + createdAt +
				", notifications=" + notifications +
				", user=" + user +
				'}';
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public User getUser() {
		return user;
	}
}
