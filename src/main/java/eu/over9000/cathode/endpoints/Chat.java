package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Badges;
import eu.over9000.cathode.data.ChannelEmoticonList;
import eu.over9000.cathode.data.EmoticonImages;
import eu.over9000.cathode.data.EmoticonList;
import eu.over9000.cathode.data.parameters.Emotesets;

/**
 * <pre>
 * /chat/:channel                              GET			(not implemented as both subqueries are implemented)
 * /chat/:channel/badges                       GET			getBadges(String channelName);
 * 															getEmoticons(String channelName);
 * /chat/emoticons                             GET			getEmoticons();
 * /chat/emoticon_images                       GET			getEmoticonImages(Emotesets emotesets);
 * 															getEmoticonImages();
 * </pre>
 */
public interface Chat {

	String PATH = "chat";

	Result<Badges> getBadges(String channelName);

	Result<ChannelEmoticonList> getEmoticons(String channelName);

	Result<EmoticonList> getEmoticons();

	Result<EmoticonImages> getEmoticonImages(Emotesets emotesets);

	Result<EmoticonImages> getEmoticonImages();
}
