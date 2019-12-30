package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateSQLiteDB extends AppCompatActivity {
    EditText editName,editPhone,editEmail;
    Button btnUpdatedb,btnCancel;
    DatabaseHelper myDB;
    String IDupdate= UpdateSQLite.updatebyID();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sqlite_db);
        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnUpdatedb = (Button) findViewById(R.id.btnUpdatedb);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        myDB = new DatabaseHelper(this);
        setDataInEditText(IDupdate);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UpdateSQLiteDB.this,UpdateSQLite.class);
                startActivity(i);
            }
        });

        btnUpdatedb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name,phone,emalil;
                name=editName.getText().toString();
                phone=editPhone.getText().toString();
                emalil=editEmail.getText().toString();

                if(name.length() != 0 && phone.length() != 0 && emalil.length() != 0) {
                    if (!Patterns.EMAIL_ADDRESS.matcher(emalil).matches()) {
                        Toast.makeText(getApplicationContext(), "formal Email not correct", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean updated = myDB.updateContact(IDupdate, name, phone, emalil);
                        if (updated == true) {
                            Toast.makeText(getApplicationContext(), "The update is successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(UpdateSQLiteDB.this, UpdateSQLite.class);
                            startActivity(i);
                        }
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void setDataInEditText(String id) {
        Cursor getData = myDB.getData(id);
        if (getData.moveToNext()) {

            String dName = getData.getString(getData.getColumnIndex("name"));
            String dPhone = getData.getString(getData.getColumnIndex("phone"));
            String dEmail = getData.getString(getData.getColumnIndex("email"));
            editName.setText(dName);
            editPhone.setText(dPhone);
            editEmail.setText(dEmail);

        } else
            Toast.makeText(getApplicationContext(),"did not get any data...:-(", Toast.LENGTH_LONG).show();
        getData.close();

    }
}
