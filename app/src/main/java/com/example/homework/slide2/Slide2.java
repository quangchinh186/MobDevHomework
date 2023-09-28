package com.example.homework.slide2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.homework.R;

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