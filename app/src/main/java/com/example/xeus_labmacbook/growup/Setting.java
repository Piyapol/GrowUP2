package com.example.xeus_labmacbook.growup;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Setting extends AppCompatActivity {

    private Button  buttTime;
    private Button  buttDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        this.setTitle("Setting");

        Button buttTime = (Button)findViewById(R.id.buttTime);
        buttTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTimePickerDialog();
            }
        });

        Button buttDate = (Button)findViewById(R.id.buttDate);
        buttDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDatePickerDialog();
            }
        });
    }
    private void createTimePickerDialog() {
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(Setting.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(view.is24HourView()) {
                    // view.
                }
                onTimePickerDialogSet(hourOfDay, minute);
            }
        }, hour, min, true);       //true ตัวสุดท้ายหมายถึงแสดงเป็นเวลาแบบ 24 ชั่วโมง
        //ถ้าเป็น false จะแสดงเป็นเวลาแบบ AM/PM

        dialog.show();
    }

    private void onTimePickerDialogSet(int hour, int minute) {
        String str = hour +  ":" + minute;
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }

    private void createDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(Setting.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //เมื่อคลิกปุ่ม OK บนไดอะล็อก ให้อ่านค่า year/month/day ไปใช้งาน
                onDatePickerDialogSet(year, month, dayOfMonth);
            }
        }, year, month, day);  //<= อย่าลืม ต้องกำหนดพารามิเตอร์ปีเดือนวันต่อ้ทายให้ครบ

        dialog.show();
    }

    private void onDatePickerDialogSet(int year, int month, int day) {
        String str = day +  "-" + (month+1) + "-"  + year;
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }
}
