package eu.over9000.cathode.data;

import java.util.List;
import java.util.Map;

public class EmoticonImages {
	private final List<EmoticonDataExt> emoticons;
	private final Map<String, List<EmoticonData>> emoticonSets;

	public EmoticonImages(final List<EmoticonDataExt> emoticons, final Map<String, List<EmoticonData>> emoticonSets) {
		this.emoticons = emoticons;
		this.emoticonSets = emoticonSets;
	}

	@Override
	public String toString() {
		return "EmoticonImages{" +
				"emoticons=" + emoticons +
				", emoticonSets=" + emoticonSets +
				'}';
	}

	public Map<String, List<EmoticonData>> getEmoticonSets() {
		return emoticonSets;
	}

	public List<EmoticonDataExt> getEmoticons() {
		return emoticons;
	}
}