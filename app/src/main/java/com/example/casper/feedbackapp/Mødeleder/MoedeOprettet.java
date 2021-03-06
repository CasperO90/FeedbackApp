package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.DagsordenLogik.Dagsorden;
import com.example.casper.feedbackapp.DagsordenLogik.DagsordenData;
import com.example.casper.feedbackapp.DagsordenLogik.Singleton;
import com.example.casper.feedbackapp.EmailLogik.SendMailTask;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.StartActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MoedeOprettet extends AppCompatActivity implements OnClickListener {

    private TextView emailTextView, mødeOprettet;
    private int mødeID;
    private String mødeID1;
    private Button button5;
    private String nymødeID;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    private DatabaseReference ref;
    private DatabaseReference bla;

    Set<String> nyTidligereMødere;

    public static Boolean a=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);

        emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText("Indtast din mail for at modtage dit møde ID");

        //action bar
        getSupportActionBar().setTitle("Møde er Oprettet"); // for set actionbar title


        //Opretter møde id
        mødeID = AppState.opretMødeID();


        //Textview der viser mødeID
        mødeOprettet = findViewById(R.id.mødeOprettet);
        mødeOprettet.setText("Tillykke \n dit møde er oprettet \n dit ID er: " + mødeID);

        //Gem møde
        AppState.setMødeID(mødeID);

        //får det som string
        nymødeID = String.valueOf(mødeID);
        Log.d("hvad sker der her1 ",""+nymødeID);

        //Sæt tekst
       // mødeIdTekst.setText("Dit møde ID er følgende: \n" + mødeID);

        //
        button5 = findViewById(R.id.forsideBtn);
        button5.setOnClickListener(this);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference();

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                nyTidligereMødere = map.keySet();
                Log.d("test","test"+nyTidligereMødere);

               while (a==false) {

                   if (checkTal(nymødeID) == true) {
                       Log.d("test hvad sker der her ", "" + nymødeID);
                       mødeID = AppState.opretMødeID();
                       nymødeID = String.valueOf(mødeID);
                       Log.d("test hvad sker der her ", "Møde ID er i brug du får et nyt  ");
                       mødeOprettet.setText("Tillykke \n dit møde er oprettet \n dit ID er: " + mødeID);
                       Log.d("test hvad sker der her ", "" + nymødeID);
                       AppState.setMødeID(mødeID);
                       AppState.getMødeID();
                       Log.d("getMødeID skal stemme overens  ", "" + AppState.getMødeID());






                   } else {
                       Log.d("hvad sker der her ", "Alt spiller ");
                       a = true;

                   }
               }



            }


            // når databasen bliver ændret bliver det her kørt
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("hvad sker der her ","hvad sker der ");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });



    }

    @Override
    public void onClick(View view) {
        if (view == button5) {

            Singleton.get().getDagsordenData();

            //Sender en email til den indtastede email

            Log.i("SendMailActivity", "Send Button Clicked.");

            String fromEmail = "spnoff1@gmail.com"; // overvej at lave ny email

            String fromPassword = "spin1234"; // Husk at alle kan se koden, hvis de har kildekoden

            String toEmails = ((TextView) findViewById(R.id.emailEditText))
                    .getText().toString();
            List toEmailList = Arrays.asList(toEmails
                    .split("\\s*,\\s*"));
            Log.i("SendMailActivity", "To List: " + toEmailList);
            String emailSubject = getResources().getString(R.string.emailEmne);


                    String emailBody = getResources().getString(R.string.emailText)+" " + mødeID + "\n" + "| " +

               "Mødenavn: " + Singleton.get().getNavn() + "\n\n" +  "| " +
               "Dato og tid: " + Singleton.get().getTidspunkt() + "\n\n" + "| " +
                "Lokation: " + Singleton.get().getLokation();


            new SendMailTask(MoedeOprettet.this).execute(fromEmail,
                    fromPassword, toEmailList, emailSubject, emailBody);


            mDatabase = FirebaseDatabase.getInstance().getReference().child("ModeID/"+nymødeID);


            mDatabase.setValue(nymødeID).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Log.d("Test","Dette er gemt");
                    } else {
                        Log.d("Test","Dette er ikke gemt");
                    }

                }
            });


           bla = FirebaseDatabase.getInstance().getReference().child("Dagsorden/"+nymødeID);
            HashMap<String, String> datamap12 = new HashMap<String, String>();
            // deforskellige svar.
            datamap12.put("Navn", Singleton.get().getNavn());
            datamap12.put("Tidspunkt", Singleton.get().getTidspunkt());
            datamap12.put("Lokation", Singleton.get().getLokation());

            HashMap<String, Object> datamap22 = new HashMap<String, Object>();
            datamap22.put("mode", Singleton.get().getDagsordenData());
            //datamap22.put("overskrift",ny.getOverskrift() );
          //  datamap22.put("beskrivelse",ny.getBeskrivelse() );

            HashMap<String, Object> datamap33 = new HashMap<String, Object>();
            datamap33.put("test",datamap22);
            datamap33.put("test1",datamap12);


           bla.push().setValue(datamap33).addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {

                   if (task.isSuccessful()) {
                       Log.d("Test","Dette er gemt");
                   } else {
                       Log.d("Test","Dette er ikke gemt");
                   }

               }


           });




            Intent intent = new Intent(this, StartActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }


    public Boolean checkTal(String checkString)
    {
        for(String tal : nyTidligereMødere)
        {
            if (checkString.contains(tal))
            {
                return true;
            }
        }
        return false;
    }


}
