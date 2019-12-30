package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchInPHP extends AppCompatActivity {

    phpConn phpC = new phpConn(); //create a phpC connection to phpcoon
    EditText editName; //define object  editName as a EditText
    Button btnSearchPHPDB; //define object  btnSearchPHPDB as a Button
    Button btnBack; //define object  btnBack as a Button

    static String phpName=null ; //create static variable to use it another class
    //create static method  to use it another class
    static String getPhpName(){
        return phpName;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_in_php);
        editName = (EditText) findViewById(R.id.editName); //Connect the object editName to the id in activity_search_in_php
        btnSearchPHPDB = (Button) findViewById(R.id.btnSearchPHP); //Connect the object btnSearchPHP to the id in activity_search_in_php
        btnBack = (Button) findViewById(R.id.btnBack); //Connect the object btnBack to the id in activity_search_in_php

        btnSearchPHPDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnSearchPHPDB Button");
                phpName = editName.getText().toString();
                Intent i = new Intent(SearchInPHP.this,SearchPHP.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(SearchInPHP.this,MySQL.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }
}
