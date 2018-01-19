package com.example.vijay.storage.SharedPrefrence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vijay.storage.R;

public class SharedPrefrence1 extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence1);
        username= (EditText) findViewById(R.id.username_ed);
        password= (EditText) findViewById(R.id.password_ed);
    }

    public void view_Click(View view) {
        switch (view.getId())
        {
            case R.id.save:
                SharedPreferences sharedPreferences=getSharedPreferences("mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("key1",username.getText().toString());
                editor.putString("key2",password.getText().toString());
                editor.commit();
                Toast.makeText(this, "data saved successfully ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.next:
                startActivity(new Intent(getApplicationContext(),SharedPrefrence2.class));
                break;
        }
    }
}
