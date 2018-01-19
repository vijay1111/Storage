package com.example.vijay.storage.InternalStorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vijay.storage.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorage1 extends AppCompatActivity {
    EditText username_ed, password_ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage1);


        username_ed = (EditText) findViewById(R.id.username_ed);
        password_ed = (EditText) findViewById(R.id.password_ed);
    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.save:
                String username = username_ed.getText().toString();
                String password = password_ed.getText().toString();
                username = username + " ";
                File file = null;
                FileOutputStream fileOutputStream = null;
                try {
                    file = getFilesDir();
                    fileOutputStream = openFileOutput("vijay.txt", Context.MODE_PRIVATE);
                    fileOutputStream.write(username.getBytes());
                    fileOutputStream.write(password.getBytes());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(this, "file created successfully" + file, Toast.LENGTH_SHORT).show();

                break;
            case R.id.next:
                startActivity(new Intent(getApplicationContext(), InternalStorage2.class));
                break;
        }
    }
}
