package afinal.com.proyectoandroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Janis on 19/11/2017.
 */

public class RestApiAdapter{

    /**
     * Get connexion rest api generic with param gson converter target objet
     *

     * @return EndPointApi
     */
    public EndPointApi connexionApi(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantRestApi.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointApi.class);
    }

    public Gson buildGsonDeserializedDog() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ArrayList.class, new DogDeserializer());
        return gsonBuilder.create();
    }

    public Gson buildGsonDeserializedDogUrl() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, new DogImageDeserializer());
        return gsonBuilder.create();
    }
}