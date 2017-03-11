package com.example.xeus_labmacbook.growup.network;

import android.util.Log;

import com.example.xeus_labmacbook.growup.Event.ErrorEvent;
import com.example.xeus_labmacbook.growup.model.ServerEvent;
import com.example.xeus_labmacbook.growup.model.ServerResponse;
import com.example.xeus_labmacbook.growup.service.APIService;
import com.squareup.otto.Produce;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DuckWalkZ on 9/3/2560.
 */

public class Comunicator {
    private static  final String TAG = "Communicator";
    private static final String SERVER_URL = "http://128.199.137.189/";

    public void loginPost(String email, String password){

        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build(); APIService service = retrofit.create(APIService.class);

        Call<ServerResponse> call = service.post(email,password);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
                Log.e(TAG,"False");
            }
        });
    }

//    public void loginGet(String username, String password){
//        //Here a logging interceptor is created
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        //The logging interceptor will be added to the http client
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);
//
//        //The Retrofit builder will have the client attached, in order to get connection logs
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(httpClient.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(SERVER_URL)
//                .build();
//
//        APIService service = retrofit.create(APIService.class);
//
//        Call<ServerResponse> call = service.get("login",username,password);
//
//        call.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
//                BusProvider.getInstance().post(new ServerEvent(response.body()));
//                Log.e(TAG,"Success");
//            }
//
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//                // handle execution failures like no internet connectivity
//                BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
//            }
//        });
//    }

    @Produce
    public ServerEvent produceServerEvent(ServerResponse serverResponse) {
        return new ServerEvent(serverResponse);
    }

    @Produce
    public ErrorEvent produceErrorEvent(int errorCode, String errorMsg) {
        return new ErrorEvent(errorCode, errorMsg);
    }
}
