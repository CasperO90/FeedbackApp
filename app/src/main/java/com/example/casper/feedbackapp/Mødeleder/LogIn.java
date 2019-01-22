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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private String test,test1;
    private static boolean nyID ;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


    TextView textView;
    String starttid,sluttid;

   public static List<String> IDlist = new ArrayList<String>();



    LederStartMoedeActivity jep = new LederStartMoedeActivity();

    Date d = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_slut_moede);

        test = jep.ID;
        test1 = jep.ID;

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        mButton6 = findViewById(R.id.Afslutmoede);
        mButton7 = findViewById(R.id.SeFeedback);
        seKommentar = findViewById(R.id.seKommentar);
        seKommentar.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton6.setOnClickListener(this);


        textView.setText("");
        textView2.setText("");

//109 01 +03
        //0 41+43
        //468 +53 +55

        if(IDlist.contains(jep.ID)) {
            Log.d("JAJAJA",""+IDlist);


                    SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                    starttid = preferences.getString(test, "");
                    sluttid = preferences.getString(test1+"a", "");
                    textView.setText("Start tid: " + starttid);
                    textView2.setText("Slut tid: " + sluttid);
                    mButton6.setAlpha(.4f);
                    mButton6.setText("Mødet er Stoppet");
                    mButton6.setClickable(false);
                    mButton6.setEnabled(false);
                }

                u = 1;

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
               String a = sdf.format(Calendar.getInstance().getTime());

                textView.setText("Start tid: "+ a);
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(test, a);
                editor.apply();

                mButton6.setText("Stop Mødet");
                u=2;
            }
            else if (u==2){

                String b = sdf.format(Calendar.getInstance().getTime());
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(test1+"a", b);
                editor.apply();




                textView2.setText("Slut tid: "+ b);
                mButton6.setAlpha(.4f);
                mButton6.setText("Mødet er Stoppet");
                mButton6.setClickable(false);
                mButton6.setEnabled(false);
                nyID= true;

                test = jep.ID;
                IDlist.add(test);
                Log.d("IDlist",""+IDlist);


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


