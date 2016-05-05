package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;
import java.util.List;

public class GetFollowsSortBy implements Parameter {

	private enum SortBy {created_at, last_broadcast, login}

	private SortBy sortby = SortBy.created_at;

	public GetFollowsSortBy() {
	}

	public GetFollowsSortBy(final SortBy sortby) {
		this.sortby = sortby;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {
		if (sortby == null) {
			return Collections.emptyList();
		}
		return Collections.singletonList(new BasicNameValuePair("sortby", sortby.name()));
	}

}
