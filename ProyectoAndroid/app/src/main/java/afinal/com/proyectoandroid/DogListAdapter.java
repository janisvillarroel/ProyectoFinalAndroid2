package afinal.com.proyectoandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Janis on 19/11/2017.
 */

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogListViewHolder>  {
    private ArrayList<Dog> lista;

   public DogListAdapter(ArrayList<Dog> lista) {
            this.lista = lista;
        }

        @Override
        public DogListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v;
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dog, parent, false);
            return new DogListAdapter.DogListViewHolder(v);
        }

        @Override
        public void onBindViewHolder(DogListViewHolder holder, int position) {
            final Dog dog = lista.get(position);
            holder.txtBreed.setText(dog.getBreed());
        }

        @Override
        public int getItemCount() {
            return lista.size();
        }


        public static class DogListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtBreed;
        private TextView txtUrl;

        public DogListViewHolder(View itemView) {
            super(itemView);
            txtBreed = (TextView) itemView.findViewById(R.id.txt_breed);
        }
    }
}


