/*
 * Copyright (c) 2016 s1mpl3x <jan[at]over9000.eu>
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

package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.*;
import eu.over9000.cathode.resources.Channels;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class ChannelsImpl extends AbstractEndpoint implements Channels {

	public ChannelsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<Channel> getChannel() {
		return dispatcher.performGet(Channel.class, "channel");
	}

	@Override
	public Result<Channel> getChannel(final String channelName) {
		return dispatcher.performGet(Channel.class, Channels.PATH + "/" + channelName);
	}

	@Override
	public Result<FollowList> getFollows(final String channelName, final CursorPagination pagination, final Direction direction) {
		return dispatcher.performGet(FollowList.class, Channels.PATH + "/" + channelName + "/follows", pagination, direction);
	}

	@Override
	public Result<TeamList> getTeams(final String channelName) {
		return dispatcher.performGet(TeamList.class, Channels.PATH + "/" + channelName + "/teams");
	}

	@Override
	public Result<VideoList> getVideos(final String channelName, final OffsetPagination pagination, final ChannelVideoOptions options) {
		return dispatcher.performGet(VideoList.class, Channels.PATH + "/" + channelName + "/videos", pagination, options);
	}

	@Override
	public Result<UserList> getEditors(final String channelName) {
		return dispatcher.performGet(UserList.class, Channels.PATH + "/" + channelName + "/editors");
	}

	@Override
	public Result<SubscriptionList> getSubscriptions(final String channelName, final OffsetPagination pagination, final Direction direction) {
		return dispatcher.performGet(SubscriptionList.class, Channels.PATH + "/" + channelName + "/subscriptions", pagination, direction);
	}

	@Override
	public Result<Subscription> getSubscription(final String channelName, final String userName) {
		return dispatcher.performGet(Subscription.class, Channels.PATH + "/" + channelName + "/subscriptions/" + userName);
	}

	@Override
	public Result<Channel> deleteStreamKey(final String channelName) {
		return dispatcher.performDelete(Channel.class, Channels.PATH + "/" + channelName + "/stream_key");
	}

	@Override
	public Result<Void> postCommercial(final String channelName, final CommercialOption options) {
		return dispatcher.performPost(Void.class, Channels.PATH + "/" + channelName + "/commercial", new StringEntity(options.encode(), ContentType.APPLICATION_FORM_URLENCODED));
	}

	@Override
	public Result<Channel> putChannel(final String channelName, final ChannelOptions options) {
		return dispatcher.performPut(Channel.class, Channels.PATH + "/" + channelName, new StringEntity(options.encode(), ContentType.APPLICATION_JSON));
	}
}
