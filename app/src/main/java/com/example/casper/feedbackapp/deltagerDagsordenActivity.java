package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class deltagerDagsordenActivity extends AppCompatActivity implements OnClickListener {

    private Button feedbackBtn, tilbageLederBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deltager_dagsorden);

        //Button
        feedbackBtn = findViewById(R.id.feedbackBtn);
        feedbackBtn.setOnClickListener(this);

        tilbageLederBtn = findViewById(R.id.tilbageLederBtn);
        tilbageLederBtn.setOnClickListener(this);
    }

    public void startFeedback() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void tilbage() {
        Intent intent = new Intent(this, MoedeDeltagActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == feedbackBtn){
                startFeedback();
            }

        if(view == tilbageLederBtn){
            tilbage();
        }


    }
}
