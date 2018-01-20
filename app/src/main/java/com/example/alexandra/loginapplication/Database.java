package com.example.alexandra.loginapplication;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import com.example.alexandra.loginapplication.User;

class Database extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="users.db";
    private static final int DATABASE_VERSION =1;

    public static final String TABLE_NAME="users_table";
    public static final String ID = "user_id";
    public static final String USERNAME="user_name";
    public static final String PASSWORD="user_password";

    //query - create & drop
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " TEXT, " + PASSWORD  + " TEXT " + ")";

    private static final String DROP_TABLE_QUERY =  "DROP TABLE IF EXISTS " + TABLE_NAME;


    // constructor
    public  Database (Context context) {

        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // add user - vineri 19.01.2018
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME, user.getUsername());
        values.put(PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}