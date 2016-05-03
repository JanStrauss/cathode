package eu.over9000.cathode;

import eu.over9000.cathode.endpoints.Channels;
import eu.over9000.cathode.endpoints.Streams;
import eu.over9000.cathode.endpoints.implementations.ChannelsImpl;
import eu.over9000.cathode.endpoints.implementations.StreamsImpl;

public class Twitch {
	public static final String API_BASE_URL = "https://api.twitch.tv/kraken";

	private final String clientID;
	private final String authToken;

	private final Channels channels;
	private final Streams streams;


	public Twitch(final String clientID) {
		this(clientID, null);
	}

	public Twitch(final String clientID, final String authToken) {
		this.clientID = clientID;
		this.authToken = authToken;

		final Dispatcher dispatcher = new Dispatcher(clientID, authToken);

		channels = new ChannelsImpl(dispatcher);
		streams = new StreamsImpl(dispatcher);
	}

	public String getClientID() {
		return clientID;
	}

	public String getAuthToken() {
		return authToken;
	}

	public Channels channels() {
		return channels;
	}

	public Streams streams() {
		return streams;
	}

}