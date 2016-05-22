/*
 * Copyright (c) 2014-2016 s1mpl3x <jan[at]over9000.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.over9000.cathode;

import eu.over9000.cathode.resources.*;
import eu.over9000.cathode.resources.additional.ImageUtil;
import eu.over9000.cathode.resources.additional.Undocumented;
import eu.over9000.cathode.resources.implementations.*;

import java.net.URI;

public class Twitch {
	public static final String API_BASE_URL = "https://api.twitch.tv/kraken";
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
	public final Undocumented undocumented;
	public final ImageUtil imageUtil;
	private final String clientID;
	private final String authToken;

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
		teams = new TeamsImpl(dispatcher);
		users = new UsersImpl(dispatcher);
		videos = new VideosImpl(dispatcher);

		undocumented = new UndocumentedImpl(dispatcher);
		imageUtil = new ImageUtilImpl(dispatcher);
	}

	public static URI buildTokenAuthURI(final String clientId, final String authRedirect, final String... authScopes) {
		return AuthUtil.buildTokenAuthURI(clientId, authRedirect, authScopes);
	}

	public String getClientID() {
		return clientID;
	}

	public String getAuthToken() {
		return authToken;
	}
}