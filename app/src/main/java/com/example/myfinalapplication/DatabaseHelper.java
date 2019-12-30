package com.example.myfinalapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 2016-05-13.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    String dbname= SearchInDB.getDbName();

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "name";
    public static final String COL3 = "phone";
    public static final String COL4 = "email";
    public static final String COL5 = "street";
    public static final String COL6 = "place";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT, phone TEXT, email TEXT, street TEXT, place TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String dName,String dPhone,String dEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, dName);
        contentValues.put(COL3, dPhone);
        contentValues.put(COL4, dEmail);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getID( String namee){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users_data where name like '"+namee+"'", null );
        return res;
    }
    public Integer deleteContactByName (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users_data",
                "name = ? ",
                new String[] { name });
    }
    public Integer deleteContactId (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users_data",
                "ID = ? ",
                new String[] { id });
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getListContentsBySearch() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM users_data where name like '%"+dbname+"%' or phone like '%"+dbname+"%' or email like '%"+dbname+"%' or ID like '%"+dbname+"%' ", null);
        return data;
    }

    public List<User> getAllContacts() {
        List<User> contactList = new ArrayList<User>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                User contact = new User();
                contact.setID(cursor.getString(0));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contact.setEmail(cursor.getString(3));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }


        return contactList;
    }
    public List<User> getAllContactss() {
        List<User> userList = new ArrayList<User>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setID(cursor.getString(0));
                user.setName(cursor.getString(1));
                user.setPhone(cursor.getString(2));
                user.setEmail(cursor.getString(3));

                userList.add(user);
            } while (cursor.moveToNext());
        }


        return userList;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users_data where ID="+id+"", null );
        return res;
    }

    public boolean updateContact (String id, String name, String phone, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        db.update("users_data", contentValues, "ID = ? ", new String[] { (id) } );
        return true;
    }
}
