package afinal.com.proyectoandroid;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Janis on 19/11/2017.
 */

public class DogImageDeserializer implements JsonDeserializer<String> {
    public DogImageDeserializer() {
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String result = null;
        result = json.getAsJsonObject().get("message").getAsString();
        return result;
    }
}