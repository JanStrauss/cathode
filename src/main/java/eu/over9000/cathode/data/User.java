package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
	@SerializedName("_id")
	private final long id;
	private final String name;
	private final Date createdAt;
	private final Date updatedAt;
	private final String displayName;
	private final String logo;
	private final String bio;
	private final String type;

	public User(final long id, final String name, final Date createdAt, final Date updatedAt, final String displayName, final String logo, final String bio, final String type) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.displayName = displayName;
		this.logo = logo;
		this.bio = bio;
		this.type = type;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", displayName='" + displayName + '\'' +
				", logo='" + logo + '\'' +
				", bio='" + bio + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getLogo() {
		return logo;
	}

	public String getBio() {
		return bio;
	}

	public String getType() {
		return type;
	}
}
