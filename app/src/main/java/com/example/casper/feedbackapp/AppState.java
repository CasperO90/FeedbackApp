package com.example.casper.feedbackapp;

import android.content.SharedPreferences;

import java.util.Random;

public class AppState {

    private static int mødeID;

    public static final String MØDEIDE = "mødeid";

    public static void setMødeID(int IDmøde){mødeID = IDmøde;}

    public static int getMødeID(){return mødeID;}

    public static String hentMødeID(SharedPreferences preferences){
        String loadMødeID = preferences.getString(MØDEIDE,"");
        return loadMødeID;
    }

    public static void gemMødeID(SharedPreferences preferences){
        String nytMødeID = hentMødeID(preferences);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MØDEIDE, 0);
        editor.apply();
    }
}
