package com.example.myfinalapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchDB extends AppCompatActivity {

    DatabaseHelper myDB; //create a myDB connection to DatabaseHelper
    ArrayList<User> userList; //define object  userList as a ArrayList
    ListView listView;  //define object  listView as a ListView
    User user;  //create a user connection to User
    Button btnBack; //define object  btnBack as a Button
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);
        btnBack = (Button) findViewById(R.id.btnBack); //Connect the object btnBack to the id in viewcontents_layout
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MutabLog", "clicked on btnBack Button");
                Intent i = new Intent(SearchDB.this,SearchInDB.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
            }
        });
        myDB = new DatabaseHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDB.getListContentsBySearch();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(SearchDB.this,"Not Found in Database  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                user = new User(data.getString(0),data.getString(1),data.getString(2),data.getString(3));
                userList.add(i,user);
                System.out.println(data.getString(0)+" "+data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
                System.out.println(userList.get(i).getID());
                i++;
            }
            ManyColumn_ListAdapter adapter =  new ManyColumn_ListAdapter(this,R.layout.list_adapter_view, userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }

    }
}
