package com.example.casper.feedbackapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab5 extends Fragment implements View.OnClickListener {


    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;

    public static int sur4,neutral4,tilfreds4,glad4;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab5, container, false);





        surBtn = (Button) view.findViewById(R.id.surBtn);
        neutralBtn = (Button) view.findViewById(R.id.neutralBtn);
        tilfredsBtn = (Button) view.findViewById(R.id.tilfredsBtn);
        gladBtn = (Button) view.findViewById(R.id.gladBtn);




        surBtn.setOnClickListener(this);
        neutralBtn.setOnClickListener(this);
        tilfredsBtn.setOnClickListener(this);
        gladBtn.setOnClickListener(this);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);






        return view;




    }

    @Override
    public void onClick(View v) {

        if (v == surBtn) {

            a++;

            if (a == 1) {
                b = 0;
                c = 0;
                d = 0;
                sur4 = 1;
                neutral4 = 0;
                tilfreds4 = 0;
                glad4 = 0;
                surBtn.setAlpha(1f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(0.2f);


            }


        } else if (v == neutralBtn) {

            b++;


            if (b == 1) {
                a = 0;
                c = 0;
                d = 0;

                sur4 = 0;
                neutral4 = 1;
                tilfreds4 = 0;
                glad4 = 0;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(1f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(0.2f);

            }


        } else if (v == tilfredsBtn) {

            c++;

            if (c == 1) {
                a = 0;
                b = 0;
                d = 0;

                sur4 = 0;
                neutral4 = 0;
                tilfreds4 = 1;
                glad4 = 0;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(1f);
                gladBtn.setAlpha(0.2f);
            }
        }


        else if (v == gladBtn) {

            d++;

            if (d == 1) {
                a = 0;
                b = 0;
                c = 0;

                sur4 = 0;
                neutral4 = 0;
                tilfreds4 = 0;
                glad4 = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);

            }

        }


    }
}
