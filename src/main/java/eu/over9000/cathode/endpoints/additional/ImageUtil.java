package eu.over9000.cathode.endpoints.additional;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.parameters.ImageSize;

import java.io.InputStream;
import java.util.function.Function;

public interface ImageUtil {

	<ImageFormat> Result<ImageFormat> getGameLogo(String gameName, ImageSize size, Function<InputStream, ImageFormat> converter);

	<ImageFormat> Result<ImageFormat> getGameBox(String gameName, ImageSize size, Function<InputStream, ImageFormat> converter);

	<ImageFormat> Result<ImageFormat> getStreamPreview(String channelName, ImageSize size, Function<InputStream, ImageFormat> converter);

	<ImageFormat> Result<ImageFormat> getOther(String url, Function<InputStream, ImageFormat> converter);
}