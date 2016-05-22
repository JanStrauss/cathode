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
