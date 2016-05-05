package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.List;

public class SearchGamesOptions implements Parameter {
	private final String query;
	private final String type = "suggest";
	private final boolean live;

	public SearchGamesOptions(final String query) {
		this(query, false);
	}

	public SearchGamesOptions(final String query, final boolean live) {
		this.query = query;
		this.live = live;
	}

	public String getQuery() {
		return query;
	}

	public String getType() {
		return type;
	}

	public boolean isLive() {
		return live;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Arrays.asList(new BasicNameValuePair("query", query), new BasicNameValuePair("type", type), new BasicNameValuePair("live", String.valueOf(live)));
	}
}
