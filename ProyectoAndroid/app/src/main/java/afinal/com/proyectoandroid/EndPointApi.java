package afinal.com.proyectoandroid;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Janis on 19/11/2017.
 */

public interface EndPointApi {

    @GET(ConstantRestApi.URL_DOGS)
    Call<ArrayList<Dog>> getList();
}
