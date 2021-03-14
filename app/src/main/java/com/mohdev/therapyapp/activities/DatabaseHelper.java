package com.mohdev.therapyapp.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_EMAIL = "database_email";
    private static final String TABLE_EMAIL = "table_email";

    DatabaseHelper(Context context) {
        super(context, DATABASE_EMAIL, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = String.format("create table%s(id INTEGER PRIMARY KEY,txt KEY)", TABLE_EMAIL);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTS%s", TABLE_EMAIL));
        onCreate(db);
    }

    public boolean getEmail(String edittxt) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", edittxt);
        sqLiteDatabase.insert(TABLE_EMAIL, null, contentValues);
        return true;
    }

    public boolean addText(String text) {
return true;

    }

    public boolean getPass(String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", pass);
        sqLiteDatabase.insert(TABLE_EMAIL, null, contentValues);
        return true;
    }

}