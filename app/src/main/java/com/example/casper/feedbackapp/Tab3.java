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

public class Tab3 extends Fragment implements View.OnClickListener {

    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;
    TextView spm3;
    public static int sur2,neutral2,tilfreds2,glad2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab3, container, false);

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
        spm3 = view.findViewById(R.id.spm3TextView);
        spm3.setText(R.string.spm3);

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
                sur2 = 1;
                neutral2 = 0;
                tilfreds2 = 0;
                glad2 = 0;
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

                sur2 = 0;
                neutral2 = 1;
                tilfreds2 = 0;
                glad2 = 0;
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

                sur2 = 0;
                neutral2 = 0;
                tilfreds2 = 1;
                glad2 = 0;
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

                sur2 = 0;
                neutral2 = 0;
                tilfreds2 = 0;
                glad2 = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);
            }
        }
    }
}