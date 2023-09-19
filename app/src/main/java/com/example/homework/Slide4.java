package com.example.homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Slide4 extends AppCompatActivity {
    String[] words = {
            "nothing","Apple", "Banana", "Cherry", "Date", "Elderberry",
            "Fig", "Grape", "Honeydew", "Orange", "Peach",
            "Pear", "Plum", "Raspberry", "Strawberry", "Blueberry",
            "Lemon", "Lime", "Pineapple", "Coconut", "Mango"
    };
    TextView listText;
    TextView spinnerText;
    TextView gridText;
    ListView listView;
    Spinner spinner;
    GridView gridView;
    AutoCompleteTextView autoCompleteTextView;
    Button hw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide4);
        listText = findViewById(R.id.text_view_label);
        listView = findViewById(R.id.listView);

        spinnerText = findViewById(R.id.spinner_text_label);
        spinner = findViewById(R.id.spinner);

        gridText = findViewById(R.id.grid_label);
        gridView = findViewById(R.id.grid);

        autoCompleteTextView = findViewById(R.id.autoComplete);

        hw = findViewById(R.id.homework);
        this.registerForContextMenu(hw);
        //List View
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_item, words);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listText.setText(adapter.getItem(i));
            }
        });

        //Spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerText.setText(adapter.getItem(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.v("log", "nothing");
            }
        });

        //Grid
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gridText.setText(adapter.getItem(i));
            }
        });

        //auto complete
        autoCompleteTextView.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Pick one");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.bai1_constraint){
            setContentView(R.layout.slide4_1_hw_constraint);
        }
        if(item.getItemId() == R.id.bai1_linear){
            setContentView(R.layout.slide4_1_hw_linear);
        }
        if(item.getItemId() == R.id.bai1_relative){
            setContentView(R.layout.slide4_1_hw_relative);
        }
        if(item.getItemId() == R.id.bai1_table){
            setContentView(R.layout.slide4_1_hw_table);
        }
        if(item.getItemId() == R.id.bai2_constraint){
            setContentView(R.layout.slide4_2_hw_constraint);
        }
        if(item.getItemId() == R.id.bai2_linear){
            setContentView(R.layout.slide4_2_hw_linear);
        }
        if(item.getItemId() == R.id.bai2_relative){
            setContentView(R.layout.slide4_2_hw_relative);
        }
        if(item.getItemId() == R.id.bai2_table){
            setContentView(R.layout.slide4_2_hw_table);
        }
        return super.onContextItemSelected(item);
    }

    public void toggleListView(View view){
        if(listView.getVisibility() == View.GONE){
            listView.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.GONE);
        }
    }
}