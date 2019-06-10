package com.example.lab3_braodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {



    Notification notification;

    Intent aeroplane , battery ;
    Button back;

    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            int level = i.getIntExtra("level", 0);

            if (level < 20) {
                notification = new Notification("Battery Low " , "Battery is low , and connect your charger" , c);
                notification.display();
                Toast.makeText(c, "low battery", Toast.LENGTH_LONG).show();
            } else if (level > 50) {
                notification = new Notification("Battery Good " , "Battery is good but to avoid low battery , connect your charger" , c);
                notification.display();
                Toast.makeText(c, "good battery", Toast.LENGTH_LONG).show();
            }
            if (level == 100) {
                notification = new Notification("Full Charged" , "Battery is on , and its 100 % charged"  , c);
                notification.display();
                Toast.makeText(c, "full battery", Toast.LENGTH_LONG).show();
            }
        }

    };


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {

            notification = new Notification("Aeroplane Mode" , "Aeroplane mode changed" , c);
            notification.display();

        }

    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = findViewById(R.id.back);
        aeroplane = registerReceiver(broadcastReceiver, new IntentFilter(
                Intent.ACTION_AIRPLANE_MODE_CHANGED));

        battery = registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this , MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });


    }

}
