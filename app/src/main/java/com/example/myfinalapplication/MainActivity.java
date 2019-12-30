package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMySQL;   //define object  btnMySQL as a Button
    Button btnSQLite; //define object  btnSQLite as a Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMySQL  = (Button) findViewById(R.id.btnMySQL);   //Connect the object btnMySQL to the id in activity_main
        btnSQLite = (Button) findViewById(R.id.btnSQLite); //Connect the object btnSQLite to the id in activity_main

       // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnMySQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on MySQL Button");
                Intent i = new Intent(MainActivity.this,MySQL.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on SQLite Button");
                Intent i = new Intent(MainActivity.this,SQLite.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });
    }
}
