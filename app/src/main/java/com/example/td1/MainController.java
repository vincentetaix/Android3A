package com.example.td1;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    public MainController(MainActivity activity){
        this.activity = activity;
    }

    //////fais le stockage, les appels web et toute la logique de l'appli ///////

    public void onCreate(){
       start();
    }

    //instance RetroFit
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://vincentetaix.github.io/Fake_API.github.io/";
    //adresse du serveur ou recuperer les donnees

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ConsolesAPI API = retrofit.create(ConsolesAPI.class);

        Call<List<Console>> call = API.getlistconsole();
        call.enqueue(new Callback<List<Console>>() {
            @Override
            public void onResponse(Call<List<Console>> call, Response<List<Console>> response) {
                //recupere les donnes depuis le json
               List<Console> input = response.body();
               activity.showList(input);
            }

            @Override
            public void onFailure(Call<List<Console>> call, Throwable t) {
                //affiche erreur via push
                Toast.makeText(activity, "Internet Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private MainActivity activity;
}
