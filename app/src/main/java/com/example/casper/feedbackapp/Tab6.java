package com.example.casper.feedbackapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab6 extends Fragment implements View.OnClickListener {

    Button surBtn,neutralBtn,tilfredsBtn,gladBtn, btn;
    TextView spm6;
    public static int sur5,neutral5,tilfreds5,glad5;
    public static int sur,neutral,tilfreds,glad;
    int a,b,c,d = 0;

    Tab1 Score1 = new Tab1();
    Tab2 Score2 = new Tab2();
    Tab3 Score3 = new Tab3();
    Tab4 Score4 = new Tab4();
    Tab5 Score5 = new Tab5();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab6, container, false);

        //Buttons
        btn = view.findViewById(R.id.afslutBtn);

        surBtn = view.findViewById(R.id.surBtn);
        surBtn.setOnClickListener(this);

        neutralBtn = view.findViewById(R.id.neutralBtn);
        neutralBtn.setOnClickListener(this);

        tilfredsBtn = view.findViewById(R.id.tilfredsBtn);
        tilfredsBtn.setOnClickListener(this);

        gladBtn = view.findViewById(R.id.gladBtn);
        gladBtn.setOnClickListener(this);

        //Textview
        spm6 = view.findViewById(R.id.spm6TextView);
        spm6.setText(R.string.spm6);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity().getBaseContext(), SlutActivity.class);
                startActivity(i);

                /*
                    Intent intent = new Intent(getActivity().getBaseContext(), Highscore.class);
                    intent.putExtra("sur", String.valueOf(sur));
                    intent.putExtra("neutral", String.valueOf(neutral));
                    intent.putExtra("tilfreds", String.valueOf(tilfreds));
                    intent.putExtra("glad", String.valueOf(glad));
                    getActivity().startActivity(intent);
                    */
            }
        });

        return view;
    }

    public void toastTekst() {
        Toast.makeText(getActivity(), "Dette var sidste spørgsmål", Toast.LENGTH_SHORT).show();
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
                sur5 = 1;
                neutral5 = 0;
                tilfreds5 = 0;
                glad5 = 0;
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

                sur5 = 0;
                neutral5 = 1;
                tilfreds5 = 0;
                glad5 = 0;
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

                sur5 = 0;
                neutral5 = 0;
                tilfreds5 = 1;
                glad5 = 0;
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

                sur5 = 0;
                neutral5 = 0;
                tilfreds5 = 0;
                glad5 = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);
            }
        }

        sur = Score1.sur + Score2.sur1 + Score3.sur2 + Score4.sur3+ Score5.sur4 +sur5;
        neutral = Score1.neutral +Score2.neutral1 +Score3.neutral2 + Score4.neutral3+ Score5.neutral4 + neutral5;
        tilfreds =Score1.tilfreds +Score2.tilfreds1 +Score3.tilfreds2 + Score4.tilfreds3+ Score5.tilfreds4 + tilfreds5;
        glad =Score1.glad +Score2.glad1 +Score3.glad2 + Score4.glad3+ Score5.glad4 + glad5;
    }
}
