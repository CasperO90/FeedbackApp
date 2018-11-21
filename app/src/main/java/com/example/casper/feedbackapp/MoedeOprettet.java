package com.example.casper.feedbackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.PriorityQueue;
import java.util.Random;

public class MoedeOprettet extends AppCompatActivity {

    private TextView mødeIdTekst;
    private int mødeID;
    private String mødeID1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);


        //Textview
        mødeIdTekst = findViewById(R.id.mødeIdTekst);

        //Opretter møde id
        Random random = new Random();
        mødeID = random.nextInt(1000) + 1;
        AppState.setMødeID(mødeID);

        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);

    }

}
