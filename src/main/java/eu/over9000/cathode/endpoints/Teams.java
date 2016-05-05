package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Team;
import eu.over9000.cathode.data.TeamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;

/**
 * <pre>
 * /teams                                      GET			getTeams(OffsetPagination pagination);
 * /teams/:team                                GET			getTeam(String teamName);
 * </pre>
 */
public interface Teams {

	String PATH = "teams";

	Result<TeamList> getTeams(OffsetPagination pagination);

	Result<Team> getTeam(String teamName);
}
