package com.example.casper.feedbackapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2 extends Fragment implements View.OnClickListener {

    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;
    TextView spm2;

    public static int sur1,neutral1,tilfreds1,glad1;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab2, container, false);

        //Buttons
        surBtn = view.findViewById(R.id.surBtn);
        surBtn.setOnClickListener(this);

        neutralBtn = view.findViewById(R.id.neutralBtn);
        neutralBtn.setOnClickListener(this);

        tilfredsBtn = view.findViewById(R.id.tilfredsBtn);
        tilfredsBtn.setOnClickListener(this);

        gladBtn = view.findViewById(R.id.gladBtn);
        gladBtn.setOnClickListener(this);

        //Textview
        spm2 = view.findViewById(R.id.spm2TextView);
        spm2.setText(R.string.spm2);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);

        return view;
    }

    public void toastTekst() {
        Toast.makeText(getActivity(), "Swipe videre", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == surBtn) {
            toastTekst();
            a++;

            if (a == 1) {
                b = 0;
                c = 0;
                d = 0;
                sur1 = 1;
                neutral1 = 0;
                tilfreds1 = 0;
                glad1=0;
                surBtn.setAlpha(1f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(0.2f);
            }

        } else if (v == neutralBtn) {
            toastTekst();
            b++;


            if (b == 1) {
                a = 0;
                c = 0;
                d = 0;

                sur1 = 0;
                neutral1 = 1;
                tilfreds1 = 0;
                glad1 = 0;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(1f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(0.2f);

            }

        } else if (v == tilfredsBtn) {
            toastTekst();
            c++;

            if (c == 1) {
                a = 0;
                b = 0;
                d = 0;

                sur1 = 0;
                neutral1 = 0;
                tilfreds1 = 1;
                glad1 = 0;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(1f);
                gladBtn.setAlpha(0.2f);
            }
        }

        else if (v == gladBtn) {
            toastTekst();
            d++;

            if (d == 1) {
                a = 0;
                b = 0;
                c = 0;

                sur1 = 0;
                neutral1 = 0;
                tilfreds1 = 0;
                glad1 = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);
            }
        }
    }
}