/*
 * Copyright (c) 2014-2016 s1mpl3x <jan[at]over9000.eu>
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

package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.URIUtil;
import eu.over9000.cathode.data.parameters.ImageSize;
import eu.over9000.cathode.endpoints.additional.ImageUtil;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.function.Function;

public class ImageUtilImpl extends AbstractEndpoint implements ImageUtil {

	private static final String GAME_BOX_TEMPLATE = "https://static-cdn.jtvnw.net/ttv-boxart/{0}-{1}x{2}.jpg";
	private static final String GAME_LOGO_TEMPLATE = "https://static-cdn.jtvnw.net/ttv-logoart/{0}-{1}x{2}.jpg";
	private static final String STREAM_PREVIEW_TEMPLATE = "https://static-cdn.jtvnw.net/previews-ttv/live_user_{0}-{1}x{2}.jpg";

	public ImageUtilImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public <ImageFormat> Result<ImageFormat> getGameLogo(final String gameName, final ImageSize size, final Function<InputStream, ImageFormat> converter) {
		return dispatcher.retrieveImage(constructUrl(GAME_LOGO_TEMPLATE, gameName, size), converter);
	}

	@Override
	public <ImageFormat> Result<ImageFormat> getGameBox(final String gameName, final ImageSize size, final Function<InputStream, ImageFormat> converter) {
		return dispatcher.retrieveImage(constructUrl(GAME_BOX_TEMPLATE, gameName, size), converter);
	}

	@Override
	public <ImageFormat> Result<ImageFormat> getStreamPreview(final String channelName, final ImageSize size, final Function<InputStream, ImageFormat> converter) {
		return dispatcher.retrieveImage(constructUrl(STREAM_PREVIEW_TEMPLATE, channelName.toLowerCase(), size), converter);
	}

	@Override
	public <ImageFormat> Result<ImageFormat> getOther(final String url, final Function<InputStream, ImageFormat> converter) {
		return dispatcher.retrieveImage(url, converter);
	}

	private String constructUrl(final String template, final String title, final ImageSize size) {
		final String titleEncoded = URIUtil.encodePath(title);
		return MessageFormat.format(template, titleEncoded, size.getWidth(), size.getHeight());
	}
}
