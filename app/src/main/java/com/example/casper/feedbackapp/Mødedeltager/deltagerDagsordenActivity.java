package com.example.casper.feedbackapp.Mødedeltager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class deltagerDagsordenActivity extends AppCompatActivity implements OnClickListener {

    private OverforselAdapter overforselAdapter;
    private ArrayList<DagsordenData> dagsordenListe;
    private RecyclerView recyclerView;

    private Button feedbackBtn;

    private TextView overskriftTekst, navnMøde, tidspunkt, lokation;
    private int nytMødeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deltager_dagsorden);

        // action bar
        getSupportActionBar().setTitle("Dagsorden"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        //Button
        feedbackBtn = findViewById(R.id.feedbackBtn);
        feedbackBtn.setOnClickListener(this);

        overskriftTekst = findViewById(R.id.overskriftTekst);
        overskriftTekst.setText("Velkommen til møde " + nytMødeID + "\nDagsorden ");

        //Hent møde id
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);
        nytMødeID = AppState.getMødeID();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        dagsordenListe = Singleton.get().getDagsordenData();
        overforselAdapter = new OverforselAdapter(dagsordenListe);
        recyclerView.setAdapter(overforselAdapter);

        navnMøde = findViewById(R.id.navnMøde);
        navnMøde.setText(Singleton.get().getNavn());

        tidspunkt = findViewById(R.id.tidspunkt);
        tidspunkt.setText(Singleton.get().getLokation());

        lokation = findViewById(R.id.lokation);
        lokation.setText(Singleton.get().getLokation());
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