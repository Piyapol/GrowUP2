package com.example.xeus_labmacbook.growup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Flowerpot extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private FlowerpotAdapter flowerpotAdapter;
    int[] image;
    String[] names = {"Peace lily", "Chrysanthemum"};
    String[] connect = {"Connect Device:", "Connect Device:"};
    String[] status = {"OFF","ON"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle("My Flowerpot");

        listView = (ListView) findViewById(R.id.listView_Flowerpot);
        image = new int[]{ R.drawable.thermometer, R.drawable.humidity};
        ArrayList<FlowerpotList> arrayList = new ArrayList<>();
        for(int i = 0 ; i < image.length ; i++){
            arrayList.add(new FlowerpotList(image[i], names[i], connect[i], status[i]));
        }

        flowerpotAdapter = new FlowerpotAdapter(getBaseContext(), R.layout.flowerpot_list, arrayList);

        listView.setAdapter(flowerpotAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                switch(arg2) {
                    case 0 :
                        intent = new Intent(getApplicationContext()
                                , Home.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getApplicationContext()
                                , Home.class);
                        startActivity(intent);
                        break;
//                    case 2 :
//                        intent = new Intent(getApplicationContext()
//                                , Page_Config.class);
//                        startActivity(intent);
//                        break;
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flowerpot, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            onMenuSettingClick(item);
            Intent intent = new Intent(this,Flowerpot_Add.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//
//    private void onMenuSettingClick( MenuItem item){
//
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_flowerpot) {
            Intent access = new Intent(Flowerpot.this, Flowerpot.class);
            startActivity(access);
        } else if (id == R.id.nav_plant) {
            Intent access = new Intent(Flowerpot.this, PlantProfile.class);
            startActivity(access);
        }else if(id == R.id.nav_logout){

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
