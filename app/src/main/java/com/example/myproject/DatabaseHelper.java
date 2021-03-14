package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASENAME = "myDB.db";
    private static final String TABLE_RECORD = "tblusers";
    private static final int DATABASEVERSION = 1;
    // ?
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_IMAGE = "imgProfile";
    private static final String[] allColumns = {COLUMN_ID, COLUMN_NAME, COLUMN_PHONE,COLUMN_PASSWORD,  COLUMN_IMAGE};

    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " +
            TABLE_RECORD + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +COLUMN_PHONE+" TEXT,"+COLUMN_PASSWORD + " TEXT," +
            COLUMN_IMAGE + " BLOB);";

    private SQLiteDatabase database; // access to table

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }


    // creating the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    // in case of version upgrade -> new schema
    // database version
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORD);
        onCreate(sqLiteDatabase);
    }


    // get the user back with the id
    // also possible to return only the id
    public User insert(User user)
    {
        database = getWritableDatabase(); // get access to write the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE,user.getPhone());
        values.put(COLUMN_PASSWORD,user.getPassWord());
        long id = database.insert(TABLE_RECORD, null, values);
        user.setId(id);
        database.close();
        return user;
    }

    // remove a specific user from the table
    public void deleteUser(User user)
    {
        long id=user.getId();
        deleteById(id);
    }
    public void deleteById(long id )
    {
        database = getWritableDatabase(); // get access to write e data
        database.delete(TABLE_RECORD, COLUMN_ID + " = " + id, null);
        database.close(); // close the database

    }
    // update a specific user
    public void update(User user)
    {
        database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.getId());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PHONE,user.getPhone());
        values.put(COLUMN_PASSWORD,user.getPassWord());

        database.update(TABLE_RECORD, values, COLUMN_ID + "=" + user.getId(), null);
        database.close();

    }

    // return all rows in table
    public ArrayList<User> selectAll()
    {
        database = getReadableDatabase(); // get access to read the database
        ArrayList<User> users = new ArrayList<>();
        String sortOrder = COLUMN_NAME + " DESC"; // sorting by score
        Cursor cursor = database.query(TABLE_RECORD, allColumns, null, null, null, null, sortOrder); // cursor points at a certain row
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
                String password=cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                byte[] pic=cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                User user= new User(id,name, phone ,password);
                users.add(user);
            }
        }
        database.close();
        return users;
    }

    //
    // I prefer using this one...
    //
    public ArrayList<User> genericSelectByUserName(String userName)
    {
        String[] vals = { userName };
        // if using the rawQuery
        String query = "SELECT * FROM " + TABLE_RECORD + " WHERE " + COLUMN_NAME + " = ?";
        String column = COLUMN_NAME;
        return select(column,vals);
    }


    // INPUT: notice two options rawQuery should look like
    // rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
    // OUTPUT: arraylist - number of elements accordingly
    public ArrayList<User> select(String column, String[] values)
    {
        database = getReadableDatabase(); // get access to read the database
        ArrayList<User> users = new ArrayList<>();
        // Two options,
        // since query cannot be created in compile time there is no difference
        //Cursor cursor = database.rawQuery(query, values);
        Cursor cursor= database.query(TABLE_RECORD, allColumns, COLUMN_NAME +" = ? ", values, null, null, null); // cursor points at a certain row
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
                String password=cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                byte[] pic=cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                User user= new User(id,name, phone, password);
                users.add(user);
            }// end while
        } // end if
        database.close();
        return users;
    }

}

