package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.Channel;
import eu.over9000.cathode.data.FollowList;
import eu.over9000.cathode.data.parameters.CursorPagination;

/**
 * <pre>
 * /channel                                    GET
 * /channels/:channel                          GET
 * /channels/:channel                          PUT
 * /channels/:channel/commercial               POST
 * /channels/:channel/editors                  GET
 * /channels/:channel/follows                  GET
 * /channels/:channel/stream_key               DELETE
 * /channels/:channel/subscriptions            GET
 * /channels/:channel/subscriptions/:user      GET
 * /channels/:channel/teams                    GET
 * /channels/:channel/videos                   GET
 * </pre>
 */
public interface Channels {

	String PATH = "channels";

	//	GET 		/channel 						Get channel object
	Response<Channel> getChannel();

	//	GET 		/channels/:channel 				Get channel object
	Response<Channel> getChannel(String channelName);

	//	GET 		/channels/:channel/follows		Get channel's list of following users
	Response<FollowList> getFollows(String channelName, CursorPagination pagination);

	//	GET 		/channels/:channel/videos		Get channel's list of videos
	//	GET 		/channels/:channel/editors		Get channel's list of editors
	//	PUT 		/channels/:channel				Update channel object
	//	DELETE 		/channels/:channel/stream_key	Reset channel's stream key
	//	POST 		/channels/:channel/commercial	Start a commercial on channel
	//	GET 		/channels/:channel/teams		Get list of teams channel belongs to
}
