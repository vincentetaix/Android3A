package com.example.td1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

        //initialistation du stockage
        SharedPreferences console_cache = PreferenceManager.getDefaultSharedPreferences(activity);;
        final SharedPreferences.Editor editor = console_cache.edit();

        ConsolesAPI API = retrofit.create(ConsolesAPI.class);

        Call<List<Console>> call = API.getlistconsole();
        call.enqueue(new Callback<List<Console>>() {
            @Override
            public void onResponse(Call<List<Console>> call, Response<List<Console>> response) {
                //recupere les donnes depuis le json
               List<Console> input = response.body();

               //stockage en cache
                Gson gson = new Gson();
                String json = gson.toJson(input);
                editor.putString("key_cache", json);
                editor.apply(); // This line is IMPORTANT !!!
               activity.showList(input);
            }

            @Override
            public void onFailure(Call<List<Console>> call, Throwable t) {
                //affiche erreur via push
                Toast.makeText(activity, "Internet Error", Toast.LENGTH_LONG).show();
                //recuperation de la liste en cache
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
                Gson gson = new Gson();
                String json = prefs.getString("key_cache", null);
                Type type = new TypeToken<List<Console>>() {}.getType();
                List<Console> input = gson.fromJson(json, type);

                activity.showList(input);
            }
        });
    }


    private MainActivity activity;
}
