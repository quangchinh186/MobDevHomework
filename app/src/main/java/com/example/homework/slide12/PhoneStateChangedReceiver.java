package com.example.homework.slide12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateChangedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("slide 12", intent.getAction());
        String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String phoneNum = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.v("slide 12", "incoming call from: " + phoneNum);
        }
    }
}
