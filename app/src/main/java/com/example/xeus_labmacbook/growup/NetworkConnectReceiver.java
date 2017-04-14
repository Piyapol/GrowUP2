package com.example.xeus_labmacbook.growup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by DuckWalkZ on 23/3/2560.
 */

public class NetworkConnectReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            ConnectivityManager connectivityManager =
                    (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

            //For 3G check
            boolean is3g = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                    .isConnectedOrConnecting();
            //For WiFi Check
            boolean isWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                    .isConnectedOrConnecting();

            System.out.println(is3g + " net " + isWifi);

            if (!is3g && !isWifi)
            {
                Toast.makeText(context,"Please make sure your Network Connection is ON ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context," Your method what you want to do ",Toast.LENGTH_LONG).show();

            }

//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            String str = " ";
//            if(networkInfo != null && networkInfo.isConnected()){
//                str = "Network is connect";
//            }else{
//                str = "Network is disconnect";
//            }
//            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        }
    }
}
