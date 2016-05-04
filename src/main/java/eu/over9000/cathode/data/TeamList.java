package eu.over9000.cathode.data;

import java.util.List;

public class TeamList {

	private final List<Team> teams;

	public TeamList(final List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "TeamList{" +
				"teams=" + teams +
				'}';
	}

	public List<Team> getTeams() {
		return teams;
	}
}
