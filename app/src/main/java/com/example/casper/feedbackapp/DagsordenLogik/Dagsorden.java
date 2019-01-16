package com.example.casper.feedbackapp.DagsordenLogik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.casper.feedbackapp.R;

import java.util.ArrayList;

public class Dagsorden extends AppCompatActivity implements RemoveClickListner{

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

        //EditText
        etOverskrift = findViewById(R.id.etOverskrift);
        etBeskrivelse = findViewById(R.id.etBeskrivelse);
        navnMøde = findViewById(R.id.navnMøde);
        tidspunkt = findViewById(R.id.tidspunkt);
        lokation = findViewById(R.id.lokation);

        //Recyclerview
        recyclerView = findViewById(R.id.recycler_view);

        //Buttons
        btnTilfoj = findViewById(R.id.btnTilfoj);
        btnTilfoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overskrift = etOverskrift.getText().toString();
                beskrivelse = etBeskrivelse.getText().toString();

                if(overskrift.matches("") || beskrivelse.matches("")){
                    Toast.makeText(view.getContext(), "Du mangler at udfylde overskrift eller beskrivelse", Toast.LENGTH_SHORT).show();
                    return;
                }

                DagsordenData dagsData = new DagsordenData();
                dagsData.setOverskrift(overskrift);
                dagsData.setBeskrivelse(beskrivelse);

                //Sætter overskrift og beskrivelse til at være tom
                etOverskrift.setText("");
                etBeskrivelse.setText("");
            }
        });

        btnOpret = findViewById(R.id.btnTilfoj);
        btnOpret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        dagsordenAdapter = new DagsordenAdapter(listeDagsorden, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dagsordenAdapter);

    }

    @Override
    public void OnRemoveClick(int index) {

    }
}
