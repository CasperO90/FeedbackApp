package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.goodiebag.pinview.Pinview;

import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.StartActivity;

public class LederStartMoedeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton5;
    Pinview pinview;
    boolean godkendt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_start_moede);

        // action bar
        getSupportActionBar().setTitle("Start Møde"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        //Button
        mButton5 = (Button) findViewById(R.id.button2);
        mButton5.setOnClickListener(this);
        pinview = (Pinview) findViewById(R.id.pinview);


        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {


            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                String a = pinview.getValue().toString();


                if (a.equals("1234")) {

                    godkendt = true;


                } else {


                    godkendt = false;

                }

            }


        });
    }
    public void videre(){
        Intent intent = new Intent(this, LederSlutMoedeActivity.class);
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


    @Override
    public void onClick(View v) {
        if(mButton5 ==v && godkendt == true){
            videre();
    }
}
    }

