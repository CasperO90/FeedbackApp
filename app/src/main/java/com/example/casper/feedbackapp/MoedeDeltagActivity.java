package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener {

    private Button deltagBtn;
    private EditText indtastMødeID;
    private int MødeIDIntastet;
    private int nytMødeID;
    private TextView visMødeTekst;
    private int finalID;

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

        visMødeTekst.setText("Indtast møde id " + "(" + nytMødeID + ")");
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

    @Override
    public void onClick(View view) {
        if (view == deltagBtn) {
            deltagMøde();
        }
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