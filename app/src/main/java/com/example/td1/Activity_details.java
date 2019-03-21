package com.example.td1;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.time.Year;

public class Activity_details extends Activity {
    //AFFICHAGE
    //variables pour toutes les donnees
    public TextView Name;
    public TextView Designer;
    public ImageView image; //image
    public TextView CPU;
    public TextView RAM;
    public TextView ROM;
    public TextView Year;
    public TextView Players;
    public TextView Support;
    public View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        //initial
        Name = (TextView) findViewById(R.id.name_txt);
        Designer = (TextView) findViewById(R.id.designer_txt);
        image = (ImageView) findViewById(R.id.image);
        CPU = (TextView) findViewById(R.id.CPU_txt);
        RAM = (TextView) findViewById(R.id.RAM_txt);
        ROM = (TextView) findViewById(R.id.ROM_txt);
        Year = (TextView) findViewById(R.id.year_txt);
        Players = (TextView) findViewById(R.id.Players_txt);
        Support = (TextView) findViewById(R.id.Support_txt);

        //recupere le GSON passer en entree et le retransforme en objet console
        String jsonConsole = getIntent().getStringExtra("console_key");
        Gson gson = new Gson();
        Console item = gson.fromJson(jsonConsole, Console.class);

        //actualise la vue en fonction des parametres
        Name.setText(item.getName());//affiche le nom de la console
        Designer.setText(item.getDesigner());
        Picasso.get().load(item.getPics_url()).into(image);
        CPU.setText(item.getCPU());
        RAM.setText(item.getRAM());
        ROM.setText(item.getROM());
        Year.setText(String.valueOf(item.getYear()));
        Players.setText(String.valueOf(item.getPlayers()));
        Support.setText(item.getSupport());

        }
}
