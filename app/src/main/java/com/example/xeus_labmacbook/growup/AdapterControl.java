package com.example.xeus_labmacbook.growup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DuckWalkZ on 21/2/2560.
 */

public class AdapterControl extends ArrayAdapter {
    private Context mContext;
    private ArrayList<ItemControl> mArrayList;
    private int mLayout;

    public AdapterControl(Context context, int layout, ArrayList<ItemControl> arrayList) {
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

        ItemControl itemControl = mArrayList.get(position);
        //กำหนดภาพให้แก่ ImageView
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(itemControl.getImgResource());
        //กำหนดข้อความในบรรทัดที่ 1 และ 2
        TextView tv1 = (TextView)view.findViewById(R.id.textView_line1);
        tv1.setText(itemControl.getTextLine1());
//        TextView tv2 = (TextView)view.findViewById(R.id.textView_line2);
//        tv2.setText(item.getTextLine2());

        Switch switchControl = (Switch)view.findViewById(R.id.switchControl);
        switchControl.setTag(position);
        //กำหนดสถานะของ CheckBox (ขึ้นกับการผ่านค่า true/false เข้ามาในคอนสตรักเตอร์ของ MyItem)
        switchControl.setChecked(itemControl.getChecked());
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
