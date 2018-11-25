package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class SlutActivity extends AppCompatActivity implements OnClickListener {

    Button forsideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slut);

        forsideButton = findViewById(R.id.forsideButton);
        forsideButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, StartActivity.class);
        startActivity(i);



    }
}
