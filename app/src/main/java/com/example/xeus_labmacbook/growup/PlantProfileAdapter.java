package com.example.xeus_labmacbook.growup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DuckWalkZ on 23/3/2560.
 */

public class PlantProfileAdapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<PlantList> mArrayList;
    private int mLayout;

    public PlantProfileAdapter(Context context, int layout, ArrayList<PlantList> arrayList) {
        super( context, layout, arrayList);
        mContext = context;
        mLayout = layout;
        mArrayList = arrayList;
    }

    

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        //inflater ในแอนดรอยด์ หมายถึงการแปลงโครงร่างแบบ XML ไปเป็น Java Object
        LayoutInflater inflater =  (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) {
            view = inflater.inflate(mLayout, parent, false);
        }

        PlantList plantList = mArrayList.get(position);
        //กำหนดภาพให้แก่ ImageView
        ImageView img = (ImageView) view.findViewById(R.id.imageViewPlant);
        img.setImageResource(plantList.getImgResource());
        //กำหนดข้อความในบรรทัดที่ 1 2 
        TextView tv1 = (TextView)view.findViewById(R.id.textView_PlantName);
        tv1.setText(plantList.getTextLine1());
//        TextView tv2 = (TextView)view.findViewById(R.id.textView_PlantDetail);
//        tv2.setText(plantList.getTextLine2());
        
        return view;
    }
}
