package com.example.homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Slide7 extends AppCompatActivity {

    EditText name;
    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide7);

        name = findViewById(R.id.fullName);
        response = findViewById(R.id.response);
    }

    public void sendMessage(View view){
        String fullname = name.getText().toString();
        String message = "Hello, this is " + fullname +", please send me a response";

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullname", fullname);
        intent.putExtra("message", message);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            String feedback = data.getStringExtra("feedback");
            response.setText(feedback);
        } else {
            response.setText("???");
        }
    }

    protected void mySendBroadcast (View view) {
        
    }
}