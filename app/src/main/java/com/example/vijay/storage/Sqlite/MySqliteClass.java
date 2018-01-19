package com.example.vijay.storage.Sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vijay on 19/9/17.
 */

public class MySqliteClass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MYDATABASENAME";
    private static final String TABLE_NAME = "MYTABLENAME";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_id";
    private static final String NAME = "Name";
    private static final String Address = "Address";
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("+ UID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ Address+ " TEXT" + ")";



    private static final String DROP_TABLE = "DROP TABLE IF EXISTS"+ TABLE_NAME;
    Context context;

    public MySqliteClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Message.message(context, "contructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Message.message(context, "onCreate called");

        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            //execSQL cannot return anything so it cannot be used select and insert queries
        } catch (SQLException e) {
            Message.message(context, " " + e);
            System.out.println(e);
        }


    }

    //when something changes inside database structure
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Message.message(context, " onUpgrade called ");
        try {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        } catch (SQLException e) {
            e.printStackTrace();
            Message.message(context, " " + e);
            System.out.println(e);
        }

    }
}
