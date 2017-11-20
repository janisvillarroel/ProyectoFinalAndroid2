package afinal.com.proyectoandroid;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class DogDeserializer implements JsonDeserializer<ArrayList<Dog>> {
    public DogDeserializer() {
    }
    @Override
    public ArrayList<Dog> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ArrayList<Dog> result=null;
        JsonObject jsonObject = json.getAsJsonObject();
        Dog dog;
        JsonObject object=jsonObject.get("message").getAsJsonObject();
        for (Map.Entry<String,JsonElement> entry : object.entrySet()) {
            if(result==null){
                result= new ArrayList<Dog>();
            }
            String key = entry.getKey();
            dog = new Dog(key);
            result.add(dog);
        }
        return result;
    }
}
