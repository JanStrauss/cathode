package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class GameList implements PaginatedContainer<Game> {

	@SerializedName("_total")
	private final long total;
	private final List<Game> games;

	public GameList(final long total, final List<Game> games) {
		this.total = total;
		this.games = games;
	}

	@Override
	public String toString() {
		return "GameList{" +
				"total=" + total +
				", games=" + games +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Game> getGames() {
		return games;
	}

	@Override
	public List<Game> getChunk() {
		return games;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return games.isEmpty();
	}
}
