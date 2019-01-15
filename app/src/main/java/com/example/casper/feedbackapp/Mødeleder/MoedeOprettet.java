package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.StartActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.PriorityQueue;
import java.util.Random;

public class MoedeOprettet extends AppCompatActivity implements OnClickListener {

    private TextView mødeIdTekst;
    private int mødeID;
    private Button button5;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);

        //action bar
        getSupportActionBar().setTitle("Møde er Oprettet"); // for set actionbar title

        //Textview
        mødeIdTekst = findViewById(R.id.mødeIdTekst);

        //Opretter møde id
        mødeID = AppState.opretMødeID();

        //Gem møde
        AppState.setMødeID(mødeID);


        //Møde id
        int test = AppState.getMødeID();

        //Møde id laves om til en string
        String Datatest = String.valueOf(test);


        mDatabase = FirebaseDatabase.getInstance().getReference().child(Datatest);

        if (Datatest.equals(mDatabase)){
            test ++;
        }

        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);

        //
        button5 = findViewById(R.id.forsideBtn);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == button5) {
            Intent intent = new Intent(this, StartActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
