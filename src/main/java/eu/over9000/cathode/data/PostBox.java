package eu.over9000.cathode.data;

public class PostBox {

	private final Post post;
	private final String tweet;

	public PostBox(final Post post, final String tweet) {
		this.post = post;
		this.tweet = tweet;
	}

	@Override
	public String toString() {
		return "PostBox{" +
				"post=" + post +
				", tweet='" + tweet + '\'' +
				'}';
	}

	public Post getPost() {
		return post;
	}

	public String getTweet() {
		return tweet;
	}
}
