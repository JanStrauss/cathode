package eu.over9000.cathode.data;

public class StreamSummary {

	private final long channels;
	private final long viewers;

	public StreamSummary(final long channels, final long viewers) {
		this.channels = channels;
		this.viewers = viewers;
	}

	@Override
	public String toString() {
		return "StreamSummary{" +
				"channels=" + channels +
				", viewers=" + viewers +
				'}';
	}

	public long getChannels() {
		return channels;
	}

	public long getViewers() {
		return viewers;
	}
}
