package com.example.td1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Console> local_Dataset;
    private OnItemClickListener listener;

    //gere la vue de chaque donnee
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader; //titre
        public TextView txtFooter; //description
        public ImageView img; //image
        public View layout;

        public MyViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            img = (ImageView) v.findViewById(R.id.icon);
        }
    }
    //Constructeur
    public MyAdapter(List<Console> myDataset, OnItemClickListener listener){
        local_Dataset = myDataset;
        this.listener = listener;
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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //on prend un l'element de notre base a cette position
        //Remplace la vue par son contenu
        final Console console = local_Dataset.get(position);
        holder.txtHeader.setText(console.getName());//affiche le nom de la console
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(console);
            }
        });
        holder.txtFooter.setText(local_Dataset.get(position).getDesigner());//affiche le constructeur
        holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(console);
            }
        });
        Picasso.get().load(local_Dataset.get(position).getPics_url()).resize(150,150).into(holder.img);
       //affiche la photo
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(console);
            }
        });
    }

    //renvoi la taille du dataset
    @Override
    public int getItemCount() {
        return local_Dataset.size();
    }



}
