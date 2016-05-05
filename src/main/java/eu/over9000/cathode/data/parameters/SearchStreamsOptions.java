package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class SearchStreamsOptions implements Parameter {
	private final String query;
	private final boolean hls;

	public SearchStreamsOptions(final String query) {
		this(query, false);
	}

	public SearchStreamsOptions(final String query, final boolean hls) {
		this.query = query;
		this.hls = hls;
	}

	public boolean isHls() {
		return hls;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Arrays.asList(new BasicNameValuePair("query", query), new BasicNameValuePair("hls", String.valueOf(hls)));
	}
}
