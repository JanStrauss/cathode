package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class PutFollowsOptions implements Parameter {

	private boolean notifications = false;

	public PutFollowsOptions() {
	}

	public PutFollowsOptions(final boolean notifications) {
		this.notifications = notifications;
	}

	public boolean isNotifications() {
		return notifications;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		return Collections.singletonList(new BasicNameValuePair("notifications", String.valueOf(notifications)));
	}
}
