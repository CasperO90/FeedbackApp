package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.casper.feedbackapp.R;
import com.goodiebag.pinview.Pinview;

public class LederStartMoedeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton5;
    boolean godkendt;
    Pinview pinview;

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

                    Log.d("test2", "" + pinview.getValue());


                } else if (!a.equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Forkert pin", Toast.LENGTH_SHORT).show();

                    //for (int i = 0; i < pinview.getPinLength(); i++) {
                       // pinview.onKey(pinview.getFocusedChild(), KeyEvent.KEYCODE_DEL, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
                    }


                }





        });
    }

    @Override
    public void onClick(View v) {

        //videre
        if (mButton5 == v && godkendt == true) {
            login();

        }


    }

    public void login(){
        Intent intent = new Intent(this,LogIn.class);
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


