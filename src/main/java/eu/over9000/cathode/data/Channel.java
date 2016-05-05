package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Channel {

	@SerializedName("_id")
	private final long id;
	private final boolean mature;
	private final boolean partner;
	private final Date createdAt;
	private final Date updatedAt;
	private final String name;
	private final String displayName;
	private final String logo;
	private final String status;
	private final String game;
	private final String broadcasterLanguage;
	private final String language;
	private final String banner;
	private final String videoBanner;
	private final String profileBanner;
	private final String url;
	private final String email;
	private final String streamKey;
	private final long followers;
	private final long views;


	public Channel(final long id, final boolean mature, final boolean partner, final Date createdAt, final Date updatedAt, final String name, final String displayName, final String logo, final String status, final String game, final String broadcasterLanguage, final String language, final String banner, final String videoBanner, final String profileBanner, final String url, final String email, final String streamKey, final long followers, final long views) {
		this.id = id;
		this.mature = mature;
		this.partner = partner;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
		this.displayName = displayName;
		this.logo = logo;
		this.status = status;
		this.game = game;
		this.broadcasterLanguage = broadcasterLanguage;
		this.language = language;
		this.banner = banner;
		this.videoBanner = videoBanner;
		this.profileBanner = profileBanner;
		this.url = url;
		this.email = email;
		this.streamKey = streamKey;
		this.followers = followers;
		this.views = views;
	}

	@Override
	public String toString() {
		return "Channel{" +
				"id=" + id +
				", mature=" + mature +
				", partner=" + partner +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", name='" + name + '\'' +
				", displayName='" + displayName + '\'' +
				", logo='" + logo + '\'' +
				", status='" + status + '\'' +
				", game='" + game + '\'' +
				", broadcasterLanguage='" + broadcasterLanguage + '\'' +
				", language='" + language + '\'' +
				", banner='" + banner + '\'' +
				", videoBanner='" + videoBanner + '\'' +
				", profileBanner='" + profileBanner + '\'' +
				", url='" + url + '\'' +
				", email='" + email + '\'' +
				", streamKey='" + streamKey + '\'' +
				", followers=" + followers +
				", views=" + views +
				'}';
	}

	public long getId() {
		return id;
	}

	public boolean isMature() {
		return mature;
	}

	public boolean isPartner() {
		return partner;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getLogo() {
		return logo;
	}

	public String getStatus() {
		return status;
	}

	public String getGame() {
		return game;
	}

	public String getBroadcasterLanguage() {
		return broadcasterLanguage;
	}

	public String getLanguage() {
		return language;
	}

	public String getBanner() {
		return banner;
	}

	public String getVideoBanner() {
		return videoBanner;
	}

	public String getProfileBanner() {
		return profileBanner;
	}

	public String getUrl() {
		return url;
	}

	public long getFollowers() {
		return followers;
	}

	public long getViews() {
		return views;
	}

	public String getEmail() {
		return email;
	}

	public String getStreamKey() {
		return streamKey;
	}
}
