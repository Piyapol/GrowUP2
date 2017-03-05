package com.example.xeus_labmacbook.growup.service;

import com.example.xeus_labmacbook.growup.model.EnviromentalModel;
import com.example.xeus_labmacbook.growup.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by DuckWalkZ on 28/2/2560.
 */

public interface APIService {
    @GET("getStatusR.php")
    Call<EnviromentalModel> getData();

//    @POST("check_login.php")
//    Call<> getDataLogin();

    @GET("check_login.php/{email}/{password}")
    Call<LoginModel> authenticate(@Path("email") String email, @Path("password") String password);
    @POST("check_login.php/{email}/{password}")
    Call<LoginModel> registration(@Path("email") String email, @Path("password") String password);
}
