package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

public class StreamTypeOption implements Parameter {
	private enum StreamType {all, playlist, live}

	private StreamType streamType;

	public StreamTypeOption() {
	}

	public StreamTypeOption(final StreamType streamType) {
		this.streamType = streamType;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		if (streamType == null) {
			return Collections.emptyList();
		}
		return Collections.singletonList(new BasicNameValuePair("stream_type", streamType.name()));
	}
}
