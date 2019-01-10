package com.example.casper.feedbackapp.Mødeleder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.casper.feedbackapp.R;

public class LogIn extends AppCompatActivity implements View.OnClickListener {


    private Button mButton6;
    private Button mButton7;
    private Chronometer chronometer;
    private boolean running;
    private boolean afsluttet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_slut_moede);

        // action bar
        getSupportActionBar().setTitle("Møde"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar


        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Tid: %s");


        mButton6 = findViewById(R.id.Afslutmoede);
        mButton7 = findViewById(R.id.SeFeedback);
        mButton7.setOnClickListener(this);
        mButton6.setOnClickListener(this);


    }

    @SuppressLint("WrongConstant")
    @Override

    public void onClick(View v) {

        if(mButton6 ==v){



        if (mButton6 == v && running==false && afsluttet==false) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
            mButton6.setText("Afslut");
            mButton7.setVisibility(View.INVISIBLE);

        }else if(mButton6 == v && running==true){
            chronometer.stop();
            running = false;
            afsluttet = true;
            mButton7.setVisibility(View.VISIBLE);

            mButton6.setText("Mødet er nu afsluttet");


        }}

        else if (mButton7==v && running==false) {

            SeFeedback();
        }


    }

    public void SeFeedback(){
        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);
} @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

}}


