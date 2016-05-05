package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.ChannelList;
import eu.over9000.cathode.data.GameList;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.SearchChannelOptions;
import eu.over9000.cathode.data.parameters.SearchGamesOptions;
import eu.over9000.cathode.data.parameters.SearchStreamsOptions;
import eu.over9000.cathode.endpoints.Search;

/**
 * Created by Jan on 05.05.2016.
 */
public class SearchImpl extends AbstractEndpoint implements Search {

	public SearchImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<ChannelList> getChannels(final SearchChannelOptions options, final OffsetPagination pagination) {
		return dispatcher.getAPIResponse(ChannelList.class, Search.PATH + "/channels", options, pagination);
	}

	@Override
	public Result<GameList> getGames(final SearchGamesOptions options) {
		return dispatcher.getAPIResponse(GameList.class, Search.PATH + "/games", options);
	}

	@Override
	public Result<StreamList> getStreams(final SearchStreamsOptions options, final OffsetPagination pagination) {
		return dispatcher.getAPIResponse(StreamList.class, Search.PATH + "/streams", options, pagination);
	}
}
