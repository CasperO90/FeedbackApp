package com.example.casper.feedbackapp.Mødeleder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.casper.feedbackapp.R;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class LogIn extends AppCompatActivity implements View.OnClickListener {


    private Button mButton6;
    private Button mButton7;
    private Chronometer chronometer;
    private boolean running;
    private boolean afsluttet;
    private Button seKommentar;
    private TextView textView2;
    private static int u =1;
    private static boolean isanswared = false;
    private static boolean un;
    private String test;
    private  static boolean nyID;


    TextView textView;
    String starttid,sluttid;

    LocalTime myObj,myObj1;

    LederStartMoedeActivity jep = new LederStartMoedeActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_slut_moede);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        mButton6 = findViewById(R.id.Afslutmoede);
        mButton7 = findViewById(R.id.SeFeedback);
        seKommentar = findViewById(R.id.seKommentar);
        seKommentar.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton6.setOnClickListener(this);

        test = jep.ID;


        if(isanswared== true ) {

            if (u == 2) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                starttid = preferences.getString("starttid", "");
                sluttid = preferences.getString("sluttid", "");

                textView.setText("Start tid: " + starttid);
                textView2.setText("Slut tid: " + sluttid);
                mButton6.setAlpha(.4f);
                mButton6.setText("Mødet er Stoppet");
                mButton6.setClickable(false);
                mButton6.setEnabled(false);

            } else if (isanswared == false) {


            }

        }


        // action bar
        getSupportActionBar().setTitle("Møde"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar


        //chronometer = findViewById(R.id.chronometer);
        //chronometer.setFormat("Tid: %s");





    }

    @SuppressLint("WrongConstant")
    @Override

    public void onClick(View v) {

        if(mButton6 ==v){

            if (u== 1) {
                LocalTime myObj = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    myObj = LocalTime.now();
                }
                System.out.println(myObj);
                Log.d("adasdasd", "" + myObj);


                String a = String.valueOf(myObj);

                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("starttid", a);
                editor.apply();



                textView.setText("Start tid: " + a);

                mButton6.setText("Stop Mødet");
                u=2;
            }
            else if (u==2){
                LocalTime myObj1 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    myObj1 = LocalTime.now();
                }
                System.out.println(myObj1);
                Log.d("adasdasd",""+myObj1);
                String  b = String.valueOf(myObj1);

                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("sluttid", b);
                editor.apply();




                textView2.setText("Slut tid: "+b);
                mButton6.setAlpha(.4f);
                mButton6.setText("Mødet er Stoppet");
                mButton6.setClickable(false);
                mButton6.setEnabled(false);
                boolean q = true;
                isanswared = true;
                nyID = false;
            }

        }






       /* if (mButton6 == v && running==false && afsluttet==false) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
            mButton6.setText("Afslut");
            mButton7.setVisibility(View.INVISIBLE);

        }else if(mButton6 == v && running==true){
            chronometer.stop();
            running = false;
            afsluttet = true;
            mButton7.setVisibility(View.VISIBLE);

            mButton6.setText("Mødet er nu afsluttet");


        }
            */

        //else if (mButton7 == v && running==false) {

        else if (mButton7 == v) {
           SeFeedback();


        }




        else if (seKommentar == v){
            SeKommentar();






        }


    }

    public void SeFeedback(){
        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);
}
    public void SeKommentar(){
        Intent intent = new Intent(this, Kommentar.class);
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


