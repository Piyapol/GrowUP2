package com.example.xeus_labmacbook.growup;

import android.app.Fragment;
import android.os.Bundle;
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
 * Created by DuckWalkZ on 21/3/2560.
 */

public class PlantList extends Fragment{
    private ListView listView;
    private MyAdapter myAdapter;
    int[] images;
    String[] names = {"Temperature", "Humidity"} ;
    String[] detail = {"Celcius", "Percent", };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.temperature, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);

        images = new int[]{ R.drawable.thermometer, R.drawable.humidity};

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
                GetData();
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
                    Log.e(" MAIN "," CusID : "+response.body().getData().get(i).getCusId());

                    //for(int j = 0; j < names.length; j++) {
//                        arrayList.add(new Item(images[0], names[0], detail[0], " "));
                    arrayList.add(new Item(images[0], names[0], detail[0],
                            response.body().getData().get(i).getTempValue()));
                    arrayList.add(new Item(images[1], names[1], detail[1],
                            response.body().getData().get(i).getAirhumidValue()));
                    arrayList.add(new Item(images[2], names[2], detail[2],
                            response.body().getData().get(i).getSoilValue()));
                    arrayList.add(new Item(images[3], names[3], detail[3],
                            response.body().getData().get(i).getLightValue()));
                    arrayList.add(new Item(images[4], names[4], detail[4],
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
