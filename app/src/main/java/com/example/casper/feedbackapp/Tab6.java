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

public class Tab6 extends Fragment implements View.OnClickListener {


    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;
    TextView spm6;

    public static int sur5,neutral5,tilfreds5,glad5;
    Button btn;

    public static int sur,neutral,tilfreds,glad;


    Tab1 Score1 = new Tab1();
    Tab2 Score2 = new Tab2();
    Tab3 Score3 = new Tab3();
    Tab4 Score4 = new Tab4();
    Tab5 Score5 = new Tab5();


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab6, container, false);




        btn =(Button) view.findViewById(R.id.button3);
        surBtn = (Button) view.findViewById(R.id.surBtn);
        neutralBtn = (Button) view.findViewById(R.id.neutralBtn);
        tilfredsBtn = (Button) view.findViewById(R.id.tilfredsBtn);
        gladBtn = (Button) view.findViewById(R.id.gladBtn);

        spm6 = (TextView) view.findViewById(R.id.spm6TextView);

        spm6.setText(R.string.spm6);

        surBtn.setOnClickListener(this);
        neutralBtn.setOnClickListener(this);
        tilfredsBtn.setOnClickListener(this);
        gladBtn.setOnClickListener(this);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getActivity().getBaseContext(), Highscore.class);
                    intent.putExtra("sur", String.valueOf(sur));
                    intent.putExtra("neutral", String.valueOf(neutral));
                    intent.putExtra("tilfreds", String.valueOf(tilfreds));
                    intent.putExtra("glad", String.valueOf(glad));
                    getActivity().startActivity(intent);
                    Log.d("sker det her ","gør det ");


            }
        });



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
                sur5 = 1;
                neutral5 = 0;
                tilfreds5 = 0;
                glad5 = 0;
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

                sur5 = 0;
                neutral5 = 1;
                tilfreds5 = 0;
                glad5 = 0;
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
