package com.example.vijay.storage.ExternalStorage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vijay.storage.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage1 extends AppCompatActivity {
    EditText editText;
    String data;
    File folder;
    File myfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage1);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.internalcache:
                 data=editText.getText().toString();
                folder=getCacheDir();
                myfile=new File(folder,"vijayfile1.txt");
                writeData(myfile,data);
                break;
            case R.id.externalcache:
                 data=editText.getText().toString();
                folder=getExternalCacheDir();
                myfile=new File(folder,"vijayfile2.txt");
                writeData(myfile,data);
                break;
            case R.id.externalprivate:

                data=editText.getText().toString();
                folder=getExternalFilesDir("vijay");////foldername
                myfile=new File(folder,"vijayfile3.txt");
                writeData(myfile,data);

                break;
            case R.id.externalpublic:

                data=editText.getText().toString();
                folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                myfile=new File(folder,"vijayfile4.txt");
                writeData(myfile,data);
                break;
            case R.id.next:
                startActivity(new Intent(getApplicationContext(), ExternalStorage2.class));
                break;

        }
    }
    private void writeData(File file,String data){
        FileOutputStream fileOutputStream=null;

        try {
            fileOutputStream=new FileOutputStream(myfile);
            fileOutputStream.write(data.getBytes());
//            message(data+"was writtern successfully "+myfile.getAbsolutePath());
            Toast.makeText(this, "was writtern successfully "+myfile.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStream!=null)
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
