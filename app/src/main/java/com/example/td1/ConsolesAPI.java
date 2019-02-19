package com.example.td1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


//appelle les donnees
public interface ConsolesAPI {

        @GET("console.json")
        Call<List<Console>> getlistconsole();
}
