package eu.over9000.cathode.data;

/**
 * Created by Jan on 05.05.2016.
 */
public class EmoticonData {
	private final long id;
	private final String code;

	public EmoticonData(final long id, final String code) {
		this.id = id;
		this.code = code;
	}

	@Override
	public String toString() {
		return "EmoticonData{" +
				"id=" + id +
				", code='" + code + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
}
