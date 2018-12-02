package com.example.casper.feedbackapp.Mødedeltager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.MainActivity;
import com.example.casper.feedbackapp.Mødeleder.LederOpretMoedeActivity;
import com.example.casper.feedbackapp.R;

public class deltagerDagsordenActivity extends AppCompatActivity implements OnClickListener {

    private Button feedbackBtn;

    TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    private TextView overskriftTekst;
    private int nytMødeID;

    LederOpretMoedeActivity id = new LederOpretMoedeActivity();

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

        //Textview
        tv9 = findViewById(R.id.textView7);
        tv8 = findViewById(R.id.textView12);
        tv7 = findViewById(R.id.textView13);
        tv6 = findViewById(R.id.textView14);
        tv5 = findViewById(R.id.textView15);
        tv4 = findViewById(R.id.textView16);
        tv3 = findViewById(R.id.textView17);
        tv2 = findViewById(R.id.textView18);
        tv1 = findViewById(R.id.textView19);
        tv = findViewById(R.id.textView20);


        //Hent møde id
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        overskriftTekst = findViewById(R.id.overskriftTekst);
        overskriftTekst.setText("Velkommen til møde " + nytMødeID + "\nDagsorden ");

        // textviews der står tekst i hvis brugeren har oprettet dem
        if (id.text == null) {
            Log.d("test", "IF");
            tv.setText("");
        } else if (id.text.equals("")) {
            Log.d("test", "ELSE IF");
            tv.setText("");
        } else {
            Log.d("test", "ELSE ");
            tv.setText("Punkt 1: " + id.text);
        }


        if (id.text1 == null) {
            tv1.setText("");
        } else if (id.text1.equals("")) {
            tv1.setText("");
        } else {
            tv1.setText("Punkt 2: " + id.text1);
        }


        if (id.text2 == null) {
            tv2.setText("");
        } else if (id.text2.equals("")) {
            tv2.setText("");
        } else {
            tv2.setText("Punkt 3: " + id.text2);
        }

        if (id.text3 == null) {
            tv3.setText("");
        } else if (id.text3.equals("")) {
            tv3.setText("");
        } else {
            tv3.setText("Punkt 4: " + id.text3);
        }

        if (id.text4 == null) {
            tv4.setText("");
        } else if (id.text4.equals("")) {
            tv4.setText("");
        } else {
            tv4.setText("Punkt 5: " + id.text4);
        }

        if (id.text5 == null) {
            tv5.setText("");
        } else if (id.text5.equals("")) {
            tv5.setText("");
        } else {
            tv5.setText("Punkt 6: " + id.text5);
        }

        if (id.text6 == null) {
            tv6.setText("");
        } else if (id.text6.equals("")) {
            tv6.setText("");
        } else {
            tv6.setText("Punkt 7: " + id.text6);
        }

        if (id.text7 == null) {
            tv7.setText("");
        } else if (id.text7.equals("")) {
            tv7.setText("");
        } else {
            tv7.setText("Punkt 8: " + id.text7);
        }

        if (id.text8 == null) {
            tv8.setText("");
        } else if (id.text8.equals("")) {
            tv8.setText("");
        } else {
            tv8.setText("Punkt 9: " + id.text8);
        }

        if (id.text9 == null) {
            tv9.setText("");
        } else if (id.text9.equals("")) {
            tv9.setText("");
        } else {
            tv9.setText("Punkt 10: " + id.text9);
        }
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