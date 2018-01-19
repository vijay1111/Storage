package com.example.vijay.storage.SharedPrefrence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vijay.storage.R;

public class SharedPrefrence2 extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    TextView username_Tv, password_Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence2);
        username_Tv = (TextView) findViewById(R.id.username_tv);
        password_Tv = (TextView) findViewById(R.id.password_tv);

    }

    public void view_Click(View view) {
        switch (view.getId())
        {
            case R.id.button:
                SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("key1", DEFAULT);
                String password = sharedPreferences.getString("key2", DEFAULT);
                if (username.equals(DEFAULT) || password.equals(DEFAULT)) {
                    Toast.makeText(this, "no data loaded ", Toast.LENGTH_SHORT).show();
                } else {
                    username_Tv.setText(username);
                    password_Tv.setText(password);
                    Toast.makeText(this, "data loaded successfully", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.prev:
                startActivity(new Intent(getApplicationContext(), SharedPrefrence1.class));
                break;
        }
    }
}
