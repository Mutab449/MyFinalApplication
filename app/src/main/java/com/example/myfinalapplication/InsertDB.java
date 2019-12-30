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

public class InsertDB extends AppCompatActivity {

    EditText editName,editPhone,editEmail; //define object  editName,editPhone,editEmail as a EditText
    Button btnInsertDB; //define object  btnInsertDB as a Button
    Button btnBack; //define object  btnBack as a Button
    DatabaseHelper myDB; //create a myDB connection to DatabaseHelper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_db);

        editName    = (EditText) findViewById(R.id.editName); //Connect the object editName to the id in activity_insert_db
        editPhone   = (EditText) findViewById(R.id.editPhone);//Connect the object editPhone to the id in activity_insert_db
        editEmail   = (EditText) findViewById(R.id.editEmail);//Connect the object editEmail to the id in activity_insert_db
        btnInsertDB = (Button) findViewById(R.id.btnInsertDB);//Connect the object btnInsertDB to the id in activity_insert_db
        btnBack     = (Button) findViewById(R.id.btnBack);   //Connect the object btnBack to the id in activity_insert_db
        myDB = new DatabaseHelper(this);

        btnInsertDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnInsertDB Button");
                String dName = editName.getText().toString();
                String dPhone = editPhone.getText().toString();
                String dEmail = editEmail.getText().toString();

                //If the length of any of the variables != 0 &  the email is written correctly Run the codes inside the condition
                if(dName.length() != 0 && dPhone.length() != 0 && dEmail.length() != 0){
                    if (!Patterns.EMAIL_ADDRESS.matcher(dEmail).matches()){
                        Toast.makeText(getApplicationContext(),"formal Email not correct",Toast.LENGTH_SHORT).show();

                    }else{
                    AddData(dName,dPhone, dEmail);
                        Log.v("MutabLog", "Successfully inserted record to db");
                    editName.setText("");   //clear EditText
                    editPhone.setText(""); //clear EditText
                    editEmail.setText("");//clear EditText
                    }

                }else{
                    Toast.makeText(InsertDB.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(InsertDB.this,SQLite.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
    }

    public void AddData(String Name,String Phone, String Email ){
        boolean insertData = myDB.addData(Name, Phone,  Email);

        if(insertData==true){
            Toast.makeText(InsertDB.this,"Successfully Inserted Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(InsertDB.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
