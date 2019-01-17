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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.KeyEvent;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.goodiebag.pinview.Pinview;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;
import java.util.Set;

public class LederStartMoedeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton5;
    boolean godkendt;
    Pinview pinview;
    private EditText editText;

    private int finalID;
    private int nytMødeID;
    private TextView indtastPinkode;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference ref;
    private String t;

    Set<String> TidligereMødere;

    public static String ID;
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

        editText = (EditText)findViewById(R.id.editText);

        pinview = (Pinview) findViewById(R.id.pinview);

        indtastPinkode = (TextView)findViewById(R.id.indtastPinkode);
        indtastPinkode.setText("Pin-koden er 1234.");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();


        Log.d("test","test");
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference();

        // når vi tilføjer noget til databasen bliver det her kørt.
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                TidligereMødere = map.keySet();
                Log.d("test","test"+TidligereMødere);


            }


            // når databasen bliver ændret bliver det her kørt
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("hvad sker der her ","hvad sker der ");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });






       pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {


                String a = pinview.getValue().toString();


                if (a.equals("1234")) {
                    godkendt = true;

                    Log.d("test2", "" + pinview.getValue());


                } else if (!a.equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Forkert pin", Toast.LENGTH_SHORT).show();
                    clearpin();


                    }


                }





        });

    }


    @Override
    public void onClick(View v) {

   // deltagMøde();
        //videre
       // if (mButton5 == v && godkendt == true) {
       if (mButton5 == v) {

            ID = String.valueOf(editText.getText().toString());

           Log.d("næste","næste"+ID);

           if (TidligereMødere == null) {

               Toast.makeText(this, "Der er ingen Møde ID i Appen, prøv at gå tilbage og opret et nyt ", Toast.LENGTH_SHORT).show();
           }
           else {

               Log.d("måskemåske", "" + TidligereMødere);


               t = editText.getText().toString();
               if (t.isEmpty()) {
                   Toast.makeText(this, "Du skal indtaste ID", Toast.LENGTH_SHORT).show();

               } else {
                   Log.d("jajajaj", "" + editText.getText().toString());
                   int talVærdi = Integer.parseInt(editText.getText().toString());

                   if (checkTal(editText.getText().toString()) == true && godkendt == true || talVærdi == 0) {
                       Log.d("den er  true", "den er  true");
                       login();
                   } else if (checkTal(editText.getText().toString()) == false && godkendt == true) {
                       Toast.makeText(this, "forkert møde ID", Toast.LENGTH_SHORT).show();

                   } else if (checkTal(editText.getText().toString()) == true && godkendt == false) {
                       Toast.makeText(this, "forkert Pin-kode", Toast.LENGTH_SHORT).show();

                   } else {
                       Toast.makeText(this, "Både Møde ID og Pin-kode er forkert.", Toast.LENGTH_SHORT).show();
                   }

               }
           }

       }

    }

    public void login(){
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);

    }

    public void clearpin(){
        for (int i = 0; i < pinview.getPinLength(); i++) {
            pinview.onKey(pinview.getFocusedChild(), KeyEvent.KEYCODE_DEL, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
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



    public void deltagMøde() {

        String værdi = editText.getText().toString();
        if (værdi.matches("")) {
            Toast.makeText(this, "Du har ikke indtastet et id", Toast.LENGTH_SHORT).show();
            return;
        }

        finalID = Integer.parseInt(værdi);

        if (finalID == nytMødeID) {
            Intent intent = new Intent(this, LogIn.class);
            startActivity(intent);
        }

        if (finalID != nytMødeID) {
            Toast.makeText(this, "Du har intastet et forkert id", Toast.LENGTH_SHORT).show();
        }
    }


    public Boolean checkTal(String checkString)
    {
        for(String tal : TidligereMødere)
        {
            if (checkString.contains(tal))
            {
                return true;
            }
        }
        return false;
    }



}


