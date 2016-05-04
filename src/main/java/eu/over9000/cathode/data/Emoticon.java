package eu.over9000.cathode.data;

import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class Emoticon {

	private final String regex;
	private final List<EmoticonImg> images;

	public Emoticon(final String regex, final List<EmoticonImg> images) {
		this.regex = regex;
		this.images = images;
	}

	@Override
	public String toString() {
		return "Emoticon{" +
				"regex='" + regex + '\'' +
				", images=" + images +
				'}';
	}

	public String getRegex() {
		return regex;
	}

	public List<EmoticonImg> getImages() {
		return images;
	}
}
