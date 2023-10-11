package com.example.homework.slide8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.example.homework.R;

public class Slide8 extends AppCompatActivity {
    public static String CHANNEL_ID = "testService";
    private NotificationChannel channel;
    MyBroadcastReceiver broadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.slide8);
        super.onCreate(savedInstanceState);

        channel = new NotificationChannel(
                CHANNEL_ID,
                "Example Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
        );
    }

    public void registerBroadcast(View view){
        IntentFilter filter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(broadcastReceiver, filter);
        Log.v("Receiver", "register");
    }

    public void unregisterBroadcast(View view){
        unregisterReceiver(broadcastReceiver);
        Log.v("Receiver", "unregister");
    }

    public void startBackgroundService(View view) {
        Intent intent = new Intent(this, BackGroundService.class);
        startService(intent);
    }

    public void startForegroundService(View view) {
        if(foregroundServiceRunning()){
            return;
        }
        Intent intent = new Intent(this, ForegroundService.class);
        startForegroundService(intent);
    }

    public boolean foregroundServiceRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for(ActivityManager.RunningServiceInfo serviceInfo: activityManager.getRunningServices(Integer.MAX_VALUE)){
            if(ForegroundService.class.getName().equals(serviceInfo.service.getClassName())){
                return true;
            }
        }
        return false;
    }
}