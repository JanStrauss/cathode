package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SearchStreamsOptions implements Parameter {
	private final String query;
	private final Boolean hls;

	public SearchStreamsOptions(final String query) {
		this(query, false);
	}

	public SearchStreamsOptions(final String query, final Boolean hls) {
		this.query = query;
		this.hls = hls;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();


		if (query != null) {
			result.add(new BasicNameValuePair("query", query));
		}
		if (hls != null) {
			result.add(new BasicNameValuePair("hls", String.valueOf(hls)));
		}

		return result;
	}
}
