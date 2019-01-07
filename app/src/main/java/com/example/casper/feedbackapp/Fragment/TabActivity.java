package com.example.casper.feedbackapp.Fragment;

import android.view.View;
import android.widget.Button;


public class TabActivity {

    Button surBtn, neutralBtn, tilfredsBtn, gladBtn;
    int a, b, c, d = 0;
    public static int sur, neutral, tilfreds, glad;

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
    }
}
