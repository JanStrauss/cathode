package eu.over9000.cathode.data;

/**
 * Created by Jan on 05.05.2016.
 */
public class ChannelEmoticon {

	private final long width;
	private final long height;
	private final String regex;
	private final String state;
	private final boolean subscriberOnly;
	private final String url;

	public ChannelEmoticon(final long width, final long height, final String regex, final String state, final boolean subscriberOnly, final String url) {
		this.width = width;
		this.height = height;
		this.regex = regex;
		this.state = state;
		this.subscriberOnly = subscriberOnly;
		this.url = url;
	}

	@Override
	public String toString() {
		return "ChannelEmoticon{" +
				"width=" + width +
				", height=" + height +
				", regex='" + regex + '\'' +
				", state='" + state + '\'' +
				", subscriberOnly=" + subscriberOnly +
				", url='" + url + '\'' +
				'}';
	}

	public long getWidth() {
		return width;
	}

	public long getHeight() {
		return height;
	}

	public String getRegex() {
		return regex;
	}

	public String getState() {
		return state;
	}

	public boolean isSubscriberOnly() {
		return subscriberOnly;
	}

	public String getUrl() {
		return url;
	}
}
