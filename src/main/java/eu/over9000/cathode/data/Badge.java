package eu.over9000.cathode.data;

/**
 * Created by Jan on 04.05.2016.
 */
public class Badge {

	private final String alpha;
	private final String image;
	private final String svg;

	public Badge(final String alpha, final String image, final String svg) {
		this.alpha = alpha;
		this.image = image;
		this.svg = svg;
	}

	@Override
	public String toString() {
		return "Badge{" +
				"alpha='" + alpha + '\'' +
				", image='" + image + '\'' +
				", svg='" + svg + '\'' +
				'}';
	}

	public String getAlpha() {
		return alpha;
	}

	public String getImage() {
		return image;
	}

	public String getSvg() {
		return svg;
	}
}
