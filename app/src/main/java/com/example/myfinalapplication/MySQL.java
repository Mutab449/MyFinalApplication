package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MySQL extends AppCompatActivity {

    Button btnInsertphp; //define object  btnInsertphp as a Button
    Button btnViewphp;   //define object  btnViewphp as a Button
    Button btnSearchphp; //define object  btnSearchphp as a Button
    Button btnDeletephp; //define object  btnDeletephp as a Button
    Button btnUpdatephp; //define object  btnUpdatephp as a Button
    Button btnBack;      //define object  btnBack as a Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sql);
        btnInsertphp = (Button) findViewById(R.id.btnInsertphp); //Connect the object btnInsertphp to the id in activity_my_sql
        btnViewphp   = (Button) findViewById(R.id.btnViewphp);   //Connect the object btnViewphp to the id in activity_my_sql
        btnSearchphp = (Button) findViewById(R.id.btnSearchphp); //Connect the object btnSearchphp to the id in activity_my_sql
        btnDeletephp = (Button) findViewById(R.id.btnDeletephp); //Connect the object btnDeletephp to the id in activity_my_sql
        btnUpdatephp = (Button) findViewById(R.id.btnUpdatephp); //Connect the object btnUpdatephp to the id in activity_my_sql
        btnBack      = (Button) findViewById(R.id.btnBack);      //Connect the object btnBack to the id in activity_my_sql

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnInsertphp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on btnInsertphp Button");
                Intent i = new Intent(MySQL.this,InsertPhp.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnViewphp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on btnViewphp Button");
                Intent i = new Intent(MySQL.this,ViewListContentsPHP.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnSearchphp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on btnSearchphp Button");
                Intent i = new Intent(MySQL.this,SearchInPHP.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnDeletephp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on btnDeletephp Button");
                Intent i = new Intent(MySQL.this,DeleteFromPHP.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnUpdatephp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mutablog", "clicked on btnUpdatephp Button");
                Intent i = new Intent(MySQL.this,UpdateMySQL.class);
                Log.v("mutablog:", "intent executed");
                startActivity(i);
                Log.v("mutablog:", "startActivity executed");
            }
        });

        // listener to the button using setOnClickListener(View.OnClickListener) As a result, the system executes the code you write in onClick(View) after the user presses the button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(MySQL.this,MainActivity.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }
}
