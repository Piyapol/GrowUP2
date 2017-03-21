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
 * Created by DuckWalkZ on 21/3/2560.
 */

public class PlantAdapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<Item> mArrayList;
    private int mLayout;

    public PlantAdapter(Context context, int layout, ArrayList<Item> arrayList) {
        super(context, layout, arrayList);
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

        Item item = mArrayList.get(position);

        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(item.getImgResource());

        TextView tv1 = (TextView)view.findViewById(R.id.textView_line1);
        tv1.setText(item.getTextLine1());
        TextView tv2 = (TextView)view.findViewById(R.id.textView_line2);
        tv2.setText(item.getTextLine2());

        return view;
    }

}
