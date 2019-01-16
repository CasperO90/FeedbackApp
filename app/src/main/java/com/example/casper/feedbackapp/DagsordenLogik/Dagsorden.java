package com.example.casper.feedbackapp.DagsordenLogik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.casper.feedbackapp.R;

import java.util.ArrayList;

public class Dagsorden extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DagsordenAdapter dagsordenAdapter;

    private Button btnTilfoj, btnOpret;
    private ArrayList<DagsordenData> listeDagsorden = new ArrayList<>();
    private EditText etOverskrift, etBeskrivelse, navnMøde, tidspunkt, lokation;
    private String overskrift = "", beskrivelse = "", sNavnMøde, sTidspunkt, sLokation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagsorden);

        recyclerView = findViewById(R.id.recycler_view);





    }
}
