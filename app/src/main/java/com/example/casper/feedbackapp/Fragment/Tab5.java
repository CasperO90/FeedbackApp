package com.example.casper.feedbackapp.Fragment;

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

import com.example.casper.feedbackapp.R;

public class Tab5 extends Fragment implements View.OnClickListener {

    Button surBtn, neutralBtn, tilfredsBtn, gladBtn;
    int a, b, c, d = 0;
    TextView spm5;

    public static int sur4, neutral4, tilfreds4, glad4;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab5, container, false);

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
        spm5 = view.findViewById(R.id.spm5TextView);
        spm5.setText(R.string.spm5);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);


        farveCheck();

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
                sur4 = 1;
                neutral4 = 0;
                tilfreds4 = 0;
                glad4 = 0;
                surBtn.setAlpha(1f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(0.2f);
            }
        }

        else if (v == neutralBtn) {
            toastTekst();
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
        }

        else if (v == tilfredsBtn) {
            toastTekst();
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
            toastTekst();
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



    // opdater view og sikre sig at farven er den rigtige farve.
    // den her kan godt blive smidt ind i logik klassen.
    public void farveCheck(){
        if(a == 1) {
            surBtn.setAlpha(1f);
        } else if (b == 1) {
            neutralBtn.setAlpha(1f);
        } else if (c == 1) {
            tilfredsBtn.setAlpha(1f);
        } else if (d == 1) {
            gladBtn.setAlpha(1f);
        }
        return;
    }

}