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
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
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

	public <ResponseType> Result<ResponseType> getAPIResponse(final Class<ResponseType> resultClass, final String path, final Parameter... parameters) {
		try {
			final String baseUrl = String.join("/", Twitch.API_BASE_URL, path);

			final RequestBuilder requestBuilder = RequestBuilder.get(baseUrl);

			for (final Parameter parameter : parameters) {
				if (parameter != null) {
					final List<NameValuePair> nameValuePairs = parameter.buildParamPairs();
					nameValuePairs.forEach(requestBuilder::addParameter);
				}
			}

			final HttpUriRequest request = requestBuilder.build();

			final HttpResponse httpResponse = HTTP_CLIENT.execute(request);
			final String strResponse = RESPONSE_HANDLER.handleResponse(httpResponse);

			final ResponseType objResponse = GSON.fromJson(strResponse, resultClass);

			return new Result<>(objResponse);
		} catch (final IOException e) {
			return new Result<>(e);
		}
	}
}
