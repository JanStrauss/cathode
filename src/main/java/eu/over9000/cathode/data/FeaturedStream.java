package eu.over9000.cathode.data;

public class FeaturedStream {
	private final String text;

	private final String image;
	private final String title;
	private final boolean sponsored;
	private final long priority;
	private final boolean scheduled;
	private final Stream stream;

	public FeaturedStream(final String text, final String image, final String title, final boolean sponsored, final long priority, final boolean scheduled, final Stream stream) {
		this.text = text;
		this.image = image;
		this.title = title;
		this.sponsored = sponsored;
		this.priority = priority;
		this.scheduled = scheduled;
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "FeaturedStream{" +
				"text='" + text + '\'' +
				", image='" + image + '\'' +
				", title='" + title + '\'' +
				", sponsored=" + sponsored +
				", priority=" + priority +
				", scheduled=" + scheduled +
				", stream=" + stream +
				'}';
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public String getTitle() {
		return title;
	}

	public boolean isSponsored() {
		return sponsored;
	}

	public long getPriority() {
		return priority;
	}

	public boolean isScheduled() {
		return scheduled;
	}

	public Stream getStream() {
		return stream;
	}
}
