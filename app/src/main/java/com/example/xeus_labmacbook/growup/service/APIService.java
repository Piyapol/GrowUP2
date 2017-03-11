package com.example.xeus_labmacbook.growup.service;

import com.example.xeus_labmacbook.growup.model.ControlModel;
import com.example.xeus_labmacbook.growup.model.EnviromentalModel;
import com.example.xeus_labmacbook.growup.model.RegisterModel;
import com.example.xeus_labmacbook.growup.model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by DuckWalkZ on 28/2/2560.
 */

public interface APIService {
    @GET("getStatusR.php")
    Call<EnviromentalModel> getData();

    @FormUrlEncoded
    @POST("login.php")
    Call<ServerResponse> Login(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterModel> Register(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("control.php")
    Call<ControlModel> Control(
            @Field("system") boolean system,
            @Field("light") boolean light,
            @Field("water") boolean water
    );
}
