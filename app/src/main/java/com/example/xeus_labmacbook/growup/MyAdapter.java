package com.example.xeus_labmacbook.growup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DuckWalkZ on 20/2/2560.
 */

public class MyAdapter extends ArrayAdapter{
    private Context mContext;
    private ArrayList<Item> mArrayList;
    private int mLayout;

    public MyAdapter(Context context, int layout, ArrayList<Item> arrayList) {
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
        //กำหนดภาพให้แก่ ImageView
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(item.getImgResource());
        //กำหนดข้อความในบรรทัดที่ 1 2 และ 3
        TextView tv1 = (TextView)view.findViewById(R.id.textView_line1);
        tv1.setText(item.getTextLine1());
        TextView tv2 = (TextView)view.findViewById(R.id.textView_line2);
        tv2.setText(item.getTextLine2());
        TextView tv3 = (TextView)view.findViewById(R.id.textView_line3);
        tv3.setText(item.getTextLine3());

//        CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);
//        checkBox.setTag(position);
        //กำหนดสถานะของ CheckBox (ขึ้นกับการผ่านค่า true/false เข้ามาในคอนสตรักเตอร์ของ MyItem)
//        checkBox.setChecked(item.getChecked());
        //ดักการเกิดอีเวนต์ที่ CheckBox ถ้าเกิดการเปลี่ยนแปลงการเลือก
        //ให้อ่านสถานะของการเลือกไปเก็บไว้ในออบเจ็กต์ของ MyItem ของรายการนั้น
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                int tag =  (int)buttonView.getTag();
//                Item myItem = (Item)getItem(tag);
//                myItem.setChecked(isChecked);
//            }
//        });

        return view;
    }

    //เมธอดนี้ใช้ในการตรวจสอบจากภายนอกคลาสว่ารายการใดบ้างที่ถูกเลือก (เช็คที่ CheckBox)
    //ส่วนใหญ่จะถูกนำไปใช้ใน MainActivity.java
//    public ArrayList<Item> getCheckedItems() {
//        ArrayList<Item> checkedItems = new ArrayList<>();
//        for(int i = 0; i < mArrayList.size(); i++) {
//            if(mArrayList.get(i).getChecked() == true) {
//                checkedItems.add(mArrayList.get(i));
//            }
//        }
//        return checkedItems;
//    }

}
