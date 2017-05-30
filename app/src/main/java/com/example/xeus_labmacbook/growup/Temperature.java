package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.xeus_labmacbook.growup.model.EnviromentalModel;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xeus_labmacbook on 1/26/2017 AD.
 */

public class Temperature extends Fragment{

    private ListView listView;
    private MyAdapter myAdapter;
    int[] icons;
    String[] names = {"Temperature", "Humidity", "Soil moisture", "Light", "Water level"};
    String[] units = {"Celcius", "Percent", "Percent", "Lux", "level"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.temperature, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);

        icons = new int[]{ R.drawable.thermometer, R.drawable.humidity, R.drawable.grass, R.drawable.sun, R.drawable.levels};

        return rootView;
    }


    CountDownTimer cdt;

    @Override
    public void onResume() {
        super.onResume();

        cdt = new CountDownTimer(1000, 7000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                cdt.start();
                GetData();
            }
        }.start();

    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        cdt.cancel();
    }

    private  void GetData()
    {
        APIService apiService = APIClient.getRetrofit().create(APIService.class);

        Call<EnviromentalModel> call = apiService.getData();
        call.enqueue(new Callback<EnviromentalModel>() {
            @Override
            public void onResponse(Call<EnviromentalModel> call, Response<EnviromentalModel> response) {
                ArrayList<Item> arrayList = new ArrayList<>();
                for(int i = 0 ; i < response.body().getData().size() ; i++)
                {
                    Log.e(" MAIN "," CusID : "+response.body().getData().get(i).getUserId());

                    //for(int j = 0; j < names.length; j++) {
//                        arrayList.add(new Item(icons[0], names[0], units[0], " "));
                        arrayList.add(new Item(icons[0], names[0], units[0],
                                response.body().getData().get(i).getTempValue()));
                        arrayList.add(new Item(icons[1], names[1], units[1],
                                response.body().getData().get(i).getAirhumidValue()));
                        arrayList.add(new Item(icons[2], names[2], units[2],
                                response.body().getData().get(i).getSoilValue()));
//                        arrayList.add(new Item(icons[3], names[3], units[3],
//                                response.body().getData().get(i).getLightValue()));
                        arrayList.add(new Item(icons[4], names[4], units[4],
                                response.body().getData().get(i).getWaterlvlValue()));
                    //}

                }

                myAdapter = new MyAdapter(getActivity().getBaseContext(), R.layout.item, arrayList);

                listView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<EnviromentalModel>call, Throwable t) {
                // Log error here since request failed
                Log.e(" MAIN  onFailure ", t.toString());

            }
        });



    }
}
