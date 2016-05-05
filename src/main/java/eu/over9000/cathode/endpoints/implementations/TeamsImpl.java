package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Team;
import eu.over9000.cathode.data.TeamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.endpoints.Teams;

/**
 * Created by Jan on 05.05.2016.
 */
public class TeamsImpl extends AbstractEndpoint implements Teams {
	public TeamsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<TeamList> getTeams(final OffsetPagination pagination) {
		return dispatcher.performGet(TeamList.class, Teams.PATH, pagination);
	}

	@Override
	public Result<Team> getTeam(final String teamName) {
		return dispatcher.performGet(Team.class, Teams.PATH + "/" + teamName);
	}
}