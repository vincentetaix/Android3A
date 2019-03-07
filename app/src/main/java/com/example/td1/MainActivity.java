package com.example.td1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    ////////////////VUE////////////////

    private MainController controller;

    //creation de l'affichage de la liste
    private RecyclerView myRecyclerView; //gere la vue en elle meme
    private RecyclerView.Adapter myRecyclerAdapter; //gere les donnees a afficher
    private RecyclerView.LayoutManager myRecyclerLayout; //fait l'interface


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.my_Rview);

        controller = new MainController(this);
        controller.onCreate();

    }

    public void showList(List<Console> list) {
        //utilise un layout lineaire
        myRecyclerLayout = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myRecyclerLayout);

        //specifie notre adaptateur
        myRecyclerAdapter = new MyAdapter(list, new OnItemClickListener() {
            @Override
            public void onItemClick(Console item) {
                // Create an Intent to start the second activity
                Intent details = new Intent(MainActivity.this, Activity_details.class);
                Gson gson = new Gson();
                //passe en plus la console sur laquelle on se trouve
                details.putExtra("console_key", gson.toJson(item));
                // Start the new activity.
                startActivity(details);
            }
        });
        myRecyclerView.setAdapter(myRecyclerAdapter);
    }

}
