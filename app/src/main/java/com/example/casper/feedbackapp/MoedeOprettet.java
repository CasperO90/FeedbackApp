package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.PriorityQueue;
import java.util.Random;

public class MoedeOprettet extends AppCompatActivity implements OnClickListener{

    private TextView mødeIdTekst;
    private int mødeID;
    private String mødeID1;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);

        //action bar
        getSupportActionBar().setTitle("Møde er Oprettet"); // for set actionbar title



        //Textview
        mødeIdTekst = findViewById(R.id.mødeIdTekst);

        //Opretter møde id
        Random random = new Random();
        mødeID = random.nextInt((1000)+1);

        //Gem møde
        AppState.setMødeID(mødeID);
        Log.d("TEST", "" + mødeID);


        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);


        button5 = findViewById(R.id.forsideBtn);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == button5) {
            Intent intent = new Intent(this, MoedeDeltagActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }




}
