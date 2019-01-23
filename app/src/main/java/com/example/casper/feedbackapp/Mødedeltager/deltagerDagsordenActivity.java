package com.example.casper.feedbackapp.Mødedeltager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.DagsordenLogik.DagsordenData;
import com.example.casper.feedbackapp.DagsordenLogik.OverforselAdapter;
import com.example.casper.feedbackapp.DagsordenLogik.Singleton;
import com.example.casper.feedbackapp.Fragment.MainActivity;
import com.example.casper.feedbackapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class deltagerDagsordenActivity extends AppCompatActivity implements OnClickListener {

    private OverforselAdapter overforselAdapter;
    private ArrayList<DagsordenData> dagsordenListe;
    private RecyclerView recyclerView;

    private Button feedbackBtn;

    private TextView overskriftTekst, navnMøde, tidspunkt, lokation;
    private int nytMødeID;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;

    String navn1,tidspunkt1,lokation1;

    MoedeDeltagActivity test = new MoedeDeltagActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deltager_dagsorden);

        // action bar
        getSupportActionBar().setTitle("Tilbage"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        //Button
        feedbackBtn = findViewById(R.id.feedbackBtn);
        feedbackBtn.setOnClickListener(this);

        //Hent møde id
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);
        nytMødeID = AppState.getMødeID();

        overskriftTekst = findViewById(R.id.overskriftTekst);
        overskriftTekst.setText("Velkommen til møde " + test.UserMødeID + "\nDagsorden ");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        dagsordenListe = Singleton.get().getDagsordenData();
        overforselAdapter = new OverforselAdapter(dagsordenListe);
        recyclerView.setAdapter(overforselAdapter);

        navnMøde = findViewById(R.id.navnMøde);
        navnMøde.setText("");

        tidspunkt = findViewById(R.id.tidspunkt);
        tidspunkt.setText("");

        lokation = findViewById(R.id.lokation);
        lokation.setText("");


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("Dagsorden/" + test.UserMødeID);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    // checker hvor mange der har svaret hvad i spørgsmål 1:
                    Map<String, Object> kkk = (Map) ds.child("test1").getValue();

                    navn1 = String.valueOf(kkk.get("Navn"));
                    tidspunkt1 = String.valueOf(kkk.get("Tidspunkt"));
                    lokation1 = String.valueOf(kkk.get("Lokation"));


                    Log.d("test1", "" + navn1);
                    Log.d("test2", "" + tidspunkt1);
                    Log.d("test3", "" + lokation1);


                    navnMøde.setText("" + navn1);
                    tidspunkt.setText("" + tidspunkt1);
                    lokation.setText("" + lokation1);


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });



        }





            @Override
    public void onClick(View view) {
        if (view == feedbackBtn) {
            startFeedback();
        }
    }

    public void startFeedback() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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