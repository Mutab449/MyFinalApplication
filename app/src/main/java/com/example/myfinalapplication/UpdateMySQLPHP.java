package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMySQLPHP extends AppCompatActivity {

    phpConn phpC = new phpConn();
    EditText editName,editPhone,editEmail;
    Button btnUpdatephp,btnCancel;
    String IDphp= UpdateMySQL.updatePHPbyID();
    String Namephp= UpdateMySQL.updatePHPbyName();
    String Phonephp= UpdateMySQL.updatePHPbyPhone();
    String Emailphp= UpdateMySQL.updatePHPbyEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mysql_php);

        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        btnUpdatephp = (Button) findViewById(R.id.btnUpdatephp);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        editName.setText(Namephp);
        editPhone.setText(Phonephp);
        editEmail.setText(Emailphp);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UpdateMySQLPHP.this,UpdateMySQL.class);
                startActivity(i);
            }
        });

        btnUpdatephp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PHPName = editName.getText().toString();
                String PHPPhone = editPhone.getText().toString();
                String PHPEmail = editEmail.getText().toString();

                if(PHPName.length() != 0 && PHPPhone.length() != 0 && PHPEmail.length() != 0){
                    if (!Patterns.EMAIL_ADDRESS.matcher(PHPEmail).matches()){
                        Toast.makeText(getApplicationContext(),"formal Email not correct",Toast.LENGTH_SHORT).show();

                    }else {
                        phpC.execute("http://192.168.8.104/sqli/update.php?field1-name=" + PHPName + "&field2-name=" + PHPPhone + "&field3-name=" + PHPEmail + "&id=" + IDphp);
                        Toast.makeText(UpdateMySQLPHP.this, "The update is successful", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(UpdateMySQLPHP.this, UpdateMySQL.class);
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(UpdateMySQLPHP.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
