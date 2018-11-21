package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MoedeDeltagActivity extends AppCompatActivity implements OnClickListener{

    private Button deltagBtn;
    private EditText indtastMødeID;
    private String MødeIDIntastet;
    private String nytMødeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moede_deltag);

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);

        //EditText
        indtastMødeID.findViewById(R.id.indtastMødeID);
        MødeIDIntastet = indtastMødeID.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.hentMødeID(preferences);

        indtastMødeID.addTextChangedListener (mødeIDWatcher);
    }

    private TextWatcher mødeIDWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String mødeIDInput = MødeIDIntastet.toString().trim();

            deltagBtn.setEnabled(nytMødeID == mødeIDInput);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

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