package com.example.casper.feedbackapp.Mødeleder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.casper.feedbackapp.AppState;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Map;

import com.example.casper.feedbackapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StatistikCharts extends AppCompatActivity {



    private DatabaseReference ref;
    BarChart barChart, barChart2;
    public  static int  ny, ny1, ny2, ny3;
    String nytid;
    private int nytMødeID;
    private FirebaseDatabase mFirebaseDatabase;
    PieChart pieChart;

   @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        AppState.gemMødeID(preferences);

        nytMødeID = AppState.getMødeID();

        nytid = String.valueOf(nytMødeID);

        ny =0;
        ny1 =0;
        ny2 =0;
        ny3 =0;






        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik_charts);


        ref = FirebaseDatabase.getInstance().getReference(nytid);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Map<String, String> map = (Map) ds.getValue();

                    String sur = map.get("sur");
                    String mellem = map.get("mellem");
                    String glad = map.get("glad");
                    String rigtigglad = map.get("rigtigglad");

                    ny = ny + Integer.parseInt(sur);
                    ny1 = ny1 + Integer.parseInt(mellem);
                    ny2 = ny2 + Integer.parseInt(glad);
                    ny3 = ny3 + Integer.parseInt(rigtigglad);

                 /*
                       User models = ds.getValue(User.class);
                        sur = Integer.parseInt(models.getSur());
                        mellem = Integer.parseInt(models.getMellem());
                        glad = Integer.parseInt(models.getGlad());
                        rigtigglad = Integer.parseInt(models.getRigtigglad());
                */
               }

                barChart = findViewById(R.id.chart);

                barChart.setDrawBarShadow(false);

                barChart.setDrawValueAboveBar(false);

                barChart.setMaxVisibleValueCount(10);

                barChart.setPinchZoom(false);

                barChart.setDrawGridBackground(false);

                barChart.setHighlightFullBarEnabled(true);

                XAxis xAxis = barChart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setTextSize(10f);
                xAxis.setTextColor(Color.BLACK);
                xAxis.setDrawAxisLine(true);
                xAxis.setDrawGridLines(false);
                xAxis.setLabelCount(4);





                ArrayList <BarEntry> barEntries = new ArrayList<>();

                barEntries.add(new BarEntry(1, ny));
                barEntries.add(new BarEntry(2, ny1));
                barEntries.add(new BarEntry(3, ny2));
                barEntries.add(new BarEntry(4, ny3));
                BarDataSet barDataSet = new BarDataSet (barEntries, "Dataset 1");

                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


                BarData data = new BarData(barDataSet);
                data.setBarWidth(1f);

                barChart.setData(data);



                pieChart = findViewById(R.id.chart2);

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5,10,5,5);


                pieChart.setDragDecelerationFrictionCoef(0.95f);

                pieChart.setDrawHoleEnabled(true);
                pieChart.setHoleColor(android.R.color.white);
                pieChart.setTransparentCircleRadius(61f);


                ArrayList<PieEntry> yValues = new ArrayList<>();

                yValues.add(new PieEntry(ny,"Sur"));
                yValues.add(new PieEntry(ny1,"mellem"));
                yValues.add(new PieEntry(ny2,"glad"));
                yValues.add(new PieEntry(ny3,"rigtig glad"));


                PieDataSet dataSet2= new PieDataSet(yValues,"Feedback");
                dataSet2.setSliceSpace(3f);
                dataSet2.setSelectionShift(5f);
                dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);


                PieData data2 = new PieData(dataSet2);
                data.setValueTextSize(10f);
                data.setValueTextColor(android.R.color.black);

                pieChart.setData(data2);







            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        Log.d("SUR", "" + ny);
        Log.d("MELLEM", "" + ny1);
        Log.d("GLaD", "" + ny2);
        Log.d("Rigtigglad", "" + ny3);


/*
       // barChart = findViewById(R.id.chart);





        barChart.setDrawBarShadow(false);

        barChart.setDrawValueAboveBar(false);

        barChart.setMaxVisibleValueCount(10);

        barChart.setPinchZoom(false);

        barChart.setDrawGridBackground(false);

        barChart.setHighlightFullBarEnabled(true);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(4);





        ArrayList <BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, ny));
        barEntries.add(new BarEntry(2, ny1));
        barEntries.add(new BarEntry(3, ny2));
        barEntries.add(new BarEntry(4, ny3));

        BarDataSet barDataSet = new BarDataSet (barEntries, "Dataset 1");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        BarData data = new BarData(barDataSet);
        data.setBarWidth(1f);

        barChart.setData(data);




        barChart2.setDrawBarShadow(false);

        barChart2.setDrawValueAboveBar(false);

        barChart2.setMaxVisibleValueCount(10);

        barChart2.setPinchZoom(false);

        barChart2.setDrawGridBackground(false);

        barChart2.setHighlightFullBarEnabled(true);

        XAxis xAxis2 = barChart2.getXAxis();
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis2.setTextSize(10f);
        xAxis2.setTextColor(Color.BLACK);
        xAxis2.setDrawAxisLine(true);
        xAxis2.setDrawGridLines(false);
        xAxis2.setLabelCount(4);





        ArrayList <BarEntry> barEntries2 = new ArrayList<>();

        barEntries2.add(new BarEntry(1, 1f));
        barEntries2.add(new BarEntry(2, 2f));
        barEntries2.add(new BarEntry(3, 3f));
        barEntries2.add(new BarEntry(4, 4f));

        BarDataSet barDataSet2 = new BarDataSet (barEntries2, "Dataset 2");

        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);


        BarData data2 = new BarData(barDataSet2);
        data2.setBarWidth(1f);

        barChart2.setData(data2);


*/
    }




}