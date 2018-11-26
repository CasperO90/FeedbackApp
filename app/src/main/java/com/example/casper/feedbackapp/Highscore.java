package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4,seSvar;
    private int nytMødeID;

    SlutActivity score = new SlutActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        // action bar
        getSupportActionBar().setTitle("Svar fra Feedback"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar



        seSvar = (TextView)findViewById(R.id.seSvar);
        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView6);
        tv3 = (TextView) findViewById(R.id.textView10);
        tv4 = (TextView) findViewById(R.id.textView11);




        tv1.setText("Sur: " + score.slutsur);
        tv2.setText("Neutral: " +score.slutneutral);
        tv3.setText("Tilfreds: "+ score.sluttilfreds);
        tv4.setText("Glad: "+ score.slutglad);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        seSvar.setText("Svar fra Møde ID: " + nytMødeID);






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
