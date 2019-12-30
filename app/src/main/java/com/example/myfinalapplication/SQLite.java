package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SQLite extends AppCompatActivity {

    Button btnInsertdb;  //define object  btnInsertdb as a Button
    Button btnViewdb;    //define object  btnViewdb as a Button
    Button btnSearchdb;  //define object  btnSearchdb as a Button
    Button btnDeletedb;  //define object  btnDeletedb as a Button
    Button btnUpdatedb;  //define object  btnUpdatedb as a Button
    Button btnBack;      //define object  btnBack as a Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        btnInsertdb = (Button) findViewById(R.id.btnInsertdb); //Connect the object btnInsertdb to the id in activity_sqlite
        btnViewdb   = (Button) findViewById(R.id.btnViewdb);   //Connect the object btnViewdb to the id in activity_sqlite
        btnSearchdb = (Button) findViewById(R.id.btnSearchdb); //Connect the object btnSearchdb to the id in activity_sqlite
        btnDeletedb = (Button) findViewById(R.id.btnDeletedb); //Connect the object btnDeletedb to the id in activity_sqlite
        btnUpdatedb = (Button) findViewById(R.id.btnUpdatedb); //Connect the object btnUpdatedb to the id in activity_sqlite
        btnBack     = (Button) findViewById(R.id.btnBack);     //Connect the object btnBack to the id in activity_sqlite

        btnInsertdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnInsertdb Button");
                Intent i = new Intent(SQLite.this,InsertDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnViewdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnViewdb Button");
                Intent intent = new Intent(SQLite.this,ViewListContactsDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(intent);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnSearchdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnSearchdb Button");
                Intent i = new Intent(SQLite.this,SearchInDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnDeletedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnDeletedb Button");
                Intent i = new Intent(SQLite.this,DeleteFromDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnUpdatedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnUpdatedb Button");
                Intent i = new Intent(SQLite.this,UpdateSQLite.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(SQLite.this,MainActivity.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }
}
