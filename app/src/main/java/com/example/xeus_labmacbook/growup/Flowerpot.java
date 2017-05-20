package com.example.xeus_labmacbook.growup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mukesh.tinydb.TinyDB;

import java.util.ArrayList;

import static com.example.xeus_labmacbook.growup.R.id.imageViewFlowerpot;
import static java.security.AccessController.getContext;

public class Flowerpot extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "FlowerPotActivity";
    private ImageView mImg;
    private TextView mName;
    private TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tinyDB = new TinyDB(getApplicationContext());

        tinyDB.getString("user_uid");

        mImg = (ImageView)findViewById(R.id.imageViewFlowerpot);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                Log.e(TAG,"Success");
            }
        });

        Glide.with(getApplicationContext())
                .load("http://128.199.137.189/Images/ram.jpg")
                .placeholder(R.drawable.flower)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(mImg);

        this.setTitle("My Flowerpot");

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
            Intent intent = new Intent(Flowerpot.this,Flowerpot_Add.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


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
