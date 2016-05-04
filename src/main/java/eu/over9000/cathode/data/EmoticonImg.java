package eu.over9000.cathode.data;

/**
 * Created by Jan on 05.05.2016.
 */
public class EmoticonImg {
	private final long emoticonSet;
	private final long height;
	private final long width;
	private final String url;

	public EmoticonImg(final long emoticonSet, final long height, final long width, final String url) {
		this.emoticonSet = emoticonSet;
		this.height = height;
		this.width = width;
		this.url = url;
	}

	@Override
	public String toString() {
		return "EmoticonImg{" +
				"emoticonSet=" + emoticonSet +
				", height=" + height +
				", width=" + width +
				", url='" + url + '\'' +
				'}';
	}

	public long getEmoticonSet() {
		return emoticonSet;
	}

	public long getHeight() {
		return height;
	}

	public long getWidth() {
		return width;
	}

	public String getUrl() {
		return url;
	}
}
