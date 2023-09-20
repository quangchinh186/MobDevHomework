package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Slide2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide2_hw);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}