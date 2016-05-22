package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Badges;
import eu.over9000.cathode.data.ChannelEmoticonList;
import eu.over9000.cathode.data.EmoticonImages;
import eu.over9000.cathode.data.EmoticonList;
import eu.over9000.cathode.data.parameters.Emotesets;
import eu.over9000.cathode.resources.Chat;

public class ChatImpl extends AbstractEndpoint implements Chat {

	public ChatImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<Badges> getBadges(final String channelName) {
		return dispatcher.performGet(Badges.class, Chat.PATH + "/" + channelName + "/badges");
	}

	@Override
	public Result<ChannelEmoticonList> getEmoticons(final String channelName) {
		return dispatcher.performGet(ChannelEmoticonList.class, Chat.PATH + "/" + channelName + "/emoticons");
	}

	@Override
	public Result<EmoticonList> getEmoticons() {
		return dispatcher.performGet(EmoticonList.class, Chat.PATH + "/emoticons");
	}

	@Override
	public Result<EmoticonImages> getEmoticonImages(final Emotesets emotesets) {
		return dispatcher.performGet(EmoticonImages.class, Chat.PATH + "/emoticon_images", emotesets);
	}

	@Override
	public Result<EmoticonImages> getEmoticonImages() {
		return dispatcher.performGet(EmoticonImages.class, Chat.PATH + "/emoticon_images");
	}
}
