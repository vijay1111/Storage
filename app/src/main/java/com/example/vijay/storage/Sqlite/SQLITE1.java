package com.example.vijay.storage.Sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vijay.storage.R;

public class SQLITE1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite1);
        MySqliteClass mySqliteClass=new MySqliteClass(this);

        SQLiteDatabase sqLiteDatabase=  mySqliteClass.getWritableDatabase();

    }
}
