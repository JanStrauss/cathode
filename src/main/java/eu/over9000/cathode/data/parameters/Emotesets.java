package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class Emotesets implements Parameter {

	private final List<String> emoteSets;

	public Emotesets(final String... emoteSet) {
		this.emoteSets = Arrays.asList(emoteSet);
	}

	public Emotesets(final List<String> emoteSets) {
		this.emoteSets = emoteSets;
	}

	public List<String> getEmoteSets() {
		return emoteSets;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Collections.singletonList(new BasicNameValuePair("emotesets", String.join(",", emoteSets)));
	}
}
