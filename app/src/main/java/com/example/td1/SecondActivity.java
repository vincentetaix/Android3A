package com.example.td1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        showRandom();
    }

    private static final String TOTAL_COUNT = "total_count";

    public void showRandom(){
        //recupere le texte du compteur
        TextView showRandomTextView = (TextView) findViewById(R.id.txt_random);

        //recupere l'affichage dans le header
        TextView showRandomHeaderView = (TextView) findViewById(R.id.randomheader);

        //recupere la valeur du compteur global
        int count = getIntent().getIntExtra(TOTAL_COUNT, 0);

        //genere le nombre aleatoire
        Random random = new Random();
        int randomInt = 0;
        if (count>0){
            randomInt = random.nextInt(count);
        }

        //affiche la valeur aleatoire
        showRandomTextView.setText(Integer.toString(randomInt));

        //actualise le header
        showRandomHeaderView.setText(getString(R.string.random_heading,count));

    }

}
