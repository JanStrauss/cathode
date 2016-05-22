package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.TopGameList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.endpoints.Games;

public class GamesImpl extends AbstractEndpoint implements Games {
	public GamesImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<TopGameList> getTopGames(final OffsetPagination pagination) {
		return dispatcher.performGet(TopGameList.class, Games.PATH + "/top", pagination);
	}
}
