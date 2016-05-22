package eu.over9000.cathode.data;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Post {
	private final String id;
	private final Date createdAt;
	private final boolean deleted;
	private final List<Object> emotes;
	private final Map<String, PostReaction> reactions;
	private final String body;
	private final User user;

	public Post(final String id, final Date createdAt, final boolean deleted, final List<Object> emotes, final Map<String, PostReaction> reactions, final String body, final User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.emotes = emotes;
		this.reactions = reactions;
		this.body = body;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id='" + id + '\'' +
				", createdAt=" + createdAt +
				", deleted=" + deleted +
				", emotes=" + emotes +
				", reactions=" + reactions +
				", body='" + body + '\'' +
				", user=" + user +
				'}';
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public List<Object> getEmotes() {
		return emotes;
	}

	public Map<String, PostReaction> getReactions() {
		return reactions;
	}

	public String getBody() {
		return body;
	}

	public User getUser() {
		return user;
	}
}
