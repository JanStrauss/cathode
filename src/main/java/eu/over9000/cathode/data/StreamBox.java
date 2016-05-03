package eu.over9000.cathode.data;

public class StreamBox {

	private final Stream stream;

	public StreamBox(final Stream stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "StreamBox{" +
				"stream=" + stream +
				'}';
	}

	public boolean isOnline() {
		return stream != null;
	}

	public Stream getStream() {
		return stream;
	}
}
