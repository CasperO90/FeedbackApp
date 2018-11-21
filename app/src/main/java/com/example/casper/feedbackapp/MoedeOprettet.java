package com.example.casper.feedbackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MoedeOprettet extends AppCompatActivity {

    private TextView mødeIdTekst;
    private int mødeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);


        //Textview
        mødeIdTekst = findViewById(R.id.mødeIdTekst);

        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);

        //Opretter møde id
        Random random = new Random();
        mødeID = random.nextInt(1000) + 1;
    }

    private void opretMødeID(){
        AppState.setMødeID(mødeID);
    }


}
