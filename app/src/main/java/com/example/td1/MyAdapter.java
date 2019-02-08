package com.example.td1;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> local_Dataset;

    //gere la vue de chaque donnee
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader; //titre
        public TextView txtFooter; //description
        public View layout;

        public MyViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }
    //Constructeur
    public MyAdapter(List<String> myDataset){
        local_Dataset = myDataset;
    }

    //creation des nouvelles vues par le layout manager
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        //creation d'une nouvelle vue
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    //remplace le contenu de la vue
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //on prend un l'element de notre base a cette position
        //Remplace la vue par son contenu
        holder.txtHeader.setText(local_Dataset.get(position));
    }

    //renvoi la taille du dataset
    @Override
    public int getItemCount() {
        return local_Dataset.size();
    }



}
