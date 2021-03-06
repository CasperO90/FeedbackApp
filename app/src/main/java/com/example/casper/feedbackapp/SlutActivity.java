package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
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

    MoedeDeltagActivity User = new MoedeDeltagActivity();

    Button forsideButton;
    public static String slutsur,slutneutral,sluttilfreds,slutglad ;
    TextView surTekst,neutralTekst,tilfredsTekst,gladtekst, spmTextView;
    EditText kommentarView;

    private DatabaseReference ref;
    private FirebaseDatabase mFirebaseDatabase;
    String kommentarFraUser;
    int mødetest;
    String nytid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slut);

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


        forsideButton = findViewById(R.id.forsideButton);
        forsideButton.setOnClickListener(this);


        surTekst = findViewById(R.id.surTekst);
        surTekst.setText("" +slutsur);

        neutralTekst = findViewById(R.id.neutralTekst);
        neutralTekst.setText("" +slutneutral);

        tilfredsTekst = findViewById(R.id.tilfredsTekst);
        tilfredsTekst.setText("" +sluttilfreds);

        gladtekst = findViewById(R.id.gladTekst);
        gladtekst.setText("" +slutglad);

       // spmTextView = findViewById(R.id.spmTextView);
        //spmTextView.setText(R.string.afslut);

        //EditText
        kommentarView = findViewById(R.id.kommentarView);

        mødetest = AppState.getMødeID();

        nytid = String.valueOf(mødetest);





    }

    @Override
    public void onClick(View view) {
        kommentarFraUser = kommentarView.getText().toString();
        if(!(kommentarFraUser.equals(""))) {

            mFirebaseDatabase = FirebaseDatabase.getInstance();
            ref = FirebaseDatabase.getInstance().getReference().child("Kommentar/" + User.UserMødeID);

            HashMap<String, String> datamap = new HashMap<String, String>();

            datamap.put("edittext", kommentarFraUser);


            ref.push().setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Log.d("Test","Dette er gemt");
                    } else {
                        Log.d("Test","Dette er ikke gemt");
                    }





                }
            });

        }



        
        Intent i = new Intent(this, StartActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
