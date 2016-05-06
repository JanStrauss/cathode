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

package eu.over9000.cathode;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import eu.over9000.cathode.data.Panel;
import eu.over9000.cathode.data.PanelList;
import eu.over9000.cathode.data.parameters.Parameter;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Dispatcher {
	private static final int CONNECTION_COUNT = 100;

	private final HttpClient HTTP_CLIENT;
	private final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
	private final BasicResponseHandler RESPONSE_HANDLER = new BasicResponseHandler();
	public UndocumentedDispatcher undocumented;


	Dispatcher(final String clientID, final String authToken) {
		undocumented = new UndocumentedDispatcher();

		final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(CONNECTION_COUNT);
		connectionManager.setDefaultMaxPerRoute(CONNECTION_COUNT);

		final List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader(HttpHeaders.ACCEPT, "application/vnd.twitchtv.v3+json"));
		headers.add(new BasicHeader("Client-ID", clientID));
		if (authToken != null) {
			headers.add(new BasicHeader("Authorization", "OAuth " + authToken));
		}

		HTTP_CLIENT = HttpClients.custom().setDefaultHeaders(headers).setConnectionManager(connectionManager).build();
	}

	public <ResponseType> Result<ResponseType> performGet(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		return performInternal(HttpGet.METHOD_NAME, resultClass, path, null, parameters);
	}

	public <ResponseType> Result<ResponseType> performDelete(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		return performInternal(HttpDelete.METHOD_NAME, resultClass, path, null, parameters);
	}

	public <ResponseType> Result<ResponseType> performPut(final Class<ResponseType> resultClass, final String path, final HttpEntity payload, final Parameter... parameters) {
		return performInternal(HttpPut.METHOD_NAME, resultClass, path, payload, parameters);
	}

	public <ResponseType> Result<ResponseType> performPost(final Class<ResponseType> resultClass, final String path, final HttpEntity payload, final Parameter... parameters) {
		return performInternal(HttpPost.METHOD_NAME, resultClass, path, payload, parameters);
	}

	private <ResponseType> Result<ResponseType> performInternal(final String method, final Class<ResponseType> resultClass, final String path, final HttpEntity payload, final Parameter... parameters) {
		try {
			final String baseUrl = String.join("/", Twitch.API_BASE_URL, path);

			final String strResponse = getResponseString(method, baseUrl, payload, parameters);

			final ResponseType objResponse = GSON.fromJson(strResponse, resultClass);

			return new Result<>(objResponse);
		} catch (final Exception e) {
			return new Result<>(e);
		}
	}

	private String getResponseString(final String method, final String baseUrl, final HttpEntity payload, final Parameter... parameters) throws IOException {

		final RequestBuilder requestBuilder = RequestBuilder.create(method).setUri(baseUrl);

		handleParameters(requestBuilder, parameters);

		if (payload != null) {
			requestBuilder.setEntity(payload);
		}

		final HttpUriRequest request = requestBuilder.build();

		final HttpResponse httpResponse = HTTP_CLIENT.execute(request);
		return RESPONSE_HANDLER.handleResponse(httpResponse);
	}

	public Result<String> getResponseRaw(final String url) {
		try {
			return new Result<>(getResponseString(HttpGet.METHOD_NAME, url, null));

		} catch (final Exception e) {
			return new Result<>(e);
		}
	}

	private void handleParameters(final RequestBuilder requestBuilder, final Parameter[] parameters) {
		for (final Parameter parameter : parameters) {
			if (parameter != null) {
				final List<NameValuePair> nameValuePairs = parameter.buildParamPairs();
				nameValuePairs.forEach(requestBuilder::addParameter);
			}
		}
	}

	public <ImageFormat> Result<ImageFormat> retrieveImage(final String url, final Function<InputStream, ImageFormat> converter) {
		try {
			final RequestBuilder requestBuilder = RequestBuilder.get(url);
			final HttpUriRequest request = requestBuilder.build();
			final HttpResponse httpResponse = HTTP_CLIENT.execute(request);

			final InputStream inputStream = httpResponse.getEntity().getContent();
			final ImageFormat image = converter.apply(inputStream);
			inputStream.close();

			return new Result<>(image);

		} catch (final Exception e) {
			return new Result<>(e);
		}
	}

	public class UndocumentedDispatcher {

		public Result<PanelList> getPanels(final String channelName) {
			final String url = "https://api.twitch.tv/api/channels/" + channelName + "/panels";
			final Result<String> result = getResponseRaw(url);

			if (result.isOk()) {
				final Type panelsListType = new TypeToken<List<Panel>>() {
				}.getType();

				final List<Panel> panels = GSON.fromJson(result.getResultRaw(), panelsListType);

				return new Result<>(new PanelList(panels));
			}

			return new Result<>(result.getErrorRaw());
		}
	}
}
