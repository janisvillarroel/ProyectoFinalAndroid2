package afinal.com.proyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;


public class DogImage extends AppCompatActivity {
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        session = new SessionManager(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_image);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointApi endPointApi = restApiAdapter.connexionApi(restApiAdapter.buildGsonDeserializedDogUrl());
        TextView textView = (TextView) findViewById(R.id.textBreed);
        textView.setText(session.getDog().getBreed());
        Call<String> responseCall = endPointApi.getImage(session.getDog().getBreed());
        responseCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String url = response.body();
                CircularImageView circularImageView = (CircularImageView)findViewById(R.id.circ);
                Picasso.with(getApplicationContext()).load(url).into(circularImageView);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Ocurrio un error" + t.getLocalizedMessage());
            }
        });
    }
}
