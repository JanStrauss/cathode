package eu.over9000.cathode.data;

public class Thumbnail {

	private final String url;
	private final String type;

	public Thumbnail(final String url, final String type) {
		this.url = url;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Thumbnail{" +
				"url='" + url + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}
}
