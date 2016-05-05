package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Block {
	@SerializedName("_id")
	private final long id;
	private final Date updatedAt;
	private final User user;

	public Block(final long id, final Date updatedAt, final User user) {
		this.id = id;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Block{" +
				"id=" + id +
				", updatedAt=" + updatedAt +
				", user=" + user +
				'}';
	}

	public long getId() {
		return id;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getUser() {
		return user;
	}
}
