package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;

public class Ingest {

	private final String name;
	private final double availability;
	@SerializedName("_id")
	private final long id;
	@SerializedName("default")
	private final boolean isDefault;
	private final String urlTemplate;

	public Ingest(final String name, final double availability, final long id, final boolean isDefault, final String urlTemplate) {
		this.name = name;
		this.availability = availability;
		this.id = id;
		this.isDefault = isDefault;
		this.urlTemplate = urlTemplate;
	}

	@Override
	public String toString() {
		return "Ingest{" +
				"name='" + name + '\'' +
				", availability=" + availability +
				", id=" + id +
				", isDefault=" + isDefault +
				", urlTemplate='" + urlTemplate + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public double getAvailability() {
		return availability;
	}

	public long getId() {
		return id;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public String getUrlTemplate() {
		return urlTemplate;
	}
}
