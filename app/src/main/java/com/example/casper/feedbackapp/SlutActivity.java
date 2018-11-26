package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class SlutActivity extends AppCompatActivity implements OnClickListener {

    Button forsideButton;
    public static String slutsur,slutneutral,sluttilfreds,slutglad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slut);

        forsideButton = findViewById(R.id.forsideButton);
        forsideButton.setOnClickListener(this);

        Intent intent = getIntent();
         slutsur = intent.getStringExtra("sur");
         slutneutral = intent.getStringExtra("neutral");
         sluttilfreds = intent.getStringExtra("tilfreds");
         slutglad = intent.getStringExtra("glad");



    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, StartActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);



    }
}
