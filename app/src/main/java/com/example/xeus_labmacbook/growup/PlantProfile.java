package com.example.xeus_labmacbook.growup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlantProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private PlantProfileAdapter plantProfileAdapter;
    int[] image;
    String[] names = {"Peace lily", "Chrysanthemum"};
    String[] detail = {"That TonMai", "That MaMuang"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle("Plant Profile");

        listView = (ListView) findViewById(R.id.listView_PlantProfile);
        image = new int[]{ R.drawable.peace, R.drawable.chy};
        ArrayList<PlantList> arrayList = new ArrayList<>();
        for(int i = 0 ; i < image.length ; i++){
            arrayList.add(new PlantList(image[i], names[i], detail[i]));
        }

        plantProfileAdapter = new PlantProfileAdapter(getBaseContext(), R.layout.plant_list, arrayList);

        listView.setAdapter(plantProfileAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                switch(arg2) {
                    case 0 :
                        intent = new Intent(getApplicationContext()
                                , Plant_Detail.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getApplicationContext()
                                , Plants_Chy.class);
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
        getMenuInflater().inflate(R.menu.plant_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_flowerpot) {
            Intent access = new Intent(PlantProfile.this, Flowerpot.class);
            startActivity(access);
        } else if (id == R.id.nav_plant) {
            Intent access = new Intent(PlantProfile.this, PlantProfile.class);
            startActivity(access);

        }else if(id == R.id.nav_logout){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
