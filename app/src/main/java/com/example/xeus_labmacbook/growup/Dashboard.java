package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        this.setTitle("Dashboard");

        createTabs();
    }

    private void createTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyFragmentAdapter pagerAdapter = new MyFragmentAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.thermometer);
        tabLayout.getTabAt(1).setIcon(R.drawable.humidity);
        tabLayout.getTabAt(2).setIcon(R.drawable.grass);
        tabLayout.getTabAt(3).setIcon(R.drawable.light);
        tabLayout.getTabAt(4).setIcon(R.drawable.levels);
        tabLayout.getTabAt(5).setIcon(R.drawable.pump);
        tabLayout.getTabAt(6).setIcon(R.drawable.led);
    }


}
