package eu.over9000.cathode.data;

import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class EmoticonList {

	private final List<Emoticon> emoticons;

	public EmoticonList(final List<Emoticon> emoticons) {
		this.emoticons = emoticons;
	}

	@Override
	public String toString() {
		return "EmoticonList{" +
				"emoticons=" + emoticons +
				'}';
	}

	public List<Emoticon> getEmoticons() {
		return emoticons;
	}
}
