package com.example.casper.feedbackapp.Fragment;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casper.feedbackapp.Mødedeltager.MoedeDeltagActivity;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.SlutActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Tab6 extends Fragment implements View.OnClickListener {

    Button surBtn,neutralBtn,tilfredsBtn,gladBtn, button3;
    TextView spm6;
    public static int sur5,neutral5,tilfreds5,glad5;
    public static int sur,neutral,tilfreds,glad;
    int a,b,c,d = 0;
    private DatabaseReference mDatabase;


    Tab1 Score1 = new Tab1();
    Tab2 Score2 = new Tab2();
    Tab3 Score3 = new Tab3();
    Tab4 Score4 = new Tab4();
    Tab5 Score5 = new Tab5();

    MoedeDeltagActivity test = new MoedeDeltagActivity();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab6, container, false);

        //Buttons
        surBtn = view.findViewById(R.id.surBtn);
        surBtn.setOnClickListener(this);

        neutralBtn = view.findViewById(R.id.neutralBtn);
        neutralBtn.setOnClickListener(this);

        tilfredsBtn = view.findViewById(R.id.tilfredsBtn);
        tilfredsBtn.setOnClickListener(this);

        gladBtn = view.findViewById(R.id.gladBtn);
        gladBtn.setOnClickListener(this);

        button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(this);

        //Textview
        spm6 = view.findViewById(R.id.spmTextView);
        spm6.setText(R.string.spm6);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);

        farveCheck();
        
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
        }

        else if (v == neutralBtn) {
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

        else if (v == button3) {


            Log.d("jjajajajajajaja","jajajajajjaa");

            sur = Score1.sur + Score2.sur1 + Score3.sur2 + Score4.sur3+ Score5.sur4 +sur5;
            neutral = Score1.neutral +Score2.neutral1 +Score3.neutral2 + Score4.neutral3+ Score5.neutral4 + neutral5;
            tilfreds =Score1.tilfreds +Score2.tilfreds1 +Score3.tilfreds2 + Score4.tilfreds3+ Score5.tilfreds4 + tilfreds5;
            glad =Score1.glad +Score2.glad1 +Score3.glad2 + Score4.glad3+ Score5.glad4 + glad5;

            Intent intent = new Intent(getActivity().getBaseContext(), SlutActivity.class);
            intent.putExtra("sur", String.valueOf(sur));
            intent.putExtra("neutral", String.valueOf(neutral));
            intent.putExtra("tilfreds", String.valueOf(tilfreds));
            intent.putExtra("glad", String.valueOf(glad));
            startActivity(intent);



            mDatabase = FirebaseDatabase.getInstance().getReference().child("ModeID/"+test.UserMødeID);
            //opretter indholdet glad sur, mellem, rigtigglad
            HashMap<String, String> datamap1 = new HashMap<String, String>();
            HashMap<String, String> datamap2 = new HashMap<String, String>();
            HashMap<String, String> datamap3 = new HashMap<String, String>();
            HashMap<String, String> datamap4 = new HashMap<String, String>();
            HashMap<String, String> datamap5 = new HashMap<String, String>();
            HashMap<String, String> datamap6 = new HashMap<String, String>();

            // opretter den øverste gren
            HashMap<String, HashMap> ny = new HashMap<String, HashMap>();
            ny.put("spørgsmål1",datamap1);
            ny.put("spørgsmål2",datamap2);
            ny.put("spørgsmål3",datamap3);
            ny.put("spørgsmål4",datamap4);
            ny.put("spørgsmål5",datamap5);
            ny.put("spørgsmål6",datamap6);


            // deforskellige svar.
            datamap1.put("sur", String.valueOf(Score1.sur));
            datamap1.put("mellem", String.valueOf(Score1.neutral));
            datamap1.put("glad", String.valueOf(Score1.tilfreds));
            datamap1.put("rigtigglad", String.valueOf(Score1.glad));

            datamap2.put("sur", String.valueOf(Score2.sur1));
            datamap2.put("mellem", String.valueOf(Score2.neutral1));
            datamap2.put("glad", String.valueOf(Score2.tilfreds1));
            datamap2.put("rigtigglad", String.valueOf(Score2.glad1));

            datamap3.put("sur", String.valueOf(Score3.sur2));
            datamap3.put("mellem", String.valueOf(Score3.neutral2));
            datamap3.put("glad", String.valueOf(Score3.tilfreds2));
            datamap3.put("rigtigglad", String.valueOf(Score3.glad2));

            datamap4.put("sur", String.valueOf(Score4.sur3));
            datamap4.put("mellem", String.valueOf(Score4.neutral3));
            datamap4.put("glad", String.valueOf(Score4.tilfreds3));
            datamap4.put("rigtigglad", String.valueOf(Score4.glad3));

            datamap5.put("sur", String.valueOf(Score5.sur4));
            datamap5.put("mellem", String.valueOf(Score5.neutral4));
            datamap5.put("glad", String.valueOf(Score5.tilfreds4));
            datamap5.put("rigtigglad", String.valueOf(Score5.glad4));

            datamap6.put("sur", String.valueOf(sur5));
            datamap6.put("mellem", String.valueOf(neutral5));
            datamap6.put("glad", String.valueOf(tilfreds5));
            datamap6.put("rigtigglad", String.valueOf(glad5));




            mDatabase.push().setValue(ny).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Gemt", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getContext(), "Fejl", Toast.LENGTH_SHORT).show();
                    }
                    a++;

                }
            });




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
