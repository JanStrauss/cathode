package eu.over9000.cathode.data;

public class Fps {
	private final double audioOnly;
	private final double medium;
	private final double mobile;
	private final double high;
	private final double low;
	private final double chunked;

	public Fps(final double audioOnly, final double medium, final double mobile, final double high, final double low, final double chunked) {
		this.audioOnly = audioOnly;
		this.medium = medium;
		this.mobile = mobile;
		this.high = high;
		this.low = low;
		this.chunked = chunked;
	}

	@Override
	public String toString() {
		return "Fps{" +
				"audioOnly=" + audioOnly +
				", medium=" + medium +
				", mobile=" + mobile +
				", high=" + high +
				", low=" + low +
				", chunked=" + chunked +
				'}';
	}

	public double getAudioOnly() {
		return audioOnly;
	}

	public double getMedium() {
		return medium;
	}

	public double getMobile() {
		return mobile;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getChunked() {
		return chunked;
	}
}
