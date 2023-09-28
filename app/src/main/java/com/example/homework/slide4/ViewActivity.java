package com.example.homework.slide4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.homework.R;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = this.getIntent();
        String view = intent.getStringExtra("mode");
        //bai 1
        if(view.equals("bai1_relative")){
            setContentView(R.layout.slide4_1_hw_relative);
        }
        if(view.equals("bai1_constraint")){
            setContentView(R.layout.slide4_1_hw_constraint);
        }
        if(view.equals("bai1_linear")){
            setContentView(R.layout.slide4_1_hw_linear);
        }
        if(view.equals("bai1_table")){
            setContentView(R.layout.slide4_1_hw_table);
        }
        //bai 2
        if(view.equals("bai2_relative")){
            setContentView(R.layout.slide4_2_hw_relative);
        }
        if(view.equals("bai2_constraint")){
            setContentView(R.layout.slide4_2_hw_constraint);
        }
        if(view.equals("bai2_linear")){
            setContentView(R.layout.slide4_2_hw_linear);
        }
        if(view.equals("bai2_table")){
            setContentView(R.layout.slide4_2_hw_table);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}