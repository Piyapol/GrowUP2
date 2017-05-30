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

import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.xeus_labmacbook.growup.model.DataItem;
import com.example.xeus_labmacbook.growup.model.GetDataProfile;
import com.example.xeus_labmacbook.growup.model.ProfileData;
import com.example.xeus_labmacbook.growup.model.Response;
import com.example.xeus_labmacbook.growup.network.APIClient;
import com.example.xeus_labmacbook.growup.service.APIService;
import com.mukesh.tinydb.TinyDB;

import retrofit2.Call;
import retrofit2.Callback;

import static com.example.xeus_labmacbook.growup.R.id.imageViewFlowerpot;
import static com.example.xeus_labmacbook.growup.network.APIClient.BASE_URL_IMAGE;
import static java.security.AccessController.getContext;

public class Flowerpot extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "FlowerPotActivity";
    private ImageView mImg;
    private TextView mName;
    private TextView mFPName;
    private TextView mFPType;
    private TextView mConn;
    private TinyDB tinyDB;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tinyDB = new TinyDB(getApplicationContext());

        id = tinyDB.getString("user_id");
        Log.e(TAG,tinyDB.getString("user_id"));

        mImg = (ImageView)findViewById(R.id.imageViewFlowerpot);
        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                Log.e(TAG,"Intent Success");
            }
        });

        mFPName = (TextView)findViewById(R.id.textView_FlowerpotName);

        mFPType = (TextView)findViewById(R.id.textView_FlowerpotType);

        mConn = (TextView)findViewById(R.id.textView_Status);


        this.setTitle("My Flowerpot");

        GetDataProfile();

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


    private  void GetDataProfile()
    {
        APIService apiService = APIClient.getRetrofit().create(APIService.class);
        Call<GetDataProfile> call = apiService.getDataProfile(id);
        call.enqueue(new Callback<GetDataProfile>() {
            @Override
            public void onResponse(Call<GetDataProfile> call, retrofit2.Response<GetDataProfile> response) {
                for(int i = 0 ; i < response.body().getData().size() ; i++) {
                    if (response.body().getData().get(i).getPlantName() == "" || response.body().getData().get(i).getPlantType() == "") {
                        mFPName.setText("#Flowerpot Name");
                        mFPType.setText("#Plant Type");
                    } else {
                        mFPName.setText(response.body().getData().get(i).getPlantName());
                        mFPType.setText(response.body().getData().get(i).getPlantType());
                    }

                    Log.e(TAG, response.body().getData().get(i).getPlantName());
                    Log.e(TAG, response.body().getData().get(i).getPlantType());
                    Log.e(TAG, response.body().getData().get(i).getPlantImage());

                    Glide.with(getApplicationContext())
                            .load(BASE_URL_IMAGE + response.body().getData().get(i).getPlantImage())
                            .placeholder(R.drawable.flower)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .crossFade()
                            .into(mImg);

                    Log.e(TAG, "Success");
                }
            }

            @Override
            public void onFailure(Call<GetDataProfile>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, "False");

            }
        });

    }


}
