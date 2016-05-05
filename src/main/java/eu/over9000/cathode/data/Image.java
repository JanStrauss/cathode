package eu.over9000.cathode.data;

public class Image {

	private final String small;
	private final String medium;
	private final String large;
	private final String template;

	public Image(final String small, final String medium, final String large, final String template) {
		this.small = small;
		this.medium = medium;
		this.large = large;
		this.template = template;
	}

	@Override
	public String toString() {
		return "Image{" +
				"small='" + small + '\'' +
				", medium='" + medium + '\'' +
				", large='" + large + '\'' +
				", template='" + template + '\'' +
				'}';
	}

	public String getSmall() {
		return small;
	}

	public String getMedium() {
		return medium;
	}

	public String getLarge() {
		return large;
	}

	public String getTemplate() {
		return template;
	}
}
