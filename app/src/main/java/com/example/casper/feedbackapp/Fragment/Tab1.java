package com.example.casper.feedbackapp.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;


public class Tab1 extends Fragment implements View.OnClickListener {


    Button surBtn, neutralBtn, tilfredsBtn, gladBtn;
    int a, b, c, d = 0;
    TextView spm1, overskrift;
    private ViewPager viewPager;

    //public static betyder at værdierne kan blive videre givet, så når jeg kalder på dem i en anden klasse
    //har de samme værdier.
    public static int sur, neutral, tilfreds, glad;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab1, container, false);

        //Buttons
        surBtn = view.findViewById(R.id.surBtn);
        surBtn.setOnClickListener(this);

        neutralBtn = view.findViewById(R.id.neutralBtn);
        neutralBtn.setOnClickListener(this);

        tilfredsBtn = view.findViewById(R.id.tilfredsBtn);
        tilfredsBtn.setOnClickListener(this);

        gladBtn = view.findViewById(R.id.gladBtn);
        gladBtn.setOnClickListener(this);

        viewPager = getActivity().findViewById(R.id.tabItem1);

        //Textview
        spm1 = view.findViewById(R.id.spmTextView);
        spm1.setText(R.string.spm1);

        surBtn.setAlpha(0.2f);
        neutralBtn.setAlpha(0.2f);
        tilfredsBtn.setAlpha(0.2f);
        gladBtn.setAlpha(0.2f);

        //smily farve når man går videre.
        farveCheck();

        return view;
        }

        String tab;
        public void switchToTab(String tab){
            if(tab.equals("0")){
                viewPager.setCurrentItem(0);
            }else if(tab.equals("1")){
                viewPager.setCurrentItem(1);
            }else if(tab.equals("2")){
                viewPager.setCurrentItem(2);
            }
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
                glad = 0;
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
                tilfreds = 0;
                glad = 0;
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
        } else if (v == gladBtn) {
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