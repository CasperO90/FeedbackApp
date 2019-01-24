package com.example.casper.feedbackapp.Mødeleder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.casper.feedbackapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class Kommentar extends AppCompatActivity {


    private DatabaseReference ref;

    private ArrayList<String> mKommentar = new ArrayList<>();
    private ListView mlistview;
    private FirebaseDatabase mFirebaseDatabase;

    private TextView textView7;
    LederStartMoedeActivity test = new LederStartMoedeActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kommentar);

        textView7 =(TextView)findViewById(R.id.textView7);
        textView7.setText("Kommentare fra Møde ID "+test.ID);


        getSupportActionBar().setTitle("Tilbage til oversigt"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mlistview = findViewById(R.id.listview);

        final ArrayAdapter arrayAdapter = new CustomArrayAdapter(this, mKommentar);
       // final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mKommentar);
        mlistview.setAdapter(arrayAdapter);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference("Kommentar/"+test.ID);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String, Object> map = (Map) dataSnapshot.getValue();

                String lol = String.valueOf(map.get("edittext"));
                mKommentar.add(lol);


                arrayAdapter.notifyDataSetChanged();

                Log.d("jajajaa",""+mKommentar);
                Log.d("nejnej",""+lol);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
