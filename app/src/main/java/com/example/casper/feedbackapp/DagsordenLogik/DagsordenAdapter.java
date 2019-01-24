package com.example.casper.feedbackapp.DagsordenLogik;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.casper.feedbackapp.R;

import java.util.ArrayList;

public class DagsordenAdapter extends RecyclerView.Adapter<DagsordenAdapter.RecyclerItemViewHolder>{

    private ArrayList<DagsordenData> listeDagsorden;
    private int sidstePosition = 0;
    private RemoveClickListner removeClickListner;

    public DagsordenAdapter (ArrayList<DagsordenData> listeDagsorden, RemoveClickListner listner){
        this.listeDagsorden = listeDagsorden;
        removeClickListner = listner;
    }

    @NonNull
    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modepunkt, parent, false);
        RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemViewHolder holder, final int position) {
        Log.d("onBindViewHolder ", listeDagsorden.size()+"");
        holder.etOverskrift.setText(listeDagsorden.get(position).getOverskrift());
        holder.etBeskrivelse.setText(listeDagsorden.get(position).getBeskrivelse());
        sidstePosition = position;
    }

    @Override
    public int getItemCount() {
        return(null != listeDagsorden?listeDagsorden.size():0);
    }

    public void notifyData(ArrayList<DagsordenData> listeDagsorden){
        Log.d("notifyData ", listeDagsorden.size() + "");
        this.listeDagsorden = listeDagsorden;
        notifyDataSetChanged();
    }

    public class RecyclerItemViewHolder extends ViewHolder {

        private final TextView etOverskrift;
        private final TextView etBeskrivelse;
        private TextView navnMøde, tidspunkt, lokation;
        private LinearLayout mainLayout;
        private ImageView crossImage;

        public RecyclerItemViewHolder(final View parent) {
            super(parent);

            //EditText
            etOverskrift = parent.findViewById(R.id.txtOverskrift);
            etBeskrivelse = parent.findViewById(R.id.txtBeskrivelse);
            navnMøde = parent.findViewById(R.id.navnMøde);
            tidspunkt = parent.findViewById(R.id.tidspunkt);
            lokation = parent.findViewById(R.id.lokation);

            //ImageView
            crossImage = parent.findViewById(R.id.crossImage);

            //Layout
            mainLayout = parent.findViewById(R.id.mainLayout);
            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  //  Toast.makeText(itemView.getContext(), "Position " + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                }
            });

            crossImage.setOnClickListener(new AdapterView.OnClickListener(){
                @Override
                public void onClick(View view) {
                 removeClickListner.OnRemoveClick(getAdapterPosition());
                }
            });
        }
    }
}
