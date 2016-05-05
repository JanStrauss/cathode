package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

public class Game {
	private final String name;
	private final Image box;
	private final Image logo;
	@SerializedName("_id")
	private final long id;
	private final long giantbombId;

	public Game(final String name, final Image box, final Image logo, final long id, final long giantbombId) {
		this.name = name;
		this.box = box;
		this.logo = logo;
		this.id = id;
		this.giantbombId = giantbombId;
	}


	@Override
	public String toString() {
		return "Game{" +
				"name='" + name + '\'' +
				", box=" + box +
				", logo=" + logo +
				", id=" + id +
				", giantbombId=" + giantbombId +
				'}';
	}

	public String getName() {
		return name;
	}

	public Image getBox() {
		return box;
	}

	public Image getLogo() {
		return logo;
	}

	public long getId() {
		return id;
	}

	public long getGiantbombId() {
		return giantbombId;
	}
}
