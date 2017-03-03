package com.example.xeus_labmacbook.growup.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DuckWalkZ on 28/2/2560.
 */

public class APIClient {
    public static final  String BASE_URL = "http://128.199.137.189/";
    public static Retrofit retrofit = null;

    public static  Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        }

        return retrofit;
    }
}
