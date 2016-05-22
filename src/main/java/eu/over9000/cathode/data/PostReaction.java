package eu.over9000.cathode.data;

import java.util.List;

public class PostReaction {
	private final long count;
	private final List<String> userIds;

	public PostReaction(final long count, final List<String> userIds) {
		this.count = count;
		this.userIds = userIds;
	}

	@Override
	public String toString() {
		return "PostReaction{" +
				"count=" + count +
				", userIds=" + userIds +
				'}';
	}

	public long getCount() {
		return count;
	}

	public List<String> getUserIds() {
		return userIds;
	}
}
