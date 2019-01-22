package com.example.casper.feedbackapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.casper.feedbackapp.Mødeleder.Highscore;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Tab2Feedback extends Fragment {


    PieChart pieChart;
    BarChart barChart;


    Highscore spørgsmål2 = new Highscore();


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab2_feedback, container, false);


        barChart = view.findViewById(R.id.chart);

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

        barChart.getAxisRight().setEnabled(false);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setSpaceTop(35f);

        leftAxis.setAxisMinimum(0f);




        ArrayList<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(1, spørgsmål2.spørgsmål2sur));
        barEntries.add(new BarEntry(2, spørgsmål2.spørgsmål2neutral1));
        barEntries.add(new BarEntry(3, spørgsmål2.spørgsmål2tilfreds2));
        barEntries.add(new BarEntry(4, spørgsmål2.spørgsmål2glad3));
        BarDataSet barDataSet = new BarDataSet (barEntries, "Dataset 1");

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        barChart.setData(data);



        pieChart = view.findViewById(R.id.chart2);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);


        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(android.R.color.white);
        pieChart.setTransparentCircleRadius(61f);


        ArrayList<PieEntry> yValues = new ArrayList<>();

        if(spørgsmål2.spørgsmål1sur >0) {

            yValues.add(new PieEntry(spørgsmål2.spørgsmål1sur, "Sur"));


        }
        if(spørgsmål2.spørgsmål1neutral1 >0) {
            yValues.add(new PieEntry(spørgsmål2.spørgsmål1neutral1, "mellem"));
        }
        if(spørgsmål2.spørgsmål1tilfreds2 >0) {
            yValues.add(new PieEntry(spørgsmål2.spørgsmål1tilfreds2, "glad"));
        }

        if(spørgsmål2.spørgsmål1glad3 >0) {
            yValues.add(new PieEntry(spørgsmål2.spørgsmål1glad3, "rigtig glad"));
        }

        PieDataSet dataSet2= new PieDataSet(yValues,"Feedback");
        dataSet2.setSliceSpace(3f);
        dataSet2.setSelectionShift(5f);
        dataSet2.setColors(ColorTemplate.COLORFUL_COLORS);



        PieData data2 = new PieData(dataSet2);
        data.setValueTextSize(20f);
        data.setValueTextColor(android.R.color.black);

        pieChart.setData(data2);



        return view;
    }
}
