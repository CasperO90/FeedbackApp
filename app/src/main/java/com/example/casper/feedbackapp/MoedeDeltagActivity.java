package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener{

    private Button deltagBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_deltag);

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);
    }

    public void deltagMøde(){
        Intent intent = new Intent(this, deltagerDagsordenActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == deltagBtn){
           deltagMøde();
            }
        }

}