package com.example.casper.feedbackapp.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
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
        spm5 = view.findViewById(R.id.spmTextView);
        spm5.setText(R.string.spm5);

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
        AppState.showToast(getContext(),"Swipe videre");
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