package com.example.homework.slide10;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

public class CustomProvider extends ContentProvider {
    NoteModel noteModel;
    SQLiteDatabase db;
    public CustomProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        db.delete("note", selection, selectionArgs);
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Toast.makeText(getContext(), "New note added", Toast.LENGTH_SHORT).show();
        db.insert("note", null, values);
        return null;
    }

    @Override
    public boolean onCreate() {
        noteModel = new NoteModel(getContext());
        db = noteModel.getWritableDatabase();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return db.query("note", projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        db.update("note", values, selection, selectionArgs);
        return 0;
    }
}
