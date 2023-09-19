package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    TextView message;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        message = findViewById(R.id.message);

        Intent intent = this.getIntent();
        name = intent.getStringExtra("fullname");
        message.setText(intent.getStringExtra("message"));
    }

    public void back(View view) {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "Helloo " + name + ", this is a response";
        data.putExtra("feedback", feedback);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}