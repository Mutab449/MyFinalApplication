package com.example.myfinalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ManyColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ManyColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView id = (TextView) convertView.findViewById(R.id.textID);
            TextView name = (TextView) convertView.findViewById(R.id.textName);
            TextView phone = (TextView) convertView.findViewById(R.id.textPhone);
            TextView email = (TextView) convertView.findViewById(R.id.textEmail);
            if (id != null) {
                id.setText(user.getID());
            }
            if (name != null) {
                name.setText((user.getName()));
            }
            if (phone != null) {
                phone.setText((user.getPhone()));
            }
            if (email != null) {
                email.setText((user.getEmail()));
            }
        }

        return convertView;
    }
}
