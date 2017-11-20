package afinal.com.proyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class PrincipalPage extends AppCompatActivity {
    private SessionManager session;
    private RecyclerView recyclerView;
    private DogListAdapter userListAdapter;
    private ArrayList<Dog> dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        session = new SessionManager(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_page);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        TextView user= (TextView) findViewById(R.id.textViewUserValue);
        user.setText(session.getUser().getUsername());
        /**/
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.connexionApi(restApiAdapter.buildGsonDeserializedDog());
        Call<ArrayList<Dog>> responseCall = endPointApi.getList();
        responseCall.enqueue(new Callback<ArrayList<Dog>>() {
            @Override
            public void onResponse(Call<ArrayList<Dog>> call, Response<ArrayList<Dog>> response) {
                userListAdapter = new DogListAdapter(response.body());
                recyclerView.setAdapter(userListAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dog>> call, Throwable t) {
                System.out.println("Ocurrio un error" + t.getLocalizedMessage());
            }
        });

    }
}
