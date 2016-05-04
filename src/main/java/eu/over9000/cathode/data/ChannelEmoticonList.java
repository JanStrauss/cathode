package eu.over9000.cathode.data;

import java.util.List;

/**
 * Created by Jan on 05.05.2016.
 */
public class ChannelEmoticonList {

	private final List<ChannelEmoticon> emoticons;

	public ChannelEmoticonList(final List<ChannelEmoticon> emoticons) {
		this.emoticons = emoticons;
	}

	@Override
	public String toString() {
		return "ChannelEmoticonList{" +
				"emoticons=" + emoticons +
				'}';
	}

	public List<ChannelEmoticon> getEmoticons() {
		return emoticons;
	}
}
