package com.example.casper.feedbackapp.DagsordenLogik;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.casper.feedbackapp.Mødeleder.MoedeOprettet;
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

        recyclerView = findViewById(R.id.recycler_view);

        dagsordenAdapter = new DagsordenAdapter(listeDagsorden, this);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dagsordenAdapter);


        //EditText
        etOverskrift = findViewById(R.id.etOverskrift);
        etBeskrivelse = findViewById(R.id.etBeskrivelse);
        navnMøde = findViewById(R.id.navnMøde);
        tidspunkt = findViewById(R.id.tidspunkt);
        lokation = findViewById(R.id.lokation);

        //Recyclerview
        recyclerView = findViewById(R.id.recycler_view);

        //Button tilføjer punkt til dagsorden
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

                DagsordenData dataPunkt = new DagsordenData();
                dataPunkt.setOverskrift(overskrift);
                dataPunkt.setBeskrivelse(beskrivelse);

                Singleton.get().tilføjPunkt(dataPunkt);

                dagsordenAdapter.notifyData(Singleton.get().getDagsordenData());

                //Sætter overskrift og beskrivelse til at være tom
                etOverskrift.setText("");
                etBeskrivelse.setText("");
            }
        });

        //Button opretter dagesorden, fører videre til næste side
        btnOpret = findViewById(R.id.btnOpret);
        btnOpret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sNavnMøde = navnMøde.getText().toString();
                sTidspunkt = tidspunkt.getText().toString();
                sLokation = lokation.getText().toString();

                Singleton.get().setNavn(sNavnMøde);
                Singleton.get().setTidspunkt(sTidspunkt);
                Singleton.get().setLokation(sLokation);

                Intent intent = new Intent(Dagsorden.this, MoedeOprettet.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnRemoveClick(int index) {
        Singleton.get().fjernPunkt(index);
        dagsordenAdapter.notifyData(Singleton.get().getDagsordenData());
    }
}
