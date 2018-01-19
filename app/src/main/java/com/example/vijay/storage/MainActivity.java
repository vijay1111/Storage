package com.example.vijay.storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vijay.storage.ExternalStorage.ExternalStorage1;
import com.example.vijay.storage.InternalStorage.InternalStorage1;
import com.example.vijay.storage.SharedPrefrence.SharedPrefrence1;
import com.example.vijay.storage.Sqlite.SQLITE1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.sharedpref:
                startActivity(new Intent(getApplicationContext(), SharedPrefrence1.class));
                break;
            case R.id.internalstorage:
                startActivity(new Intent(getApplicationContext(), InternalStorage1.class));
                break;
            case R.id.externalstorage:
                startActivity(new Intent(getApplicationContext(), ExternalStorage1.class));
                break;
            case R.id.sqlite:
                startActivity(new Intent(getApplicationContext(), SQLITE1.class));
                break;


        }
    }

}
