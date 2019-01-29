package com.example.td1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ////////////////VUE////////////////

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    /////////////////////// CODE TUTO /////////////////////////
    /*
    private static final String TOTAL_COUNT = "total_count";

    public void toastMe(View view){ //utilise l'ecran view
        //cree un message en bas de l'écran (un toast)
        Toast mytoast = Toast.makeText(this,"Hello Toast!",Toast.LENGTH_SHORT);
        //precise le type de toast, avec le contexte, le texte et la duree d'affichage
        mytoast.show(); //affiche le toast
    }

    public void countMe(View view){
        //recupere le texte du compteur
        TextView showCountTextView = (TextView) findViewById(R.id.count);

        //recupere la valeur du texte
        String countString = showCountTextView.getText().toString();

        //transforme le texte en chiffres et incremente
        Integer compteur = Integer.parseInt(countString);
        compteur++;

        //remet la nouvelle valeur dans le texte
        showCountTextView.setText(compteur.toString());

    }

    public void randomMe(View view){
        //cree un lien vers la seconde activite
        Intent randomIntent = new Intent(this, SecondActivity.class);

        //recupere le texte du compteur
        TextView showRandomTextView = (TextView) findViewById(R.id.count);

        //recupere la valeur en cours
        String randomString = showRandomTextView.getText().toString();

        //transforme le texte en chiffres
        int alea = Integer.parseInt(randomString);

        //renvoie en variable globale la valeur
        randomIntent.putExtra(TOTAL_COUNT, alea);

        //demarre l'activite
        startActivity(randomIntent);
    }
    */
}
