package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LederStartMoedeActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mButton5,mButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_start_moede);


        mButton5 = (Button)findViewById(R.id.button2);
        mButton6 = (Button)findViewById(R.id.tilbageBtn);


        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        //videre
        if(mButton5 == v){
           // videre();
        }


        //tilbage knap
        if (mButton6 == v){
            tilbage();
        }


    }






    public void tilbage(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
    }


    public void videre(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);

    }

}
