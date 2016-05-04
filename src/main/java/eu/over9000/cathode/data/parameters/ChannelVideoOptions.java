package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jan on 04.05.2016.
 */
public class ChannelVideoOptions implements Parameter {

	private boolean broadcasts = false;
	private boolean hls = false;

	public ChannelVideoOptions() {
	}

	public ChannelVideoOptions(final boolean broadcasts, final boolean hls) {
		this.broadcasts = broadcasts;
		this.hls = hls;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Arrays.asList(new BasicNameValuePair("broadcasts", String.valueOf(broadcasts)), new BasicNameValuePair("hls", String.valueOf(hls)));
	}
}
