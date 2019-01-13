package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.SlutActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Highscore extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,SeScoreFeedback;
    private int nytMødeID;

    SlutActivity Score = new SlutActivity();

    public  static int  ny, ny1, ny2, ny3;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    String nytid;
    public static int a =0;



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

        nytid = String.valueOf(nytMødeID);

        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView6);
        tv3 = findViewById(R.id.textView10);
        tv4 = findViewById(R.id.textView11);
        SeScoreFeedback = findViewById(R.id.SeScoreFeedback);


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
        ref = FirebaseDatabase.getInstance().getReference(nytid);


            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        Map<String, String> map = (Map) ds.getValue();

                        String sur = map.get("sur");
                        String mellem = map.get("mellem");
                        String glad = map.get("glad");
                        String rigtigglad = map.get("rigtigglad");


                            ny = ny + Integer.parseInt(sur);
                            ny1 = ny1 + Integer.parseInt(mellem);
                            ny2 = ny2 + Integer.parseInt(glad);
                            ny3 = ny3 + Integer.parseInt(rigtigglad);
                            Log.d("SUR", "" + ny);
                            Log.d("MELLEM", "" + ny1);
                            Log.d("GLaD", "" + ny2);
                            Log.d("Rigtigglad", "" + ny3);
                        
                  /*
                       User models = ds.getValue(User.class);
                        sur = Integer.parseInt(models.getSur());
                        mellem = Integer.parseInt(models.getMellem());
                        glad = Integer.parseInt(models.getGlad());
                        rigtigglad = Integer.parseInt(models.getRigtigglad());
*/


                    }

                    //sur
                    tv1.setText("" + ny);
                    //mellem
                    tv2.setText("" + ny1);
                    //glad
                    tv3.setText("" + ny2);
                    //rigtigglad
                    tv4.setText("" + ny3);



                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });








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


        SeScoreFeedback.setText("Se Feedback \n fra møde ID: "+ nytMødeID);
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
