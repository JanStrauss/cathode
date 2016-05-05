package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class TopVideoOptions implements Parameter {
	private enum Period {week, month, all}

	private final String game;
	private final Period period;

	public TopVideoOptions() {
		game = null;
		period = null;
	}

	public TopVideoOptions(final String game) {
		this.game = game;
		this.period = null;
	}

	public TopVideoOptions(final String game, final Period period) {
		this.game = game;
		this.period = period;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		final List<NameValuePair> result = new ArrayList<>();

		if (game != null) {
			result.add(new BasicNameValuePair("game", game));
		}
		if (period != null) {
			result.add(new BasicNameValuePair("period", period.name()));
		}

		return result;
	}
}
