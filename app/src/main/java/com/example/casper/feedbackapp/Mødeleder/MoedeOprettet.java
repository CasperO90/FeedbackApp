package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.casper.feedbackapp.AppState;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MoedeOprettet extends AppCompatActivity implements OnClickListener {

    private TextView mødeIdTekst, emailTextView;
    private int mødeID;
    private String mødeID1;
    private Button button5;
    private String nymødeID;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;
    private DatabaseReference ref;

    Set<String> nyTidligereMødere;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_oprettet);

        emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText("Indtast Emailadresse for at modtage møde ID på mail!");

        //action bar
        getSupportActionBar().setTitle("Møde er Oprettet"); // for set actionbar title

        //Textview
        mødeIdTekst = findViewById(R.id.mødeIdTekst);

        //Opretter møde id
        mødeID = AppState.opretMødeID();

        //Gem møde
        //AppState.setMødeID(mødeID);

        //får det som string
        nymødeID = String.valueOf(mødeID);
        Log.d("hvad sker der her1 ",""+nymødeID);

        //Sæt tekst
        mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);

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

/*
                if (nyTidligereMødere == null){
                    Log.d(" jajaja","ok");
                }else
                if(checkTal(nymødeID)== true){
                    Log.d("hvad sker der her ",""+nymødeID);
                    mødeID = AppState.opretMødeID();
                    nymødeID = String.valueOf(mødeID);
                    Log.d("hvad sker der her ","Møde ID er i brug du får et nyt  ");
                    mødeIdTekst.setText("Dit møde id er følgende: " + mødeID);
                    Log.d("hvad sker der her ",""+nymødeID);
                    AppState.setMødeID(mødeID);
                }
                else {
                    Log.d("hvad sker der her ","Alt spiller ");
                }
*/



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

            String emailBody = getResources().getString(R.string.emailText)+mødeID;

            new SendMailTask(MoedeOprettet.this).execute(fromEmail,
                    fromPassword, toEmailList, emailSubject, emailBody);


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
