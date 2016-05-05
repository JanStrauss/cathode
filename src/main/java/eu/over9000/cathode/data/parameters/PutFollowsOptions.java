package eu.over9000.cathode.data.parameters;

public class PutFollowsOptions {

	private boolean notifications = false;

	public PutFollowsOptions() {
	}

	public PutFollowsOptions(final boolean notifications) {
		this.notifications = notifications;
	}

	public String encode() {
		return "notifications=" + notifications;
	}
}
