package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SearchGamesOptions implements Parameter {
	private final String query;
	private final String type = "suggest";
	private final Boolean live;

	public SearchGamesOptions(final String query) {
		this(query, false);
	}

	public SearchGamesOptions(final String query, final Boolean live) {
		this.query = query;
		this.live = live;
	}


	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();

		result.add(new BasicNameValuePair("type", type));

		if (query != null) {
			result.add(new BasicNameValuePair("query", query));
		}
		if (live != null) {
			result.add(new BasicNameValuePair("live", String.valueOf(live)));
		}

		return result;
	}
}
