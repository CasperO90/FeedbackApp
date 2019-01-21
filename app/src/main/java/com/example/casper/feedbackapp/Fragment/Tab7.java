package com.example.casper.feedbackapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.casper.feedbackapp.AppState;
import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.SlutActivity;

public class Tab7 extends Fragment implements View.OnClickListener {



    Button surBtn, neutralBtn, tilfredsBtn, gladBtn;
    int a, b, c, d = 0;
    TextView spm7;
    public static int sur6, neutral6, tilfreds6, glad6;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab7, container, false);

        //Textview
        spm7 = view.findViewById(R.id.spmTextView);
        spm7.setText(R.string.spm7);

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
        spm7 = view.findViewById(R.id.spmTextView);
        spm7.setText(R.string.spm7);

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
                sur6 = 1;
                neutral6 = 0;
                tilfreds6 = 0;
                glad6 = 0;
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

                sur6 = 0;
                neutral6 = 1;
                tilfreds6 = 0;
                glad6 = 0;
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

                sur6 = 0;
                neutral6 = 0;
                tilfreds6 = 1;
                glad6 = 0;
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

                sur6 = 0;
                neutral6 = 0;
                tilfreds6 = 0;
                glad6 = 1;
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
    public void farveCheck () {
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

    }


  /*

    // det her skal være på den sidste side
    @Override
  public void onClick (View view){

        Intent intent = new Intent(getActivity().getBaseContext(), SlutActivity.class);

        slutsur = intent.getStringExtra("sur");
        slutneutral = intent.getStringExtra("neutral");
        sluttilfreds = intent.getStringExtra("tilfreds");
        slutglad = intent.getStringExtra("glad");

        intent.putExtra("sur", String.valueOf(sur));
        intent.putExtra("neutral", String.valueOf(neutral));
        intent.putExtra("tilfreds", String.valueOf(tilfreds));
        intent.putExtra("glad", String.valueOf(glad));
        intent.putExtra("kommentar", String.valueOf(kommentarView));
        startActivity(intent);

    }
}
*/
