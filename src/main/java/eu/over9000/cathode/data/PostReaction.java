package eu.over9000.cathode.data;

import java.util.List;

public class PostReaction {
	private final String emote;
	private final long count;
	private final List<Long> userIds;

	public PostReaction(final String emote, final long count, final List<Long> userIds) {
		this.emote = emote;
		this.count = count;
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "PostReaction{" +
				"emote='" + emote + '\'' +
				", count=" + count +
				", userIds=" + userIds +
				'}';
	}

	public String getEmote() {
		return emote;
	}

	public long getCount() {
		return count;
	}

	public List<Long> getUserIds() {
		return userIds;
	}
}
