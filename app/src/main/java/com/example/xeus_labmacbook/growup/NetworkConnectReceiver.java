package com.example.xeus_labmacbook.growup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            String str = " ";
            if(networkInfo != null && networkInfo.isConnected()){
                str = "Network is connect";
            }else{
                str = "Network is disconnect";
            }
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
        }
    }
}
