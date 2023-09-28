package com.example.homework.slide7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;

public class Slide7 extends AppCompatActivity {

    static final int REQUEST_SELECT_CONTACT = 10;

    Uri contact;

    EditText name;
    TextView response;
    EditText key;
    EditText contactID;
    EditText phone;
    TextView cur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide7);

        name = findViewById(R.id.fullName);
        response = findViewById(R.id.response);
        key = findViewById(R.id.search);
        contactID = findViewById(R.id.contactID);
        cur = findViewById(R.id.current);
        phone = findViewById(R.id.phoneNumber);
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
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            String feedback = data.getStringExtra("feedback");
            response.setText(feedback);
        } else if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            contact = contactUri;
            cur.setText(contactUri.toString());
        } else {
            response.setText("???");
        }
    }

    public void callWithIntent (View view) {
        String phoneNumber = phone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void search(View view) {
        String query = key.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);
    }

    public void sms(View view) {
        Intent intent = new Intent( Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
        intent.putExtra("sms body", "are we playing golf next Saturday?");
        startActivity(intent);
    }

    public void display(View view) {
        Intent myIntent = new Intent();
        myIntent.setType("image/pictures/*"); myIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivity(myIntent);
    }

    public void showContact(View view){
        String id = contactID.getText().toString();

        String myData = "content://contacts/people/" + id;
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));

        //startActivity();
        startActivity(myActivity2);
    }

    public void chooseContact(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        startActivityForResult(intent, REQUEST_SELECT_CONTACT);
    }

    public void editContact(View view){
        if(contact == null){
            Toast.makeText(this, "you haven't select a contact", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setData(contact);
            startActivity(intent);
        }

    }

    public void mapWithAddress(View view){
        String geoCode = "geo:0,0?q=1860+east+18th+street+cleveland+oh";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);
    }

    public void mapWithAxis(View view){
        String geoCode = "geo:41.5020952,-81.6789717";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);
    }

    public void openMusic(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
        startActivity(intent);
    }
}