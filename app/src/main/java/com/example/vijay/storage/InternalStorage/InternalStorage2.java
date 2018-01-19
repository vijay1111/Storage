package com.example.vijay.storage.InternalStorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.vijay.storage.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InternalStorage2 extends AppCompatActivity {
    TextView username_tv, password_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage2);
        username_tv = (TextView) findViewById(R.id.username_tv);
        password_tv = (TextView) findViewById(R.id.password_tv);
    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.show:
                try {
                    int read=-1;//if file is empty then it gives -1
                    FileInputStream fileInputStream = openFileInput("vijay.txt");
                    StringBuffer stringBuffer=new StringBuffer();

                   while ((read= fileInputStream.read())!=-1)
                   {
                    stringBuffer.append((char) read);
                   }
                    System.out.println(stringBuffer.toString());
                   String txt1= stringBuffer.substring(0,stringBuffer.indexOf(" "));
                   String txt2= stringBuffer.substring(stringBuffer.indexOf(" "));
                    username_tv.setText(txt1);
                    password_tv.setText(txt2);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.prev:
                startActivity(new Intent(getApplicationContext(), InternalStorage1.class));
                break;
        }
    }
}
