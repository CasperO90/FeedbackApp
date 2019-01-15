package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.StartActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.PriorityQueue;
import java.util.Random;

public class MoedeOprettet extends AppCompatActivity implements OnClickListener {

    private TextView mødeIdTekst;
    private int mødeID;
    private String mødeID1;
    private Button button5;
    private String nymødeID;
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
        //får det som string
        nymødeID = String.valueOf(mødeID);

        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);

        //
        button5 = findViewById(R.id.forsideBtn);
        button5.setOnClickListener(this);



        mDatabase = FirebaseDatabase.getInstance().getReference().child("ModeID/"+nymødeID);


        mDatabase.setValue(nymødeID).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(MoedeOprettet.this, "stored", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MoedeOprettet.this, "error", Toast.LENGTH_LONG).show();
                }

            }
        });



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
