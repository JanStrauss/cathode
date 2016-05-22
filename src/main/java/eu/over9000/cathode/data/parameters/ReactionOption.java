package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

public class ReactionOption implements Parameter {

	private String value = "endorse";

	public ReactionOption(final long emoteId) {
		this.value = String.valueOf(emoteId);
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Collections.singletonList(new BasicNameValuePair("emote_id", value));
	}
}
