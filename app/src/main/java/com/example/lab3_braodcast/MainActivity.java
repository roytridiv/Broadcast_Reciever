package com.example.lab3_braodcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button but1 , but2;

    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.my_text);
        but1 = findViewById(R.id.send_broadcast);
        but2 = findViewById(R.id.next);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = text.getText().toString();

                Intent intent = new Intent("MyCustomIntent");

                intent.putExtra("msg", (CharSequence) input);
                intent.setAction("com.dev2qa.example.broadcast.activity.CUSTOM_BROADCAST");
                sendBroadcast(intent);

            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });


    }
}

