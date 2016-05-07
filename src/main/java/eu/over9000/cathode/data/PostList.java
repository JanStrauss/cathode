package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class PostList implements PaginatedContainer<Post> {

	@SerializedName("_total")
	private final long total;
	@SerializedName("_cursor")
	private final String cursor;
	private final List<Post> posts;

	public PostList(final long total, final String cursor, final List<Post> posts) {
		this.total = total;
		this.cursor = cursor;
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "PostList{" +
				"total=" + total +
				", cursor='" + cursor + '\'' +
				", posts=" + posts +
				'}';
	}

	@Override
	public long getTotal() {
		return total;
	}

	@Override
	public String getCursor() {
		return cursor;
	}

	@Override
	public List<Post> getChunk() {
		return posts;
	}

	@Override
	public boolean isEmpty() {
		return posts == null || posts.isEmpty();
	}

	public List<Post> getPosts() {
		return posts;
	}
}
