package eu.over9000.cathode.data;

public class Resolutions {
	private final String medium;
	private final String mobile;
	private final String high;
	private final String low;
	private final String chunked;

	public Resolutions(final String medium, final String mobile, final String high, final String low, final String chunked) {
		this.medium = medium;
		this.mobile = mobile;
		this.high = high;
		this.low = low;
		this.chunked = chunked;
	}

	@Override
	public String toString() {
		return "Resolutions{" +
				"medium='" + medium + '\'' +
				", mobile='" + mobile + '\'' +
				", high='" + high + '\'' +
				", low='" + low + '\'' +
				", chunked='" + chunked + '\'' +
				'}';
	}

	public String getMedium() {
		return medium;
	}

	public String getMobile() {
		return mobile;
	}

	public String getHigh() {
		return high;
	}

	public String getLow() {
		return low;
	}

	public String getChunked() {
		return chunked;
	}
}
