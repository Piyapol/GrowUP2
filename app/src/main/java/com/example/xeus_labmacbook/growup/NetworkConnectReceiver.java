package com.example.xeus_labmacbook.growup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by DuckWalkZ on 23/3/2560.
 */

public class NetworkConnectReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       try{
//        if(intent != null) {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            String typeName =networkInfo.getTypeName();
//            int type = networkInfo.getType();
//            int netType = networkInfo.getSubtype();
//            String tNet = "Unknown";
//            String NetType = "";
            String str = " ";
            if (networkInfo != null && networkInfo.isConnected()) {
                str = "Network is connect";
                Log.e("Network is connect: ", String.valueOf(networkInfo.isConnected()));
//                if (type == connectivityManager.TYPE_MOBILE) {
//                    tNet = "Mobile";
//                    Log.e("Network Mobile: ", String.valueOf(networkInfo.isConnected()));
//                    switch (netType) {
//                        case TelephonyManager.NETWORK_TYPE_CDMA:
//                        case TelephonyManager.NETWORK_TYPE_EDGE:
//                        case TelephonyManager.NETWORK_TYPE_GPRS:
//                            NetType = "2G";
//                            break;
//                        case TelephonyManager.NETWORK_TYPE_HSPA:
//                        case TelephonyManager.NETWORK_TYPE_HSPAP:
//                        case TelephonyManager.NETWORK_TYPE_UMTS:
//                            NetType = "3G";
//                            break;
//                        case TelephonyManager.NETWORK_TYPE_LTE:
//                            NetType = "4G";
//                            break;
//                        default:
//                            NetType = "Unknown";
//                    }
//                    Toast.makeText(context, NetType, Toast.LENGTH_SHORT).show();
//                } else if (type == ConnectivityManager.TYPE_WIFI) {
//                    tNet = "WI FI";
////                    Log.e("Network is connect: ", String.valueOf(networkInfo.isConnected()));
//                }
//                Toast.makeText(context, tNet, Toast.LENGTH_SHORT).show();
            } else  {
                str = "Network is disconnect";
                Log.e("Network is disconnect: ", String.valueOf(networkInfo.isConnected()));
//                if(!networkInfo.isConnected()){
//                    Intent i = new Intent(Intent.ACTION_MAIN);
//                    i.setClassName("com.android.phone", "com.android.phone.NetworkSetting");
//                    context.startActivity(i);
//                }
            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
//        }
        }catch (Exception e){

       }
    }
}
