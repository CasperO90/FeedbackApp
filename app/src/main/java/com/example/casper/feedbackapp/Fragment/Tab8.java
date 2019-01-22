package com.example.casper.feedbackapp.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
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

public class Tab8 extends Fragment implements View.OnClickListener {

    Button surBtn, neutralBtn, tilfredsBtn, gladBtn, button3;
    TextView spm8;
    public static int sur7, neutral7, tilfreds7, glad7;
    public static int sur, neutral, tilfreds, glad;
    int a, b, c, d = 0;
    private DatabaseReference mDatabase;

    Tab1 Score1 = new Tab1();
    Tab2 Score2 = new Tab2();
    Tab3 Score3 = new Tab3();
    Tab4 Score4 = new Tab4();
    Tab5 Score5 = new Tab5();
    Tab6 Score6 = new Tab6();
    Tab7 Score7 = new Tab7();

    MoedeDeltagActivity test = new MoedeDeltagActivity();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab8, container, false);

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
        spm8 = view.findViewById(R.id.spmTextView);
        spm8.setText(R.string.spm8);

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
                sur7 = 1;
                neutral7 = 0;
                tilfreds7 = 0;
                glad7 = 0;
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

                sur7 = 0;
                neutral7 = 1;
                tilfreds7 = 0;
                glad7 = 0;
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

                sur7 = 0;
                neutral7 = 0;
                tilfreds7 = 1;
                glad7 = 0;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(1f);
                gladBtn.setAlpha(0.2f);
            }
        } else if (v == gladBtn) {
            d++;

            if (d == 1) {
                a = 0;
                b = 0;
                c = 0;

                sur7 = 0;
                neutral7 = 0;
                tilfreds7 = 0;
                glad7 = 1;
                surBtn.setAlpha(0.2f);
                neutralBtn.setAlpha(0.2f);
                tilfredsBtn.setAlpha(0.2f);
                gladBtn.setAlpha(1f);
            }
        } else if (v == button3) {


            Log.d("jjajajajajajaja", "jajajajajjaa");

            sur = Score1.sur + Score2.sur1 + Score3.sur2 + Score4.sur3 + Score5.sur4 + Score6.sur5 + Score7.sur6 + sur7;
            neutral = Score1.neutral + Score2.neutral1 + Score3.neutral2 + Score4.neutral3 + Score5.neutral4 + Score6.neutral5 + Score7.neutral6 + neutral7;
            tilfreds = Score1.tilfreds + Score2.tilfreds1 + Score3.tilfreds2 + Score4.tilfreds3 + Score5.tilfreds4 + Score6.tilfreds5 + Score7.tilfreds6 + tilfreds7;
            glad = Score1.glad + Score2.glad1 + Score3.glad2 + Score4.glad3 + Score5.glad4 + Score6.glad5 + Score7.glad6 + glad7;

            Intent intent = new Intent(getActivity(), SlutActivity.class);


            intent.putExtra("sur", String.valueOf(sur));
            intent.putExtra("neutral", String.valueOf(neutral));
            intent.putExtra("tilfreds", String.valueOf(tilfreds));
            intent.putExtra("glad", String.valueOf(glad));
            startActivity(intent);

            mDatabase = FirebaseDatabase.getInstance().getReference().child("ModeID/" + test.UserMødeID);
            //opretter indholdet glad sur, mellem, rigtigglad
            HashMap<String, String> datamap1 = new HashMap<String, String>();
            HashMap<String, String> datamap2 = new HashMap<String, String>();
            HashMap<String, String> datamap3 = new HashMap<String, String>();
            HashMap<String, String> datamap4 = new HashMap<String, String>();
            HashMap<String, String> datamap5 = new HashMap<String, String>();
            HashMap<String, String> datamap6 = new HashMap<String, String>();
            HashMap<String, String> datamap7 = new HashMap<String, String>();
            HashMap<String, String> datamap8 = new HashMap<String, String>();

            // opretter den øverste gren
            HashMap<String, HashMap> ny = new HashMap<String, HashMap>();
            ny.put("spørgsmål1", datamap1);
            ny.put("spørgsmål2", datamap2);
            ny.put("spørgsmål3", datamap3);
            ny.put("spørgsmål4", datamap4);
            ny.put("spørgsmål5", datamap5);
            ny.put("spørgsmål6", datamap6);
            ny.put("spørgsmål7", datamap7);
            ny.put("spørgsmål8", datamap8);

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

            datamap6.put("sur", String.valueOf(Score6.sur5));
            datamap6.put("mellem", String.valueOf(Score6.neutral5));
            datamap6.put("glad", String.valueOf(Score6.tilfreds5));
            datamap6.put("rigtigglad", String.valueOf(Score6.glad5));

            datamap7.put("sur", String.valueOf(Score7.sur6));
            datamap7.put("mellem", String.valueOf(Score7.neutral6));
            datamap7.put("glad", String.valueOf(Score7.tilfreds6));
            datamap7.put("rigtigglad", String.valueOf(Score7.glad6));

            datamap8.put("sur", String.valueOf(sur7));
            datamap8.put("mellem", String.valueOf(neutral7));
            datamap8.put("glad", String.valueOf(tilfreds7));
            datamap8.put("rigtigglad", String.valueOf(glad7));


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

            reset();
        }
    }

    public void farveCheck() {
        if (a == 1) {
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

    public void reset() {

        sur = 0;
        neutral = 0;
        tilfreds = 0;
        glad = 0;

        Score1.sur = 0;
        Score1.neutral = 0;
        Score1.tilfreds = 0;
        Score1.glad = 0;

        Score2.sur1 = 0;
        Score2.neutral1 = 0;
        Score2.tilfreds1 = 0;
        Score2.glad1 = 0;


        Score3.sur2 = 0;
        Score3.neutral2 = 0;
        Score3.tilfreds2 = 0;
        Score3.glad2 = 0;

        Score4.sur3 = 0;
        Score4.neutral3 = 0;
        Score4.tilfreds3 = 0;
        Score4.glad3 = 0;

        Score5.sur4 = 0;
        Score5.neutral4 = 0;
        Score5.tilfreds4 = 0;
        Score5.glad4 = 0;

        Score6.sur5 = 0;
        Score6.neutral5 = 0;
        Score6.tilfreds5 = 0;
        Score6.glad5 = 0;

        Score7.sur6 = 0;
        Score7.neutral6 = 0;
        Score7.tilfreds6 = 0;
        Score7.glad6 = 0;

        sur7 = 0;
        neutral7 = 0;
        tilfreds7 = 0;
        glad = 0;
    }
}

