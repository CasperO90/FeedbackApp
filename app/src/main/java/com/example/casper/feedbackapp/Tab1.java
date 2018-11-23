package com.example.casper.feedbackapp;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;







public class Tab1 extends Fragment implements View.OnClickListener {




    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;
    TextView spm1;

    //public static betyder at værdierne kan blive videre givet, så når jeg kalder på dem i en anden klasse
    //har de samme værdier.

    public static int sur,neutral,tilfreds,glad;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab1, container, false);

        //Resources res = getResources();

        surBtn = (Button) view.findViewById(R.id.surBtn);
        neutralBtn = (Button) view.findViewById(R.id.neutralBtn);
        tilfredsBtn = (Button) view.findViewById(R.id.tilfredsBtn);
        gladBtn = (Button) view.findViewById(R.id.gladBtn);

       //spm1 = (TextView) view.findViewById(R.id.sp

        spm1.setText(R.string.spm1);


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



    // her bliver stemmerne givet, når brugeren trykker på knappen sætter den alle de andre værdier
    // til 0 for man kan kun stemme engang.
    // og det er sur,neutral,tilfreds,glad der bliver brugt i de andre fragmenter og til sidste i highscore


    @Override
    public void onClick(View v) {


        if (v == surBtn) {

            a++;

            if (a == 1) {
                b = 0;
                c = 0;
                d = 0;
                sur = 1;
                neutral = 0;
                tilfreds = 0;
                glad=0;
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

                sur = 0;
                neutral = 1;
                tilfreds =0;
                glad=0;
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

                sur = 0;
                neutral = 0;
                tilfreds = 1;
                glad = 0;
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

                sur = 0;
                neutral = 0;
                tilfreds = 0;
                glad = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);

            }

        }



    }



    }


