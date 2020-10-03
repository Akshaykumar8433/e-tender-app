package com.tender;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;
public class MyDatabaseHelper extends SQLiteOpenHelper  {




    public MyDatabaseHelper(@Nullable Context context) {
        super(context, "tender.db", null, 1);
    }


    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert(  "userinfo", "",contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table userinfo(userid integer primary key autoincrement, username text, email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userinfo");
    }

    //inserting in db
    public boolean insert(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("userinfo",null,contentValues);
        if(ins==1) return false;
        else return true;
    }

    //checking if email exist
    public Boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from userinfo where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //Checking the email and password
    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from userinfo where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}

