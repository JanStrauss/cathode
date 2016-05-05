package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class StreamsQuery implements Parameter {

	private enum StreamType {all, playlist, live}

	private String game;
	private List<String> channels;
	private String clientId;
	private StreamType streamType;

	public StreamsQuery() {
	}

	public StreamsQuery(final String game, final List<String> channels, final String clientId, final StreamType streamType) {
		this.game = game;
		this.channels = channels;
		this.clientId = clientId;
		this.streamType = streamType;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();

		if (game != null) {
			result.add(new BasicNameValuePair("game", game));
		}
		if (channels != null && !channels.isEmpty()) {
			result.add(new BasicNameValuePair("channel", String.join(",", channels)));
		}
		if (clientId != null) {
			result.add(new BasicNameValuePair("client_id", clientId));
		}
		if (streamType != null) {
			result.add(new BasicNameValuePair("stream_typ=", streamType.name()));
		}

		return result;
	}
}
