package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);


        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView6);
        tv3 = (TextView) findViewById(R.id.textView10);
        tv4 = (TextView) findViewById(R.id.textView11);



        Intent intent = getIntent();
        String message = (intent.getStringExtra("sur"));
        String message1 = (intent.getStringExtra("neutral"));
        String message2 = (intent.getStringExtra("tilfreds"));
        String message3 = (intent.getStringExtra("glad"));


        tv1.setText(message);
        tv2.setText(message1);
        tv3.setText(message2);
        tv4.setText(message3);

    }
}
