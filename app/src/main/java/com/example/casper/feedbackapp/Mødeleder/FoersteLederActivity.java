package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.casper.feedbackapp.DagsordenLogik.Dagsorden;
import com.example.casper.feedbackapp.R;

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






    }

    public void opretMøde(){
        Intent intent = new Intent(this, Dagsorden.class);
        startActivity(intent);

    }

    public void startMøde(){
        Intent intent = new Intent(this, LederStartMoedeActivity.class);
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

    // denne metode bruges til at få det til at crash.
    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }


}

