package com.example.nard.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nard on 22/09/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accounts.db";
    private static final String TABLE_NAME = "accounts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table accounts (id integer primary key not null , " + "fullname text not null , username text not null , password text not null , email text not null);";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertAccount(Accounts a){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from accounts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_FULLNAME, a.getFullname());
        values.put(COLUMN_USERNAME, a.getUsername());
        values.put(COLUMN_EMAIL, a.getEmail());
        values.put(COLUMN_PASSWORD, a.getPassword());

        db.insert(TABLE_NAME , null , values);
        db.close();
    }

    public String searchUser(String username){
        db = this.getReadableDatabase();
        String query = "select username from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "Not Found!";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(username)){
                    b = cursor.getString(0);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    public String searchPass(String username){
        db = this.getReadableDatabase();
        String query = "select username, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "Not Found!";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(username)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

