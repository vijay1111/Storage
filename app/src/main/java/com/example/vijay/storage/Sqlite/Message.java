package com.example.vijay.storage.Sqlite;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vijay on 19/9/17.
 */

public class Message {
    public static void message(Context context,String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

}
