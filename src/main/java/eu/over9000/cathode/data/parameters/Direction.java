package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jan on 04.05.2016.
 */
public class Direction implements Parameter {

	private enum Directions {ASC, DESC;}

	private Directions direction = Directions.DESC;

	public Direction(final Directions direction) {
		this.direction = direction;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Collections.singletonList(new BasicNameValuePair("direction", direction.name()));
	}
}
