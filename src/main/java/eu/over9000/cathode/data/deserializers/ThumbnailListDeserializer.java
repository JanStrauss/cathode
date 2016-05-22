package eu.over9000.cathode.data.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import eu.over9000.cathode.data.Thumbnail;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThumbnailListDeserializer implements JsonDeserializer<List<Thumbnail>> {

	public static final Type THUMBNAIL_LIST_TYPE = new TypeToken<List<Thumbnail>>() {
	}.getType();


	@Override
	public List<Thumbnail> deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
		if (json.isJsonPrimitive()) {
			final String url = json.getAsString();
			return Collections.singletonList(new Thumbnail(url, "processing"));
		}

		return context.deserialize(json, ThumbnailList.class);
	}

	private class ThumbnailList extends ArrayList<Thumbnail> {

	}
}
