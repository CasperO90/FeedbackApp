package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.Main2Activity;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.SlutActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Highscore extends AppCompatActivity implements View.OnClickListener {


    LederStartMoedeActivity test = new LederStartMoedeActivity();

    TextView tv1,tv2,tv3,tv4,SeScoreFeedback;
    private int nytMødeID;
    Button KnapStats;

    SlutActivity Score = new SlutActivity();

    public  static int  ny, ny1, ny2, ny3;

    String nytid;
    public static int a =0;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private DatabaseReference kk;

    public static int spørgsmål1sur, spørgsmål1neutral1, spørgsmål1tilfreds2, spørgsmål1glad3 =0;
    public static int spørgsmål2sur, spørgsmål2neutral1, spørgsmål2tilfreds2, spørgsmål2glad3 =0;
    public static int spørgsmål3sur, spørgsmål3neutral1, spørgsmål3tilfreds2, spørgsmål3glad3 =0;
    public static int spørgsmål4sur, spørgsmål4neutral1, spørgsmål4tilfreds2, spørgsmål4glad3 =0;
    public static int spørgsmål5sur, spørgsmål5neutral1, spørgsmål5tilfreds2, spørgsmål5glad3 =0;
    public static int spørgsmål6sur, spørgsmål6neutral1, spørgsmål6tilfreds2, spørgsmål6glad3 =0;
    public static int spørgsmål7sur, spørgsmål7neutral1, spørgsmål7tilfreds2, spørgsmål7glad3 =0;
    public static int spørgsmål8sur, spørgsmål8neutral1, spørgsmål8tilfreds2, spørgsmål8glad3 =0;

    private int nysur1,nymellem1,nyglad1,nyrigtigglad1,nysur2,nymellem2,nyglad2,nyrigtigglad2=0;
    private int nysur3,nymellem3,nyglad3,nyrigtigglad3,nysur4,nymellem4,nyglad4,nyrigtigglad4=0;
    private int nysur5,nymellem5,nyglad5,nyrigtigglad5,nysur6,nymellem6,nyglad6,nyrigtigglad6=0;
    private int nysur7,nymellem7,nyglad7,nyrigtigglad7,nysur8,nymellem8,nyglad8,nyrigtigglad8=0;


    private int samledesur;
    private int samledeneutral;
    private int samledetilfreds;
    private int samledeglad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        Log.d("test","jajaja"+test.ID);

        // See charts button
        KnapStats = findViewById(R.id.SeStat);
        KnapStats.setOnClickListener(this);

        // action bar
        getSupportActionBar().setTitle("Se Feedback"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        nytid = String.valueOf(nytMødeID);

        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView6);
        tv3 = findViewById(R.id.textView10);
        tv4 = findViewById(R.id.textView11);
        SeScoreFeedback = findViewById(R.id.SeScoreFeedback);

        reset();

        //sur
        tv1.setText("");
        //mellem
        tv2.setText("");
        //glad
        tv3.setText("");
        //rigtigglad
        tv4.setText("");

        //database
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("ModeID/"+test.ID);
        kk = FirebaseDatabase.getInstance().getReference("ModeID/");

        kk.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.e(ds.getKey(), ds.getChildrenCount() + "");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        // checker hvor mange der har svaret hvad i spørgsmål 1:
                        Map<String, Object> spørgsmål1 = (Map) ds.child("spørgsmål1").getValue();


                        Log.d("jajajja",""+spørgsmål1);

                        String sur1 = String.valueOf(spørgsmål1.get("sur"));
                        String mellem1 = String.valueOf(spørgsmål1.get("mellem"));
                        String glad1 = String.valueOf(spørgsmål1.get("glad"));
                        String rigtigglad1 =String.valueOf(spørgsmål1.get("rigtigglad"));


                        Log.d("test1", "" + sur1);
                        Log.d("test2", "" + mellem1);
                        Log.d("test3", "" + glad1);
                        Log.d("test4", "" + rigtigglad1);


                        nysur1 = Integer.parseInt(sur1);
                        nymellem1 = Integer.parseInt(mellem1);
                        nyglad1 = Integer.parseInt(glad1);
                        nyrigtigglad1 = Integer.parseInt(rigtigglad1);


                        // Det her er de fulde svar for spørgsmål 1
                        spørgsmål1sur = spørgsmål1sur + nysur1;
                        spørgsmål1neutral1 = spørgsmål1neutral1 + nymellem1;
                        spørgsmål1tilfreds2 = spørgsmål1tilfreds2 + nyglad1;
                        spørgsmål1glad3 = spørgsmål1glad3 + nyrigtigglad1;

                        Log.d("sur", "" + spørgsmål1sur);
                        Log.d("mellem", "" + spørgsmål1neutral1);
                        Log.d("glad", "" + spørgsmål1tilfreds2);
                        Log.d("rigtigglad", "" + spørgsmål1glad3);




                        // checker hvor mange der har svaret hvad i spørgsmål 2:
                        Map<String, Object> spørgsmål2 = (Map) ds.child("spørgsmål2").getValue();


                        Log.d("jajajja",""+spørgsmål2);
                        //fra Object til String
                        String sur2 = String.valueOf(spørgsmål2.get("sur"));
                        String mellem2 = String.valueOf(spørgsmål2.get("mellem"));
                        String glad2 = String.valueOf(spørgsmål2.get("glad"));
                        String rigtigglad2 =String.valueOf(spørgsmål2.get("rigtigglad"));


                        Log.d("test1", "" + sur2);
                        Log.d("test2", "" + mellem2);
                        Log.d("test3", "" + glad2);
                        Log.d("test4", "" + rigtigglad2);

                        // Fra String til INT
                        nysur2 = Integer.parseInt(sur2);
                        nymellem2 = Integer.parseInt(mellem2);
                        nyglad2 = Integer.parseInt(glad2);
                        nyrigtigglad2 = Integer.parseInt(rigtigglad2);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål2sur = spørgsmål2sur + nysur2;
                        spørgsmål2neutral1 = spørgsmål2neutral1 + nymellem2;
                        spørgsmål2tilfreds2 = spørgsmål2tilfreds2 + nyglad2;
                        spørgsmål2glad3 = spørgsmål2glad3 + nyrigtigglad2;

                        Log.d("sur2", "" + spørgsmål2sur);
                        Log.d("mellem2", "" + spørgsmål2neutral1);
                        Log.d("glad2", "" + spørgsmål2tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål2glad3);


                        // checker hvor mange der har svaret hvad i spørgsmål 2:
                        Map<String, Object> spørgsmål3 = (Map) ds.child("spørgsmål3").getValue();


                        Log.d("jajajja",""+spørgsmål3);
                        //fra Object til String
                        String sur3 = String.valueOf(spørgsmål3.get("sur"));
                        String mellem3 = String.valueOf(spørgsmål3.get("mellem"));
                        String glad3 = String.valueOf(spørgsmål3.get("glad"));
                        String rigtigglad3 =String.valueOf(spørgsmål3.get("rigtigglad"));


                        Log.d("test1", "" + sur3);
                        Log.d("test2", "" + mellem3);
                        Log.d("test3", "" + glad3);
                        Log.d("test4", "" + rigtigglad3);

                        // Fra String til INT
                        nysur3 = Integer.parseInt(sur3);
                        nymellem3 = Integer.parseInt(mellem3);
                        nyglad3 = Integer.parseInt(glad3);
                        nyrigtigglad3 = Integer.parseInt(rigtigglad3);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål3sur = spørgsmål3sur + nysur3;
                        spørgsmål3neutral1 = spørgsmål3neutral1 + nymellem3;
                        spørgsmål3tilfreds2 = spørgsmål3tilfreds2 + nyglad3;
                        spørgsmål3glad3 = spørgsmål3glad3 + nyrigtigglad3;

                        Log.d("sur2", "" + spørgsmål3sur);
                        Log.d("mellem2", "" + spørgsmål3neutral1);
                        Log.d("glad2", "" + spørgsmål3tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål3glad3);



                        Map<String, Object> spørgsmål4 = (Map) ds.child("spørgsmål4").getValue();


                        Log.d("jajajja",""+spørgsmål4);
                        //fra Object til String
                        String sur4 = String.valueOf(spørgsmål4.get("sur"));
                        String mellem4 = String.valueOf(spørgsmål4.get("mellem"));
                        String glad4 = String.valueOf(spørgsmål4.get("glad"));
                        String rigtigglad4 =String.valueOf(spørgsmål4.get("rigtigglad"));


                        Log.d("test1", "" + sur4);
                        Log.d("test2", "" + mellem4);
                        Log.d("test3", "" + glad4);
                        Log.d("test4", "" + rigtigglad4);

                        // Fra String til INT
                        nysur4 = Integer.parseInt(sur4);
                        nymellem4 = Integer.parseInt(mellem4);
                        nyglad4 = Integer.parseInt(glad4);
                        nyrigtigglad4 = Integer.parseInt(rigtigglad4);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål4sur = spørgsmål4sur + nysur4;
                        spørgsmål4neutral1 = spørgsmål4neutral1 + nymellem4;
                        spørgsmål4tilfreds2 = spørgsmål4tilfreds2 + nyglad4;
                        spørgsmål4glad3 = spørgsmål4glad3 + nyrigtigglad4;

                        Log.d("sur2", "" + spørgsmål4sur);
                        Log.d("mellem2", "" + spørgsmål4neutral1);
                        Log.d("glad2", "" + spørgsmål4tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål4glad3);




                        Map<String, Object> spørgsmål5 = (Map) ds.child("spørgsmål5").getValue();


                        Log.d("jajajja",""+spørgsmål5);
                        //fra Object til String
                        String sur5 = String.valueOf(spørgsmål5.get("sur"));
                        String mellem5 = String.valueOf(spørgsmål5.get("mellem"));
                        String glad5 = String.valueOf(spørgsmål5.get("glad"));
                        String rigtigglad5 =String.valueOf(spørgsmål5.get("rigtigglad"));


                        Log.d("test1", "" + sur5);
                        Log.d("test2", "" + mellem5);
                        Log.d("test3", "" + glad5);
                        Log.d("test4", "" + rigtigglad5);

                        // Fra String til INT
                        nysur5 = Integer.parseInt(sur5);
                        nymellem5 = Integer.parseInt(mellem5);
                        nyglad5 = Integer.parseInt(glad5);
                        nyrigtigglad5 = Integer.parseInt(rigtigglad5);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål5sur = spørgsmål5sur + nysur5;
                        spørgsmål5neutral1 = spørgsmål5neutral1 + nymellem5;
                        spørgsmål5tilfreds2 = spørgsmål5tilfreds2 + nyglad5;
                        spørgsmål5glad3 = spørgsmål5glad3 + nyrigtigglad5;

                        Log.d("sur2", "" + spørgsmål5sur);
                        Log.d("mellem2", "" + spørgsmål5neutral1);
                        Log.d("glad2", "" + spørgsmål5tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål5glad3);




                        Map<String, Object> spørgsmål6 = (Map) ds.child("/spørgsmål6").getValue();


                        Log.d("jajajja",""+spørgsmål6);
                        //fra Object til String
                        String sur6 = String.valueOf(spørgsmål6.get("sur"));
                        String mellem6 = String.valueOf(spørgsmål6.get("mellem"));
                        String glad6 = String.valueOf(spørgsmål6.get("glad"));
                        String rigtigglad6 =String.valueOf(spørgsmål6.get("rigtigglad"));


                        Log.d("test1", "" + sur6);
                        Log.d("test2", "" + mellem6);
                        Log.d("test3", "" + glad6);
                        Log.d("test4", "" + rigtigglad6);

                        // Fra String til INT
                        nysur6 = Integer.parseInt(sur6);
                        nymellem6 = Integer.parseInt(mellem6);
                        nyglad6 = Integer.parseInt(glad6);
                        nyrigtigglad6 = Integer.parseInt(rigtigglad6);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål6sur = spørgsmål6sur + nysur6;
                        spørgsmål6neutral1 = spørgsmål6neutral1 + nymellem6;
                        spørgsmål6tilfreds2 = spørgsmål6tilfreds2 + nyglad6;
                        spørgsmål6glad3 = spørgsmål6glad3 + nyrigtigglad6;

                        Log.d("sur2", "" + spørgsmål6sur);
                        Log.d("mellem2", "" + spørgsmål6neutral1);
                        Log.d("glad2", "" + spørgsmål6tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål6glad3);



                        Map<String, Object> spørgsmål7 = (Map) ds.child("/spørgsmål7").getValue();


                        Log.d("jajajja",""+spørgsmål7);
                        //fra Object til String
                        String sur7 = String.valueOf(spørgsmål7.get("sur"));
                        String mellem7 = String.valueOf(spørgsmål7.get("mellem"));
                        String glad7 = String.valueOf(spørgsmål7.get("glad"));
                        String rigtigglad7 =String.valueOf(spørgsmål7.get("rigtigglad"));


                        Log.d("test1", "" + sur7);
                        Log.d("test2", "" + mellem7);
                        Log.d("test3", "" + glad7);
                        Log.d("test4", "" + rigtigglad7);

                        // Fra String til INT
                        nysur7 = Integer.parseInt(sur7);
                        nymellem7 = Integer.parseInt(mellem7);
                        nyglad7 = Integer.parseInt(glad7);
                        nyrigtigglad7 = Integer.parseInt(rigtigglad7);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål7sur = spørgsmål7sur + nysur7;
                        spørgsmål7neutral1 = spørgsmål7neutral1 + nymellem7;
                        spørgsmål7tilfreds2 = spørgsmål7tilfreds2 + nyglad7;
                        spørgsmål7glad3 = spørgsmål7glad3 + nyrigtigglad7;

                        Log.d("sur2", "" + spørgsmål7sur);
                        Log.d("mellem2", "" + spørgsmål7neutral1);
                        Log.d("glad2", "" + spørgsmål7tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål7glad3);





                        Map<String, Object> spørgsmål8 = (Map) ds.child("/spørgsmål8").getValue();


                        Log.d("jajajja",""+spørgsmål8);
                        //fra Object til String
                        String sur8 = String.valueOf(spørgsmål8.get("sur"));
                        String mellem8 = String.valueOf(spørgsmål8.get("mellem"));
                        String glad8 = String.valueOf(spørgsmål8.get("glad"));
                        String rigtigglad8 =String.valueOf(spørgsmål8.get("rigtigglad"));


                        Log.d("test1", "" + sur8);
                        Log.d("test2", "" + mellem8);
                        Log.d("test3", "" + glad8);
                        Log.d("test4", "" + rigtigglad8);

                        // Fra String til INT
                        nysur8 = Integer.parseInt(sur8);
                        nymellem8 = Integer.parseInt(mellem8);
                        nyglad8 = Integer.parseInt(glad8);
                        nyrigtigglad8 = Integer.parseInt(rigtigglad8);


                        // fra hverfor sig til Samlede resultat.
                        spørgsmål8sur = spørgsmål8sur + nysur8;
                        spørgsmål8neutral1 = spørgsmål8neutral1 + nymellem8;
                        spørgsmål8tilfreds2 = spørgsmål8tilfreds2 + nyglad8;
                        spørgsmål8glad3 = spørgsmål8glad3 + nyrigtigglad8;

                        Log.d("sur2", "" + spørgsmål8sur);
                        Log.d("mellem2", "" + spørgsmål8neutral1);
                        Log.d("glad2", "" + spørgsmål8tilfreds2);
                        Log.d("rigtigglad2", "" + spørgsmål8glad3);







                         samledesur= spørgsmål1sur+spørgsmål2sur+spørgsmål3sur+spørgsmål4sur+spørgsmål5sur+spørgsmål6sur+spørgsmål7sur+spørgsmål8sur;
                        samledeneutral=spørgsmål1neutral1+spørgsmål2neutral1+spørgsmål3neutral1+spørgsmål4neutral1+spørgsmål5neutral1+spørgsmål6neutral1+spørgsmål7neutral1+spørgsmål8neutral1;
                        samledetilfreds =spørgsmål1tilfreds2+spørgsmål2tilfreds2+spørgsmål3tilfreds2+spørgsmål4tilfreds2+spørgsmål5tilfreds2+spørgsmål6tilfreds2+spørgsmål7tilfreds2+spørgsmål8tilfreds2;
                        samledeglad =spørgsmål1glad3+spørgsmål2glad3+spørgsmål3glad3+spørgsmål4glad3+spørgsmål5glad3+spørgsmål6glad3+spørgsmål7glad3+spørgsmål8glad3;
                               /* ny = ny + Integer.parseInt(a);
                                ny1 = ny1 + Integer.parseInt(b);
                                ny2 = ny2 + Integer.parseInt(c);
                                ny3 = ny3 + Integer.parseInt(d);

                                */
                                Log.d("SUR", "" + samledesur);
                                Log.d("MELLEM", "" + ny1);
                                Log.d("GLaD", "" + ny2);
                                Log.d("Rigtigglad", "" + ny3);


                    }

                    //sur
                    tv1.setText("" + samledesur);
                    //mellem
                    tv2.setText("" + samledeneutral);
                    //glad
                    tv3.setText("" + samledetilfreds);
                    //rigtigglad
                    tv4.setText("" + samledeglad);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

     /*   if(Score.slutsur == null){
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
*/
        SeScoreFeedback.setText("Se Samlede Feedback \n fra møde ID: "+ test.ID);
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


    public void seStats(){
        Intent Stats = new Intent(this, Main2Activity.class);
        startActivity(Stats);


    }

    @Override
    public void onClick(View v) {
        if (v == KnapStats) {
            seStats();
        }
    }

    public void reset(){
        //spørgsmål 1 reset
        spørgsmål1sur =0;
        spørgsmål1neutral1 =0;
        spørgsmål1tilfreds2 =0;
        spørgsmål1glad3 =0;

        //spørgsmål 2 reset
        spørgsmål2sur = 0;
        spørgsmål2neutral1 =0;
        spørgsmål2tilfreds2 =0;
        spørgsmål2glad3 =0;

        //spørgsmål 3 reset
        spørgsmål3sur = 0;
        spørgsmål3neutral1 =0;
        spørgsmål3tilfreds2 =0;
        spørgsmål3glad3 =0;
        //spørgsmål 4 reset
        spørgsmål4sur = 0;
        spørgsmål4neutral1 =0;
        spørgsmål4tilfreds2 =0;
        spørgsmål4glad3 =0;
        //spørgsmål 5 reset
        spørgsmål5sur = 0;
        spørgsmål5neutral1 =0;
        spørgsmål5tilfreds2 =0;
        spørgsmål5glad3 =0;

        //spørgsmål 6 reset
        spørgsmål6sur = 0;
        spørgsmål6neutral1 =0;
        spørgsmål6tilfreds2 =0;
        spørgsmål6glad3 =0;

        //spørgsmål 6 reset
        spørgsmål7sur = 0;
        spørgsmål7neutral1 =0;
        spørgsmål7tilfreds2 =0;
        spørgsmål7glad3 =0;


        //spørgsmål 6 reset
        spørgsmål8sur = 0;
        spørgsmål8neutral1 =0;
        spørgsmål8tilfreds2 =0;
        spørgsmål8glad3 =0;
    }



}
