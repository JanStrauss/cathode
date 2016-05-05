package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class ChannelVideoOptions implements Parameter {

	private Boolean broadcasts;
	private Boolean hls;

	public ChannelVideoOptions() {
	}

	public ChannelVideoOptions(final Boolean broadcasts, final Boolean hls) {
		this.broadcasts = broadcasts;
		this.hls = hls;
	}

	public boolean isBroadcasts() {
		return broadcasts;
	}

	public boolean isHls() {
		return hls;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {

		final List<NameValuePair> result = new ArrayList<>();

		if (broadcasts != null) {
			result.add(new BasicNameValuePair("broadcasts", String.valueOf(broadcasts)));
		}
		if (hls != null) {
			result.add(new BasicNameValuePair("hls", String.valueOf(hls)));
		}

		return result;

	}
}
