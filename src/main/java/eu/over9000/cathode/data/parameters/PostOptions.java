package eu.over9000.cathode.data.parameters;

import com.google.gson.Gson;

public class PostOptions {
	private static final Gson gson = new Gson();

	private final String content;
	private final boolean share;

	public PostOptions(final String content, final boolean share) {
		this.content = content;
		this.share = share;
	}

	public PostOptions(final String content) {
		this(content, false);
	}

	public String encode() {
		return gson.toJson(this);
	}
}
