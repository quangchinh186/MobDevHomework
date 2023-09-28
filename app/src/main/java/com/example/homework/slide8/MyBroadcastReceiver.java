package com.example.homework.slide8;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Log.v("broadcast_test", "ok");
            Toast.makeText(context, "airplane mode change", Toast.LENGTH_LONG).show();
        }
    }


}
