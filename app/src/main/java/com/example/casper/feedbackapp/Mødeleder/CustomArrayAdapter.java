package com.example.casper.feedbackapp.Mødeleder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.casper.feedbackapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArrayAdapter extends ArrayAdapter<String> {

    ArrayList<String> text;


    public CustomArrayAdapter(@NonNull Context context, ArrayList<String> mKommentar) {
        super(context, R.layout.custom_row, mKommentar);


        text = mKommentar;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater buckyesinflater = LayoutInflater.from(getContext());
        View customview = buckyesinflater.inflate(R.layout.custom_row, parent, false);


        String nytnavn = text.get(position);


        TextView tal = (TextView) customview.findViewById(R.id.textView5);

        tal.setText(nytnavn);

        return customview;

    }
}