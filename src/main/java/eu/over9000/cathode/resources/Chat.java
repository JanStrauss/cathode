/*
 * Copyright (c) 2016 s1mpl3x <jan[at]over9000.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.over9000.cathode.resources;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Badges;
import eu.over9000.cathode.data.ChannelEmoticonList;
import eu.over9000.cathode.data.EmoticonImages;
import eu.over9000.cathode.data.EmoticonThing;
import eu.over9000.cathode.data.parameters.EmoteSets;

/**
 * <pre>
 * /chat/:channel                              GET			(not implemented as both subqueries are implemented)
 * /chat/:channel/badges                       GET			getBadges(String channelName);
 * /chat/:channel/emoticons                    GET			getEmoticons(String channelName);
 * /chat/emoticons                             GET			getEmoticons();
 * /chat/emoticon_images                       GET			getEmoticonImages(Emotesets emotesets);
 * 															getEmoticonImages();
 * </pre>
 */
public interface Chat {

	String PATH = "chat";

	Result<Badges> getBadges(String channelName);

	Result<ChannelEmoticonList> getEmoticons(String channelName);

	Result<EmoticonThing> getEmoticons();

	Result<EmoticonImages> getEmoticonImages(EmoteSets emoteSets);

	Result<EmoticonImages> getEmoticonImages();
}
