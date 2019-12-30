package com.example.myfinalapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class DeleteFromPHP extends AppCompatActivity {
    ArrayList<User> userList;
    ListView listView;
    User user;
    ManyColumn_ListAdapter adapter;
    phpConn phpC = new phpConn();
    final String fetch = "http://192.168.8.104/sqli/fetch2json.php";
    final String linkD="http://192.168.8.104/sqli/delete.php?id=";
    JSONArray js_array;
    Button btnBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DeleteFromPHP.this,MySQL.class);
                startActivity(i);
            }
        });

        String getRet = phpC.execute(fetch);
        userList = new ArrayList<>();
        try {
            js_array = new JSONArray(getRet);
            /* reading the JSON array line by line */
            for (int i = 0; i < js_array.length(); i++) {
                String value=js_array.getString(i);
                String value1 = value.substring(2, value.indexOf(","));
                value1=value1.replace("\"","");
                Log.v("george value1 ",value1.toString());
                String remainder = value.substring(value.indexOf(",")+1, value.length());
                String value2 = remainder.substring( 0, remainder.indexOf(","));
                value2=value2.replace("\"","");
                Log.v("george value2 ",value2.toString());
                String remainder1 = remainder.substring(remainder.indexOf(",")+1, remainder.length());
                String value3 = remainder1.substring( 0, remainder1.indexOf(","));
                value3=value3.replace("\"","");
                Log.v("george value3 ",value3.toString());
                String remainder2 = remainder1.substring(remainder1.indexOf(",")+1, remainder1.length()-1);
                String value4 = remainder2.substring(0);
                value4=value4.replace("\"","");
                Log.v("george value4 ",value4.toString());
                user = new User(value1,value2,value3,value4);
                userList.add(i,user);
            }
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        adapter = new ManyColumn_ListAdapter(this,R.layout.list_adapter_view, userList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, final View view, final int position, long l) {
                final int which_item = position;
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(DeleteFromPHP.this);
                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");
                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete this?");
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            int pos=position;
                            String curValue =js_array.getString(position);
                            Log.v("Array with ",curValue);
                            String value=js_array.getString(position);
                            String value1 = value.substring(1, value.indexOf(","));
                            value1=value1.replace("\"" ,"");
                            Log.v("george value1 ",value1.toString());
                            String remainder = value.substring(value.indexOf(",")+2, value.length());
                            String value2 = remainder.substring( 0, remainder.indexOf(","));
                            value2=value2.replace("\"" ,"");
                            Log.v("george value2 ",value2.toString());


                            Toast.makeText(getApplicationContext(), "Deleted successfully "+value2, Toast.LENGTH_SHORT).show();
                            phpC.execute(linkD + value1);
                            userList.remove(pos);
                            adapter.notifyDataSetChanged();

                        } catch (Exception e) {
                            Log.e("Error", e.toString());
                        }
                    }
                });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                alertDialog.show();
                return false;
            }
        });

    }
}
