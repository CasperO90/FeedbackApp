package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Button button5,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);


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


        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == button5) {
            Intent intent = new Intent(this, MoedeDeltagActivity.class);
            startActivity(intent);
        }

        if(view == button7) {
            afslutAlleActivity();

        }






    }


    public void afslutAlleActivity(){
        Intent intent = new Intent(this, FoersteLederActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
