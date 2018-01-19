package com.example.vijay.storage.ExternalStorage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.example.vijay.storage.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExternalStorage2 extends AppCompatActivity {
    EditText editText;
    File folder;
    File file;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage2);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.internalcache:
                folder = getCacheDir();
                file = new File(folder, "vijayfile1.txt");
                data = readData(file);
                if (data != null) {
                    editText.setText(data);
                } else {
                    editText.setText("no data was returned");
                }
                break;
            case R.id.externalcache:
                folder = getExternalCacheDir();
                file = new File(folder, "vijayfile2.txt");
                data = readData(file);
                if (data != null) {
                    editText.setText(data);
                } else {
                    editText.setText("no data was returned");
                }
                break;
            case R.id.externalprivate:
                folder = getExternalFilesDir("vijay");//foldername
                file = new File(folder, "vijayfile3.txt");
                data = readData(file);
                if (data != null) {
                    editText.setText(data);
                } else {
                    editText.setText("no data was returned");
                }
                break;
            case R.id.externalpublic:
                folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                file = new File(folder, "vijayfile4.txt");
                data = readData(file);
                if (data != null) {
                    editText.setText(data);
                } else {
                    editText.setText("no data was returned");
                }
                break;
            case R.id.next:
                startActivity(new Intent(getApplicationContext(), ExternalStorage1.class));
                break;

        }
    }

    public String readData(File myfile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myfile);
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                stringBuffer.append((char) read);
            }
            return stringBuffer.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
