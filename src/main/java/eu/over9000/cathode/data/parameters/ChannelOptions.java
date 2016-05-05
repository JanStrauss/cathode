package eu.over9000.cathode.data.parameters;

import com.google.gson.Gson;

public class ChannelOptions {
	private static final Gson gson = new Gson();

	private final String status;
	private final String game;
	private final Long deplay;
	private final Boolean channelFeedEnabled;

	public ChannelOptions(final Long deplay) {
		this.status = null;
		this.game = null;
		this.deplay = deplay;
		this.channelFeedEnabled = null;
	}

	public ChannelOptions(final Boolean channelFeedEnabled) {
		this.status = null;
		this.game = null;
		this.deplay = null;
		this.channelFeedEnabled = channelFeedEnabled;
	}

	public ChannelOptions(final String status, final String game, final Long deplay, final Boolean channelFeedEnabled) {
		this.status = status;
		this.game = game;
		this.deplay = deplay;
		this.channelFeedEnabled = channelFeedEnabled;
	}

	public ChannelOptions(final String status, final String game) {
		this.status = status;
		this.game = game;
		this.deplay = null;
		this.channelFeedEnabled = null;
	}

	public String encode() {
		return gson.toJson(new ChannelWrapper(this));
	}

	private class ChannelWrapper {
		private final ChannelOptions channel;

		public ChannelWrapper(final ChannelOptions channel) {
			this.channel = channel;
		}
	}
}
