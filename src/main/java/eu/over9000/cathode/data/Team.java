package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Team {
	@SerializedName("_id")
	private final long id;
	private final String name;
	private final String info;
	private final String displayName;
	private final Date createdAt;
	private final Date updatedAt;
	private final String logo;
	private final String banner;
	private final String background;

	public Team(final long id, final String name, final String info, final String displayName, final Date createdAt, final Date updatedAt, final String logo, final String banner, final String background) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.displayName = displayName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.logo = logo;
		this.banner = banner;
		this.background = background;
	}

	@Override
	public String toString() {
		return "Team{" +
				"id=" + id +
				", name='" + name + '\'' +
				", info='" + info + '\'' +
				", displayName='" + displayName + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", logo='" + logo + '\'' +
				", banner='" + banner + '\'' +
				", background='" + background + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getLogo() {
		return logo;
	}

	public String getBanner() {
		return banner;
	}

	public String getBackground() {
		return background;
	}
}
