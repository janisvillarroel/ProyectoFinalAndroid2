package afinal.com.proyectoandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Janis on 19/11/2017.
 */

public class DogListAdapter
        extends RecyclerView.Adapter<DogListAdapter.DogListViewHolder> {
    private ArrayList<Dog> lista;
    private Context context;
    public DogListAdapter(ArrayList<Dog> lista) {
            this.lista = lista;
        }

    @Override
    public DogListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        context=parent.getContext();
        v = LayoutInflater.from(context).inflate(R.layout.row_dog, parent, false);
        return new DogListAdapter.DogListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DogListViewHolder holder, int position) {
        final Dog dog = lista.get(position);
        holder.txtBreed.setText(dog.getBreed());
        holder.linearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SessionManager session = new SessionManager(context);
                session.saveDog(dog);
                Intent i = new Intent(context, DogImage.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class DogListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtBreed;
        private TextView txtUrl;
        private LinearLayout linearLayout;
        public DogListViewHolder(View itemView) {
            super(itemView);
            txtBreed = (TextView) itemView.findViewById(R.id.txt_breed);
            this.linearLayout= (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}


