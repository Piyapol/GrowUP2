package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.xeus_labmacbook.growup.model.ControlModel;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xeus_labmacbook on 1/26/2017 AD.
 */

public class Humidity extends Fragment {

    private static final String TAG = "ControlActivity";

    private boolean sw_auto = false;
    private boolean sw_water = false;
    private boolean sw_light = false;
    private boolean repeat = false;

    private Switch sw1;
    private Switch sw2;
    private Switch sw3;

    private CountDownTimer cdt;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.humidity, container, false);

        sw1 = (Switch) rootView.findViewById(R.id.switchControl);
        sw2 = (Switch) rootView.findViewById(R.id.switchControl2);
        sw3 = (Switch) rootView.findViewById(R.id.switchControl3);

         sw1.setChecked(true);
        if(sw1.isChecked()){
            Toast.makeText(getContext(), "Automatic mode is On", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getContext(), "Automatic mode is Off", Toast.LENGTH_LONG).show();
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        cdt = new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                cdt.start();
                checkedSwitch();
                SendData();
                Log.e(TAG,"Sendata");
            }
        }.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        cdt.cancel();
    }

    public void SendData(){

        sw_auto = sw1.isChecked();
        sw_light = sw2.isChecked();
        sw_water = sw3.isChecked();
        Log.e(TAG, String.valueOf(sw_auto));
        Log.e(TAG, String.valueOf(sw_light));
        Log.e(TAG, String.valueOf(sw_water));

        APIService apiService = APIClient.getRetrofit().create(APIService.class);

        Call<ControlModel> call = apiService.Control(sw_auto,sw_water,sw_light,repeat);

        call.enqueue(new Callback<ControlModel>() {
            @Override
            public void onResponse(Call<ControlModel> call, Response<ControlModel> response) {
                Log.e(TAG,"Success");

                if(response.body().isError() == true){
                    Toast.makeText(getContext(), "Send Data Failure", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ControlModel> call, Throwable t) {
                Log.e(TAG,"Falied");
                Toast.makeText(getContext(), "Send Data onFailure", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void checkedSwitch(){

        if(sw1.isChecked() == true)
        {
            sw2.setEnabled(false);
            sw3.setEnabled(false);
//            Toast.makeText(getContext(), "Automatic mode is On", Toast.LENGTH_LONG).show();
        }else{
            sw2.setEnabled(true);
            sw3.setEnabled(true);
//            Toast.makeText(getContext(), "Automatic mode is Off", Toast.LENGTH_LONG).show();
        }

    }
   }