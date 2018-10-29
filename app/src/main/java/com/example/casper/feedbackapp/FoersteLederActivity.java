package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class FoersteLederActivity extends AppCompatActivity implements OnClickListener{

    private Button opretMødeBtn, startMødeBtn, tilbageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foerste_leder);

        //Button
        opretMødeBtn = findViewById(R.id.opretMødeBtn);
        opretMødeBtn.setOnClickListener(this);

        startMødeBtn = findViewById(R.id.startMødeBtn);
        startMødeBtn.setOnClickListener(this);

        tilbageBtn = findViewById(R.id.tilbageBtn);
        tilbageBtn.setOnClickListener(this);
    }

    public void tilbage(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void opretMøde(){
        Intent intent = new Intent(this, LederOpretMoedeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Button button = (Button) view;

            if(button == tilbageBtn){
                tilbage();
            }

            else if(button == opretMødeBtn){
                opretMøde();
            }
        }
    }
}
