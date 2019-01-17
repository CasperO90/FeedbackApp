package com.example.casper.feedbackapp;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.casper.feedbackapp.Fragment.Tab1;
import com.example.casper.feedbackapp.Mødedeltager.MoedeDeltagActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SlutActivity extends AppCompatActivity implements OnClickListener {


    Button forsideButton;
    public static String slutsur,slutneutral,sluttilfreds,slutglad ;

    int mødetest;
    String nytid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slut);

        forsideButton = findViewById(R.id.forsideButton);
        forsideButton.setOnClickListener(this);

        mødetest = AppState.getMødeID();

        nytid = String.valueOf(mødetest);


       // intent
        Intent intent = getIntent();
         slutsur = intent.getStringExtra("sur");
         slutneutral = intent.getStringExtra("neutral");
         sluttilfreds = intent.getStringExtra("tilfreds");
         slutglad = intent.getStringExtra("glad");

        Log.d("check",""+slutsur);
        Log.d("check",""+slutneutral);
        Log.d("check",""+sluttilfreds);
        Log.d("check",""+slutglad);








    }

    @Override
    public void onClick(View view) {


        Intent i = new Intent(this, StartActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
