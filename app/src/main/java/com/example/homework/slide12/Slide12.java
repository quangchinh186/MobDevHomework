package com.example.homework.slide12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;

public class Slide12 extends AppCompatActivity {
    //sensor
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    private final float[] mRotationMatrix = new float[16];
    private void initTestForSensor(){
        mRotationMatrix[ 0] = 1;
        mRotationMatrix[ 4] = 1;
        mRotationMatrix[ 8] = 1;
        mRotationMatrix[12] = 1;
    }

    //wifi
    private ConnectivityManager connectivityManager;
    private WifiManager wifiManager;
    private TextView wifiStatus;

    private void initForWifiTest(){
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiStatus = findViewById(R.id.wifi_status);
        connectivityManager = getSystemService(ConnectivityManager.class);
        Network network = connectivityManager.getActiveNetwork();
        Log.v("Slide 12", connectivityManager.getNetworkCapabilities(network).toString());
    }

    public void turnOnWifi(View view){
        if(wifiManager.isWifiEnabled()){
            Log.v("slide 12", "wifi is enable");
            Toast.makeText(this, "wifi is already on", Toast.LENGTH_LONG);
        } else {
            wifiStatus.setText("Wifi status: on");
            wifiManager.setWifiEnabled(true);
        }
    }

    public void turnOffWifi(View view){
        if(wifiManager.isWifiEnabled()){
            wifiStatus.setText("Wifi status: off");
            wifiManager.setWifiEnabled(false);
        } else {
            Log.v("slide 12", "wifi is not enable");
            Toast.makeText(this, "wifi is already off", Toast.LENGTH_LONG);
        }

    }

    //telephony service
    TelephonyManager telephonyManager;
    void initForTelephony(){
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE) ;
    }
    //camera
    //bluetooth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide12);
        //sensor
        initTestForSensor();
        //wifi
        initForWifiTest();
        //telephony
        initForTelephony();

    }

    public void startSensor(View view){
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                    SensorManager.getRotationMatrixFromVector(
                            mRotationMatrix , sensorEvent.values);
                    Log.v("Slide 12", mRotationMatrix.toString());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(sensorEventListener, sensor, 10000);
    }

    public void stopSensor(View view){
        sensorManager.unregisterListener(sensorEventListener, sensor);
    }

}