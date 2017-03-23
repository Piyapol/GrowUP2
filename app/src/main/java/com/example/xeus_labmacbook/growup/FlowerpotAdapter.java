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

public class FlowerpotAdapter extends ArrayAdapter {
   
    private Context mContext;
    private ArrayList<FlowerpotList> mArrayList;
    private int mLayout;

    public FlowerpotAdapter(Context context, int layout, ArrayList<FlowerpotList> arrayList) {
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

        FlowerpotList flowerpotList = mArrayList.get(position);
        //กำหนดภาพให้แก่ ImageView
        ImageView img = (ImageView) view.findViewById(R.id.imageViewFlowerpot);
        img.setImageResource(flowerpotList.getImgResource());
        //กำหนดข้อความในบรรทัดที่ 1 2 และ 3
        TextView tv1 = (TextView)view.findViewById(R.id.textView_FlowerpotName);
        tv1.setText(flowerpotList.getTextLine1());
        TextView tv2 = (TextView)view.findViewById(R.id.textView_Connect);
        tv2.setText(flowerpotList.getTextLine2());
        TextView tv3 = (TextView)view.findViewById(R.id.textView_Status);
        tv3.setText(flowerpotList.getTextLine3());

        
        return view;
    }
}
