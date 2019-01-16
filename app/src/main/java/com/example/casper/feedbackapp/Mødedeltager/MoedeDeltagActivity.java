package com.example.casper.feedbackapp.Mødedeltager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;
import java.util.Set;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener {

    private Button deltagBtn;
    private EditText indtastMødeID;
    private int MødeIDIntastet;
    private int nytMødeID;
    private TextView visMødeTekst;
    private int finalID;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private String t;

    Set<String> TidligereMødere;

    public static String UserMødeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_deltag);

        //action bar
        getSupportActionBar().setTitle("Møde Deltag"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);

        //Edittext
        indtastMødeID = findViewById(R.id.indtastMødeID);

        //Textview
        visMødeTekst = findViewById(R.id.visMødeTekst);


        //Hent møde id
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();


        Log.d("test","test");
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference();

        // når vi tilføjer noget til databasen bliver det her kørt.
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                TidligereMødere = map.keySet();
                Log.d("test","test"+TidligereMødere);


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




        visMødeTekst.setText("Indtast møde id " + "(" + nytMødeID + ")");
    }


    @Override
    public void onClick(View view) {
        if (view == deltagBtn) {
            UserMødeID = indtastMødeID.getText().toString();
            if (TidligereMødere == null) {

                Toast.makeText(this, "Der er ingen Møde ID i Appen, prøv at gå tilbage og opret et nyt ", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("måskemåske", "" + TidligereMødere);

                Log.d("jajajaj", "" + indtastMødeID.getText().toString());
                t = indtastMødeID.getText().toString();
                if (t.isEmpty()) {
                    Toast.makeText(this, "Du skal indtaste ID ", Toast.LENGTH_SHORT).show();

                } else {
                    int talVærdi = Integer.parseInt(indtastMødeID.getText().toString());

                    if (checkTal(indtastMødeID.getText().toString()) == true || talVærdi == 0) {
                        Log.d("den er  true", "den er  true");
                        Intent intent = new Intent(this, deltagerDagsordenActivity.class);
                        startActivity(intent);
                    } else if (checkTal(indtastMødeID.getText().toString()) == false) {
                        Toast.makeText(this, "forkert møde ID", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Fejl på systemet ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }


    }







    public void deltagMøde() {

        String værdi = indtastMødeID.getText().toString();
        if (værdi.matches("")) {
            Toast.makeText(this, "Du har ikke indtastet et id", Toast.LENGTH_SHORT).show();
            return;
        }

        finalID = Integer.parseInt(værdi);

        if (finalID == nytMødeID) {
            Intent intent = new Intent(this, deltagerDagsordenActivity.class);
            startActivity(intent);
        }

        if (finalID != nytMødeID) {
            Toast.makeText(this, "Du har intastet et forkert id", Toast.LENGTH_SHORT).show();
        }
    }


    public Boolean checkTal(String checkString)
    {
        for(String tal : TidligereMødere)
        {
            if (checkString.contains(tal))
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}