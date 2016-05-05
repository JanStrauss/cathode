package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.ChannelVideoOptions;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.data.parameters.Direction;
import eu.over9000.cathode.data.parameters.OffsetPagination;

/**
 * <pre>
 * /channel                                    GET			getChannel()
 * /channels/:channel                          GET			getChannel(String channelName)
 * /channels/:channel                          PUT			// TODO
 * /channels/:channel/commercial               POST			// TODO
 * /channels/:channel/editors                  GET			getEditors(String channelName);
 * /channels/:channel/follows                  GET			getFollows(String channelName, CursorPagination pagination)
 * /channels/:channel/stream_key               DELETE		// TODO
 * /channels/:channel/subscriptions            GET			getSubscriptions(String channelName, OffsetPagination pagination, Direction direction);
 * /channels/:channel/subscriptions/:user      GET			getSubscription(String channelName, String userName);
 * /channels/:channel/teams                    GET			getUsers(String channelName)
 * /channels/:channel/videos                   GET			getVideos(String channelName, OffsetPagination pagination, ChannelVideoOptions options)
 * </pre>
 */
public interface Channels {

	String PATH = "channels";

	Result<Channel> getChannel();

	Result<Channel> getChannel(String channelName);

	Result<FollowList> getFollows(String channelName, CursorPagination pagination, Direction direction);

	Result<TeamList> getTeams(String channelName);

	Result<VideoList> getVideos(String channelName, OffsetPagination pagination, ChannelVideoOptions options);

	Result<UserList> getEditors(String channelName);

	Result<SubscriptionList> getSubscriptions(String channelName, OffsetPagination pagination, Direction direction);

	Result<Subscription> getSubscription(String channelName, String userName);

}