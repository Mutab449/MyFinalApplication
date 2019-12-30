package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertPhp extends AppCompatActivity {

    phpConn phpC = new phpConn();  //create a phpC connection to phpcoon
    EditText editName,editPhone,editEmail;  //define object  editName,editPhone,editEmail as a EditText
    Button btnInsertPHP;  //define object  btnInsertPHP as a Button
    Button btnBack; //define object  btnBack as a Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_php);
        editName     = (EditText) findViewById(R.id.editName);   //Connect the object editName to the id in activity_insert_php
        editPhone    = (EditText) findViewById(R.id.editPhone);  //Connect the object editPhone to the id in activity_insert_php
        editEmail    = (EditText) findViewById(R.id.editEmail);  //Connect the object editEmail to the id in activity_insert_php
        btnInsertPHP = (Button) findViewById(R.id.btnInsertPHP); //Connect the object btnInsertPHP to the id in activity_insert_php
        btnBack      = (Button) findViewById(R.id.btnBack);     //Connect the object btnBack to the id in activity_insert_php

        btnInsertPHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnInsertPHP Button");
                String PHPName  = editName.getText().toString(); //Define a String type variable to take data from EditText
                String PHPPhone = editPhone.getText().toString();//Define a String type variable to take data from EditText
                String PHPEmail = editEmail.getText().toString();//Define a String type variable to take data from EditText

                //If the length of any of the variables != 0 &  the email is written correctly Run the codes inside the condition
                if(PHPName.length() != 0 && PHPPhone.length() != 0 && PHPEmail.length() != 0 ){
                    if (!Patterns.EMAIL_ADDRESS.matcher(PHPEmail).matches()){
                        Toast.makeText(getApplicationContext(),"formal Email not correct",Toast.LENGTH_SHORT).show();

                    }else {
                        //Send variables via the link
                        phpC.execute("http://192.168.8.104/sqli/insert.php?field1-name=" + PHPName + "&field2-name=" + PHPPhone + "&field3-name=" + PHPEmail);
                        editName.setText("");  //clear EditText
                        editPhone.setText(""); //clear EditText
                        editEmail.setText(""); //clear EditText
                        Log.v("MutabLog", "Successfully inserted record to MySQL");
                        Toast.makeText(InsertPhp.this, "Insert to PHP Successfully", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(InsertPhp.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(InsertPhp.this,MySQL.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }
}
