package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

public class Panel {

	@SerializedName("_id")
	private final long id;
	private final long displayOrder;
	private final String kind;
	private final String htmlDescription;
	private final long userId;
	private final PanelData data;
	private final String channel;

	public Panel(final long id, final long displayOrder, final String kind, final String htmlDescription, final long userId, final PanelData data, final String channel) {
		this.id = id;
		this.displayOrder = displayOrder;
		this.kind = kind;
		this.htmlDescription = htmlDescription;
		this.userId = userId;
		this.data = data;
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Panel{" +
				"id=" + id +
				", displayOrder=" + displayOrder +
				", kind='" + kind + '\'' +
				", htmlDescription='" + htmlDescription + '\'' +
				", userId=" + userId +
				", data=" + data +
				", channel='" + channel + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public long getDisplayOrder() {
		return displayOrder;
	}

	public String getKind() {
		return kind;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public long getUserId() {
		return userId;
	}

	public PanelData getData() {
		return data;
	}

	public String getChannel() {
		return channel;
	}
}
