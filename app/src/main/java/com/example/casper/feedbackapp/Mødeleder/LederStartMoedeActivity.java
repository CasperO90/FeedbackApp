package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.StartActivity;

public class LederStartMoedeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_start_moede);

        // action bar
        getSupportActionBar().setTitle("Start Møde"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        //Button
        mButton5 = (Button)findViewById(R.id.button2);
        mButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //videre
        if(mButton5 == v){
           // videre();
        }
    }

    public void videre(){
        Intent intent = new Intent(this, StartActivity.class);
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
