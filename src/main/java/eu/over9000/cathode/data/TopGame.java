package eu.over9000.cathode.data;

/**
 * Created by Jan on 05.05.2016.
 */
public class TopGame {

	private final Game game;
	private final long viewers;
	private final long channels;

	public TopGame(final Game game, final long viewers, final long channels) {
		this.game = game;
		this.viewers = viewers;
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "TopGame{" +
				"game=" + game +
				", viewers=" + viewers +
				", channels=" + channels +
				'}';
	}

	public Game getGame() {
		return game;
	}

	public long getViewers() {
		return viewers;
	}

	public long getChannels() {
		return channels;
	}
}
