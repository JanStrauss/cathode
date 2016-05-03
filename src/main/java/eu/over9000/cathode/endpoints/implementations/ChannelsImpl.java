package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.Channel;
import eu.over9000.cathode.endpoints.Channels;

public class ChannelsImpl extends AbstractEndpoint implements Channels {

	public ChannelsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Response<Channel> getChannel() {
		return dispatcher.getAPIResponse(Channel.class, "channel");
	}

	@Override
	public Response<Channel> getChannel(final String channelName) {
		return dispatcher.getAPIResponse(Channel.class, Channels.PATH + channelName);
	}
}
