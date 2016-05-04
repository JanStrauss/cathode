package eu.over9000.cathode.data;

public class ChannelName {

	private final String name;
	private final String displayName;

	public ChannelName(final String name, final String displayName) {
		this.name = name;
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "ChannelName{" +
				"name='" + name + '\'' +
				", displayName='" + displayName + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}
}
