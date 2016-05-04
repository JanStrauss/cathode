package eu.over9000.cathode.data;

/**
 * Created by Jan on 05.05.2016.
 */
public class EmoticonDataExt extends EmoticonData {

	private final long emoticonSet;

	public EmoticonDataExt(final long id, final String code, final long emoticonSet) {
		super(id, code);
		this.emoticonSet = emoticonSet;
	}


	@Override
	public String toString() {
		return "EmoticonDataExt{" +
				"emoticonSet=" + emoticonSet +
				"} ";
	}

	public long getEmoticonSet() {
		return emoticonSet;
	}
}
