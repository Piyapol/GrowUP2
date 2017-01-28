package com.example.xeus_labmacbook.growup;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by xeus_labmacbook on 1/26/2017 AD.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    public MyFragmentAdapter(FragmentManager fm) {super(fm);}

    @Override
    public int getCount(){
        return 6;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0: return new Temperature();
            case 1: return new Humidity();
            case 2: return new Soil();
            case 3: return new Light();
            case 4: return new WaterLevel();
            case 5: return new WaterPump();
            case 6: return new LEDControl();
            default: return new Temperature();
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
//        String[] tabs = {"Temperature", "Humidity","Soil", "Light", "Water Level", "Water Pump", "LED"};
        return null;//tabs[position];
    }
}
