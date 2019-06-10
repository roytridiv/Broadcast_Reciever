package com.example.lab3_braodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    Notification notification;

    @Override
    public void onReceive(Context context, Intent intent) {

        CharSequence intentData = intent.getCharSequenceExtra("msg");
        String s = "" + intentData;

        if (s == null) {

        } else {
            notification = new Notification("Broadcast Message", s, context);
            notification.display();
            Toast.makeText(context, "The broadcast Message is : " + s, Toast.LENGTH_LONG).show();
        }
    }

}