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

public class Tab4 extends Fragment implements View.OnClickListener {

    Button surBtn,neutralBtn,tilfredsBtn,gladBtn;
    int a,b,c,d = 0;
    TextView spm4;

    public static int sur3,neutral3,tilfreds3,glad3;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab4, container, false);

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
        spm4 = view.findViewById(R.id.spmTextView);
        spm4.setText(R.string.spm4);

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
                sur3 = 1;
                neutral3 = 0;
                tilfreds3 = 0;
                glad3 = 0;
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

                sur3 = 0;
                neutral3 = 1;
                tilfreds3 = 0;
                glad3 = 0;
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

                sur3 = 0;
                neutral3 = 0;
                tilfreds3 = 1;
                glad3 = 0;
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

                sur3 = 0;
                neutral3 = 0;
                tilfreds3 = 0;
                glad3 = 1;
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