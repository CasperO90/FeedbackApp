package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class FoersteLederActivity extends AppCompatActivity implements OnClickListener{

    private Button opretMødeBtn, startMødeBtn,SeFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foerste_leder);


        // action bar
        getSupportActionBar().setTitle("Første leder"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar


        //Button
        opretMødeBtn = findViewById(R.id.opretMødeBtn);
        opretMødeBtn.setOnClickListener(this);

        startMødeBtn = findViewById(R.id.startMødeBtn);
        startMødeBtn.setOnClickListener(this);


        SeFeedback = findViewById(R.id.SeFeedback);
        SeFeedback.setOnClickListener(this);

    }



    public void opretMøde(){
        Intent intent = new Intent(this, LederOpretMoedeActivity.class);
        startActivity(intent);

    }

    public void startMøde(){
        Intent intent = new Intent(this, LederStartMoedeActivity.class);
        startActivity(intent);
      
    }

    public void SeFeedback(){
        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View view) {

        if(view == opretMødeBtn){
            opretMøde();
        }
        else if(view == startMødeBtn){
            startMøde();
        }


        if(view == SeFeedback){
            SeFeedback();
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

