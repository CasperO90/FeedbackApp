package com.example.casper.feedbackapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casper.feedbackapp.R;
import com.example.casper.feedbackapp.SlutActivity;

import com.example.casper.feedbackapp.R;

import java.util.Map;

public class Tab7 extends Fragment implements View.OnClickListener {

    Button afslutBtn;
    TextView spm7, surTekst, neutralTekst, tilfredsTekst, gladtekst;;
    EditText kommentarView;
    public static int sur,neutral,tilfreds,glad;
    public static String slutsur,slutneutral,sluttilfreds,slutglad;

    Tab1 Score1 = new Tab1();
    Tab2 Score2 = new Tab2();
    Tab3 Score3 = new Tab3();
    Tab4 Score4 = new Tab4();
    Tab5 Score5 = new Tab5();
    Tab6 Score6 = new Tab6();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab7, container, false);

        //Buttons
        afslutBtn = view.findViewById(R.id.afslutBtn);
        afslutBtn.setOnClickListener(this);

        //Textview
        spm7 = view.findViewById(R.id.spmTextView);
        spm7.setText(R.string.spm7);

        surTekst = view.findViewById(R.id.surTekst);
        surTekst.setText(sur);

        neutralTekst = view.findViewById(R.id.neutralTekst);
        neutralTekst.setText(neutral);

        tilfredsTekst = view.findViewById(R.id.tilfredsTekst);
        tilfredsTekst.setText(tilfreds);

        gladtekst = view.findViewById(R.id.gladTekst);
        gladtekst.setText(glad);

        //EditText
        kommentarView = view.findViewById(R.id.kommentarView);

        sur = Score1.sur + Score2.sur1 + Score3.sur2 + Score4.sur3+ Score5.sur4 + Score6.sur5;
        neutral = Score1.neutral +Score2.neutral1 +Score3.neutral2 + Score4.neutral3+ Score5.neutral4 + Score6.neutral5;
        tilfreds =Score1.tilfreds +Score2.tilfreds1 +Score3.tilfreds2 + Score4.tilfreds3+ Score5.tilfreds4 + Score6.tilfreds5;
        glad =Score1.glad +Score2.glad1 +Score3.glad2 + Score4.glad3+ Score5.glad4 + Score6.glad5;

        return view;
    }

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
