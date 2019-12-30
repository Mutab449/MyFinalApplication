package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchInDB extends AppCompatActivity {

    EditText editName; //define object  editName as a EditText
    Button btnSearchDB; //define object  btnSearchDB as a Button
    Button btnBack; //define object  btnBack as a Button

    static String dbName=null ; //create static variable to use it another class
    //create static method  to use it another class
    static String getDbName(){
        return dbName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_in_db);

        editName = (EditText) findViewById(R.id.editName); //Connect the object editName to the id in activity_search_in_db
        btnSearchDB = (Button) findViewById(R.id.btnSearchDB); //Connect the object btnSearchDB to the id in activity_search_in_db
        btnBack = (Button) findViewById(R.id.btnBack); //Connect the object btnBack to the id in activity_search_in_db

        btnSearchDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnSearchDB Button");
                dbName = editName.getText().toString(); //save the text to dbName
                Intent i = new Intent(SearchInDB.this,SearchDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(SearchInDB.this,SQLite.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }
}
