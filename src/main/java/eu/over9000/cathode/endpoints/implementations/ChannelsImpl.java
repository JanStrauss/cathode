package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.ChannelVideoOptions;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.data.parameters.Direction;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.endpoints.Channels;

public class ChannelsImpl extends AbstractEndpoint implements Channels {

	public ChannelsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<Channel> getChannel() {
		return dispatcher.getAPIResponse(Channel.class, "channel");
	}

	@Override
	public Result<Channel> getChannel(final String channelName) {
		return dispatcher.getAPIResponse(Channel.class, Channels.PATH + "/" + channelName);
	}

	@Override
	public Result<FollowList> getFollows(final String channelName, final CursorPagination pagination, final Direction direction) {
		return dispatcher.getAPIResponse(FollowList.class, Channels.PATH + "/" + channelName + "/follows", pagination, direction);
	}

	@Override
	public Result<TeamList> getTeams(final String channelName) {
		return dispatcher.getAPIResponse(TeamList.class, Channels.PATH + "/" + channelName + "/teams");
	}

	@Override
	public Result<VideoList> getVideos(final String channelName, final OffsetPagination pagination, final ChannelVideoOptions options) {
		return dispatcher.getAPIResponse(VideoList.class, Channels.PATH + "/" + channelName + "/videos", pagination, options);
	}

	@Override
	public Result<UserList> getEditors(final String channelName) {
		return dispatcher.getAPIResponse(UserList.class, Channels.PATH + "/" + channelName + "/editors");
	}

	@Override
	public Result<SubscriptionList> getSubscriptions(final String channelName, final OffsetPagination pagination, final Direction direction) {
		return dispatcher.getAPIResponse(SubscriptionList.class, Channels.PATH + "/" + channelName + "/subscriptions", pagination, direction);
	}

	@Override
	public Result<Subscription> getSubscription(final String channelName, final String userName) {
		return dispatcher.getAPIResponse(Subscription.class, Channels.PATH + "/" + channelName + "/subscriptions/" + userName);
	}
}
