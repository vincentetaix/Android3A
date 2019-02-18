package com.example.td1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        myRecyclerAdapter = new MyAdapter(list);
        myRecyclerView.setAdapter(myRecyclerAdapter);
    }

}
