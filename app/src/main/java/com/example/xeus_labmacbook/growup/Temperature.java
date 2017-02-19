package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by xeus_labmacbook on 1/26/2017 AD.
 */

public class Temperature extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        String[] names = {"Temperature", "Humidity", "Soil moisture", "Light", "Water level"};
        String[] units = {"Celcius", "Percent", "Percent", "Lux", "level"};
        int[] icons = {R.drawable.thermometer, R.drawable.humidity, R.drawable.grass, R.drawable.light, R.drawable.levels};
        ArrayList<Item> arrayList = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            arrayList.add(new Item(icons[i], names[i], units[i], false));
        }

        ListView listView = (ListView)getView().findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(getActivity().getBaseContext(), R.layout.item, arrayList);
        listView.setAdapter(myAdapter);

        View view = inflater.inflate(R.layout.temperature, container, false);
        return view;
    }

}
