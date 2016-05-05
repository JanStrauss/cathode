package eu.over9000.cathode;

import eu.over9000.cathode.endpoints.*;
import eu.over9000.cathode.endpoints.implementations.*;

public class Twitch {
	public static final String API_BASE_URL = "https://api.twitch.tv/kraken";

	private final String clientID;
	private final String authToken;

	public final Channels channels;
	public final Chat chat;
	public final Feed feed;
	public final Games games;
	public final Ingests ingests;
	public final Root root;
	public final Streams streams;
	public final Search search;
	public final Teams teams;
	public final Users users;
	public final Videos videos;


	public Twitch(final String clientID) {
		this(clientID, null);
	}

	public Twitch(final String clientID, final String authToken) {
		this.clientID = clientID;
		this.authToken = authToken;

		final Dispatcher dispatcher = new Dispatcher(clientID, authToken);

		channels = new ChannelsImpl(dispatcher);
		chat = new ChatImpl(dispatcher);
		feed = new FeedImpl(dispatcher);
		games = new GamesImpl(dispatcher);
		ingests = new IngestsImpl(dispatcher);
		root = new RootImpl(dispatcher);
		search = new SearchImpl(dispatcher);
		streams = new StreamsImpl(dispatcher);
		teams = null;
		users = null;
		videos = null;

	}

	public String getClientID() {
		return clientID;
	}

	public String getAuthToken() {
		return authToken;
	}

}