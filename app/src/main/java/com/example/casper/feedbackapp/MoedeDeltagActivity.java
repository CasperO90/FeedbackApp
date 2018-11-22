package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener{

    private Button deltagBtn;
    private EditText indtastMødeID;
    private int MødeIDIntastet;
    private int nytMødeID;
    private TextView tekst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_deltag);

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);


        //Edittxt
        indtastMødeID = findViewById(R.id.indtastMødeID);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();


       tekst = findViewById(R.id.textView5);
       tekst.setText(" her er dit id " + nytMødeID);
    }

    public void deltagMøde(){
            Intent intent = new Intent(this, deltagerDagsordenActivity.class);
            startActivity(intent);
    }

    @Override
    public void onClick(View view) {
            if(view == deltagBtn){
                deltagMøde();
            }
        }

}