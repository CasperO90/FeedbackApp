package com.example.casper.feedbackapp.DagsordenLogik;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.casper.feedbackapp.R;

import java.util.ArrayList;

public class OverforselAdapter extends RecyclerView.Adapter<OverforselAdapter.RecyclerItemViewHolder> {

    private ArrayList<DagsordenData> listeDagsorden;
    private int sidstePosition = 0;

    public OverforselAdapter(ArrayList<DagsordenData> listeDagsorden){this.listeDagsorden = listeDagsorden;}

    @NonNull
    @Override
    public RecyclerItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_oversigt_dagsorden, parent, false);
        RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemViewHolder holder, int position) {
        Log.d("onBindViewHoler ", listeDagsorden.size() + "");
        holder.overskrift.setText(listeDagsorden.get(position).getOverskrift());
        holder.beskrivelse.setText(listeDagsorden.get(position).getBeskrivelse());
        sidstePosition = position;
    }

    @Override
    public int getItemCount() {
        return (null != listeDagsorden?listeDagsorden.size():0);
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView overskrift;
        private final TextView beskrivelse;
        private LinearLayout layout;

        public RecyclerItemViewHolder(final View parent) {
            super(parent);

            //TextView
            overskrift = parent.findViewById(R.id.overskrift);
            beskrivelse = parent.findViewById(R.id.beskrivelse);

            //Layout
            layout = parent.findViewById(R.id.layout);
        }
    }
}
