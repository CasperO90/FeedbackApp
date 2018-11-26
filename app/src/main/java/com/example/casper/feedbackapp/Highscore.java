package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4,SeScoreFeedback;
    private int nytMødeID;

    SlutActivity Score = new SlutActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        // action bar
        getSupportActionBar().setTitle("Se Feedback"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar




        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView6);
        tv3 = (TextView) findViewById(R.id.textView10);
        tv4 = (TextView) findViewById(R.id.textView11);
        SeScoreFeedback = (TextView)findViewById(R.id.SeScoreFeedback);


        if(Score.slutsur == null){
            Score.slutsur ="";
        }

        if(Score.slutneutral == null){
            Score.slutneutral ="";
        }
        if(Score.sluttilfreds == null){
            Score.sluttilfreds ="";
        }
        if(Score.slutglad == null){
            Score.slutglad ="";
        }

        tv1.setText("Sur: "+ Score.slutsur);
        tv2.setText("Neutral: "+Score.slutneutral);
        tv3.setText("Tilfreds: "+Score.sluttilfreds);
        tv4.setText("Glad: " + Score.slutglad);

        SeScoreFeedback.setText("Se Feedback fra Møde ID: "+ nytMødeID);

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
