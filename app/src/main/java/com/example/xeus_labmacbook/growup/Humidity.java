package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by xeus_labmacbook on 1/26/2017 AD.
 */

public class Humidity extends Fragment {

    private static final String TAG = "ControlActivity";
    private  ListView listView;
//    int[] icons;
//    String[] names = {"Auto System", "Light", "Water pump"};
//    String[] bools = {"On/Off", "On/Off", "On/Off"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.humidity, container, false);
//        listView = (ListView) rootView.findViewById(R.id.listViewControl);
//        icons = new int[]  {R.drawable.laptop, R.drawable.lightbulb, R.drawable.sea};
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        SendData();
    }

    public void SendData(){

//        ArrayList<ItemControl> arrayList = new ArrayList<>();
//        for(int i = 0; i < names.length; i++) {
//            arrayList.add(new ItemControl(icons[0], names[0], bools[0],false));
//            arrayList.add(new ItemControl(icons[1], names[1], bools[1],false));
//            arrayList.add(new ItemControl(icons[2], names[2], bools[2],false));
//        }

//        final AdapterControl adapterControl = new AdapterControl(getActivity().getBaseContext(), R.layout.item_control, arrayList);
//        listView.setAdapter(adapterControl);



//        APIService apiService = APIClient.getRetrofit().create(APIService.class);
//        Call<ControlModel> call = apiService.Control(system,light,water);
//        call.enqueue(new Call<ControlModel>(){
//
//            @Override
//            public void onResponse( Call<ControlModel> call,Response<ControlModel> response){
//                Log.e(TAG,"Success");
//            }
//
//            @Override
//            public void onFailure(Call<ControlModel> call, Throwable t) {
//                // handle execution failures like no internet connectivity
//                Log.e(TAG,"False");
//            }
//
//        });

    }


}
