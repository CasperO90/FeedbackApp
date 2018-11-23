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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener {

    private Button deltagBtn;
    private EditText editText5;
    private int MødeIDIntastet;
    private int nytMødeID;
    private TextView tekst;
    private int finalID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_deltag);

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);


        //Edittext
        editText5 = findViewById(R.id.indtastMødeID);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        tekst = findViewById(R.id.textView5);
        tekst.setText(" her er dit id " + nytMødeID);
    }


    public void deltagMøde() {

        String værdi = editText5.getText().toString();
        if(værdi.matches("")){
            Toast.makeText(this, "Du har ikke indtastet et id", Toast.LENGTH_SHORT).show();
return;
        }

        finalID = Integer.parseInt(værdi);

        if (finalID == nytMødeID) {


            Intent intent = new Intent(this, deltagerDagsordenActivity.class);
            startActivity(intent);
        }


        if (finalID != nytMødeID) {
            tekst.setText("Forkert id \n Prøv igen");
        }
    }


    @Override
    public void onClick(View view) {
        if (view == deltagBtn) {
            deltagMøde();
        }
    }

}