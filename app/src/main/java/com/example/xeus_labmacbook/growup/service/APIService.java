package com.example.xeus_labmacbook.growup.service;

import com.example.xeus_labmacbook.growup.model.AddProfile;
import com.example.xeus_labmacbook.growup.model.ControlModel;
import com.example.xeus_labmacbook.growup.model.DataItem;
import com.example.xeus_labmacbook.growup.model.EnviromentalModel;
import com.example.xeus_labmacbook.growup.model.GetDataProfile;
import com.example.xeus_labmacbook.growup.model.ProfileData;
import com.example.xeus_labmacbook.growup.model.RegisterModel;

import com.example.xeus_labmacbook.growup.model.Response;
import com.example.xeus_labmacbook.growup.model.ServerResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
            @Field("sw_auto") boolean sw_auto,
            @Field("sw_water") boolean sw_water,
            @Field("sw_light") boolean sw_light,
            @Field("repeat") boolean repeat
    );

    @FormUrlEncoded
    @POST("addprofile.php")
    Call<AddProfile> AddProfile(
            @Field("uid") String uid,
            @Field("name") String name,
            @Field("type") String type,
            @Part("image") RequestBody image
    );

    @Multipart
    @POST("addprofile.php")
    Call<AddProfile> AddProfile2(
            @Part("user_id") RequestBody  uid,
            @Part("name") RequestBody  name,
            @Part("type") RequestBody  type,
            @Part MultipartBody.Part file
    );


    @FormUrlEncoded
    @POST("getprofile.php")
    Call<GetDataProfile> getDataProfile(
            @Field("id") String id

    );

}
