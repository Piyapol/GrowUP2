package com.example.xeus_labmacbook.growup.service;

import com.example.xeus_labmacbook.growup.model.EnviromentalModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DuckWalkZ on 28/2/2560.
 */

public interface APIService {
    @GET("getStatusR2.php")
    Call<EnviromentalModel> getData();
}
