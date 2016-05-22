package eu.over9000.cathode.data;

import java.util.Date;

public class Reaction {

	private final String id;
	private final Date createdAt;
	private final String emoteId;
	private final User user;

	public Reaction(final String id, final Date createdAt, final String emoteId, final User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.emoteId = emoteId;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reaction{" +
				"id='" + id + '\'' +
				", createdAt=" + createdAt +
				", emoteId='" + emoteId + '\'' +
				", user=" + user +
				'}';
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getEmoteId() {
		return emoteId;
	}

	public User getUser() {
		return user;
	}
}
