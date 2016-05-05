package eu.over9000.cathode.data;

public class PanelData {

	private final String link;
	private final String image;
	private final String title;
	private final String description;

	public PanelData(final String link, final String image, final String title, final String description) {
		this.link = link;
		this.image = image;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "PanelData{" +
				"link='" + link + '\'' +
				", image='" + image + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public String getLink() {
		return link;
	}

	public String getImage() {
		return image;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
