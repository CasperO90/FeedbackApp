package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Highscore extends AppCompatActivity implements View.OnClickListener {


    TextView tv1,tv2,tv3,tv4;
    Button butbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);


        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView6);
        tv3 = (TextView) findViewById(R.id.textView10);
        tv4 = (TextView) findViewById(R.id.textView11);
        butbut =(Button)findViewById(R.id.button6);
        butbut.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {

        if(butbut==v ){

                Intent intent = new Intent(this, FoersteLederActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
                finish();


        }
    }
}
