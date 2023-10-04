package com.example.homework.slide10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;

import java.util.Arrays;

public class Slide10 extends AppCompatActivity {

    public void onShowNotes(View view) {
        try {
            Uri uri = Uri.parse("content://com.example.homework.slide10.CustomProvider/note");
            String[] projection = {"id", "note", "owner"};
            String selection = null;
            String[] selectionArgs = null;
            String sortOrder = null;
            Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
            TableLayout tableLayout = findViewById(R.id.table);
            if (tableLayout.getChildCount() > 1) {
                tableLayout.removeViews(1, tableLayout.getChildCount() - 1);
            }
            while (cursor.moveToNext()) {
                TableRow tableRow = new TableRow(this);
                int id = cursor.getInt(0);
                String note = cursor.getString(1);
                String owner = cursor.getString(2);
                TextView idView = new TextView(this);
                idView.setText(String.valueOf(id));
                TextView noteView = new TextView(this);
                noteView.setText(note);
                TextView ownerView = new TextView(this);
                ownerView.setText(owner);
//        delete button
                Button deleteButton = new Button(this);
                deleteButton.setText("Delete");
                deleteButton.setBackgroundColor(Color.rgb(70, 80, 90));
                int deleteButtonId = View.generateViewId();
                System.out.println(deleteButtonId);
                deleteButton.setId(deleteButtonId);
                deleteButton.setOnClickListener(this::onDeleteItem);
//        add views to table row
                tableRow.addView(idView);
                tableRow.addView(noteView);
                tableRow.addView(ownerView);
                tableRow.addView(deleteButton);
                tableLayout.addView(tableRow);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void onDeleteItem(View view) {
        TableRow tableRow = (TableRow) view.getParent();
        TextView idView = (TextView) tableRow.getChildAt(0);
        String id = idView.getText().toString();
        Uri uri = Uri.parse("content://com.example.homework.slide10.CustomProvider/note");
        String selection = "id = ?";
        String[] selectionArgs = {id};
        getContentResolver().delete(uri, selection, selectionArgs);
        onShowNotes(view);
    }

    public void onAddNote(View view) {
        ContentValues values = new ContentValues();
        EditText note = findViewById(R.id.note);
        EditText owner = findViewById(R.id.owner);
        values.put("note", note.getText().toString());
        values.put("owner", owner.getText().toString());
        try {
            getContentResolver().insert(Uri.parse("content://com.example.homework.slide10.CustomProvider/note"), values);
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        // update table
        onShowNotes(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide10);
    }
}