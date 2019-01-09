package com.example.casper.feedbackapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.Random;

public class AppState {

    private static int mødeID;
    private static final String MØDEIDE = "mødeid";

    public static void setMødeID(int IDmøde){mødeID = IDmøde;}
    public static int getMødeID(){return mødeID;}

    public static int hentMødeID(SharedPreferences preferences){
        int loadMødeID = preferences.getInt(MØDEIDE, Activity.MODE_PRIVATE);
        return loadMødeID;
    }

    public static void gemMødeID(SharedPreferences preferences){
        int nytMødeID = hentMødeID(preferences);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MØDEIDE, nytMødeID);
        editor.commit();
    }

    public static int opretMødeID(){
        Random random = new Random();
        mødeID = random.nextInt((1000) + 1);
        return mødeID;
    }
}
