package com.example.myfinalapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class ViewListContentsPHP extends AppCompatActivity {
    ArrayList<User> userList; //define object  userList as a ArrayList
    ListView listView; //define object  listView as a ListView
    User user; //create a user connection to User
    phpConn phpC = new phpConn(); //create a phpC connection to phpcoon
    final String fetch = "http://192.168.8.104/sqli/fetch2json.php";
    JSONArray js_array; //define object  js_array as a JSONArray
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
                Intent i = new Intent(ViewListContentsPHP.this,MySQL.class);
                Log.v("MutabLog:", "intent executed");
                startActivity(i);
                Log.v("MutabLog:", "startActivity executed");
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
        ManyColumn_ListAdapter adapter = new ManyColumn_ListAdapter(this,R.layout.list_adapter_view, userList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(final AdapterView<?> adapterView, final View view, final int position, long l) {
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
                    String remainder1 = remainder.substring(remainder.indexOf(",")+2, remainder.length());
                    String value3 = remainder1.substring( 0, remainder1.indexOf(","));
                    value3=value3.replace("\"" ,"");
                    Log.v("george value3 ",value3.toString());
                    String remainder2 = remainder1.substring(remainder1.indexOf(",")+1, remainder1.length()-1);
                    String value4 = remainder2.substring(0);
                    value4=value4.replace("\"" ,"");
                    Log.v("george value4 ",value4.toString());

                    Toast.makeText(getApplicationContext(), value1+". "+value2+". "+value3+". "+value4, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }
        });
    }
}
