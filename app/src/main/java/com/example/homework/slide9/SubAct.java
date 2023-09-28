package com.example.homework.slide9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.homework.R;


public class SubAct extends AppCompatActivity {
    TextView name;

    public void onLogout(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.homework.slide9", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", false);

        editor.apply();
        startActivity(new Intent(this, Slide9.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        name = findViewById(R.id.name);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.homework.slide9", Context.MODE_PRIVATE);
        name.setText(sharedPreferences.getString("username", ""));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}