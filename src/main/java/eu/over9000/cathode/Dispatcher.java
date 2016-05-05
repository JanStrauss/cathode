package eu.over9000.cathode;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.over9000.cathode.data.parameters.Parameter;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
	private static final int CONNECTION_COUNT = 100;

	private final HttpClient HTTP_CLIENT;
	private final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
	private final BasicResponseHandler RESPONSE_HANDLER = new BasicResponseHandler();


	Dispatcher(final String clientID, final String authToken) {
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
		return performInternal(HttpGet.METHOD_NAME, resultClass, path, parameters);
	}

	public <ResponseType> Result<ResponseType> performDelete(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		return performInternal(HttpDelete.METHOD_NAME, resultClass, path, parameters);
	}

	public <ResponseType> Result<ResponseType> performPut(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		return performInternal(HttpPut.METHOD_NAME, resultClass, path, parameters);
	}

	public <ResponseType> Result<ResponseType> performPost(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		return performInternal(HttpPost.METHOD_NAME, resultClass, path, parameters);
	}

	private <ResponseType> Result<ResponseType> performInternal(final String method, final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		try {
			final String strResponse = getResponseString(method, path, parameters);

			final ResponseType objResponse = GSON.fromJson(strResponse, resultClass);

			return new Result<>(objResponse);
		} catch (final IOException e) {
			return new Result<>(e);
		}
	}

	private String getResponseString(final String method, final String path, final Parameter... parameters) throws IOException {
		final String baseUrl = handleUrl(path);

		final RequestBuilder requestBuilder = RequestBuilder.create(method).setUri(baseUrl);

		handleParameters(requestBuilder, parameters);

		final HttpUriRequest request = requestBuilder.build();

		final HttpResponse httpResponse = HTTP_CLIENT.execute(request);
		return RESPONSE_HANDLER.handleResponse(httpResponse);
	}


	public String __DEBUG__getStringResponse(final String path) {
		try {

			return getResponseString(HttpGet.METHOD_NAME, path);

		} catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String handleUrl(final String path) {
		return String.join("/", Twitch.API_BASE_URL, path);
	}

	private void handleParameters(final RequestBuilder requestBuilder, final Parameter[] parameters) {
		for (final Parameter parameter : parameters) {
			if (parameter != null) {
				final List<NameValuePair> nameValuePairs = parameter.buildParamPairs();
				nameValuePairs.forEach(requestBuilder::addParameter);
			}
		}
	}
}
