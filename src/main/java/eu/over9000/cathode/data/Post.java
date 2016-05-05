package eu.over9000.cathode.data;

import java.util.Date;

/**
 * Created by Jan on 05.05.2016.
 */
public class Post {
	private final String id;
	private final Date createdAt;
	private final boolean deleted;
	//	private final  TODO List<Object> emotes;
	//	private final  TODO Map<String, Reaction> reactions
	private final String body;
	private final User user;

	public Post(String id, Date createdAt, boolean deleted, String body, User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.body = body;
		this.user = user;
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

	public String getBody() {
		return body;
	}

	public User getUser() {
		return user;
	}
}
