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
