package eu.over9000.cathode.data;

import java.util.List;

public class FeaturedStreams {

	private final List<FeaturedStream> featured;

	public FeaturedStreams(final List<FeaturedStream> featured) {
		this.featured = featured;
	}

	@Override
	public String toString() {
		return "FeaturedStreamBox{" +
				"featured=" + featured +
				'}';
	}

	public List<FeaturedStream> getFeatured() {
		return featured;
	}
}
