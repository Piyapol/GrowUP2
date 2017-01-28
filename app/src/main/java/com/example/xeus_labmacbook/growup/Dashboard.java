package com.example.xeus_labmacbook.growup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
        tabLayout.getTabAt(3).setIcon(R.drawable.light_bulb);
        tabLayout.getTabAt(4).setIcon(R.drawable.pitcher_with_levels);
        tabLayout.getTabAt(5).setIcon(R.drawable.gasoline_pump);
        tabLayout.getTabAt(6).setIcon(R.drawable.led_bulb);
    }
}
