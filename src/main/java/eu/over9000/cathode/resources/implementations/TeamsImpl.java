package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Team;
import eu.over9000.cathode.data.TeamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.resources.Teams;

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
