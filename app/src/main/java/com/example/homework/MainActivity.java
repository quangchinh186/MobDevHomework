package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.homework.slide10.Slide10;
import com.example.homework.slide2.Slide2;
import com.example.homework.slide4.Slide4;
import com.example.homework.slide5.Slide5;
import com.example.homework.slide6.Slide6;
import com.example.homework.slide7.Slide7;
import com.example.homework.slide8.Slide8;
import com.example.homework.slide9.Slide9;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.slide2){
            startActivity(new Intent(this, Slide2.class));
            return true;
        }
        if(item.getItemId() == R.id.slide4){
            startActivity(new Intent(this, Slide4.class));
            return true;
        }
        if(item.getItemId() == R.id.slide5){
            startActivity(new Intent(this, Slide5.class));
            return true;
        }
        if(item.getItemId() == R.id.slide6){
            startActivity(new Intent(this, Slide6.class));
            return true;
        }
        if(item.getItemId() == R.id.slide7){
            startActivity(new Intent(this, Slide7.class));
            return true;
        }
        if(item.getItemId() == R.id.slide8){
            startActivity(new Intent(this, Slide8.class));
            return true;
        }
        if(item.getItemId() == R.id.slide9){
            startActivity(new Intent(this, Slide9.class));
            return true;
        }
        if(item.getItemId() == R.id.slide10){
            startActivity(new Intent(this, Slide10.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}