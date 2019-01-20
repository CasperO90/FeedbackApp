package com.example.casper.feedbackapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class AppState {


    private static int mødeID;
    private static final String MØDEIDE = "mødeid";


    public static void setMødeID(int IDmøde) {
        mødeID = IDmøde;
    }

    public static int getMødeID() {
        return mødeID;
    }

   public static int hentMødeID(SharedPreferences preferences) {
        int loadMødeID = preferences.getInt(MØDEIDE, Activity.MODE_PRIVATE);
        return loadMødeID;

    }

    public static void gemMødeID(SharedPreferences preferences) {
        int nytMødeID = hentMødeID(preferences);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MØDEIDE, nytMødeID);
        editor.commit();
    }


    //Metoder der opretter et tilfældigt møde id
    //Metoden skal udvides, så den også kan kontrollere eksisterende møde id'er
    public static int opretMødeID() {

        Random random = new Random();
        mødeID = random.nextInt((1000) + 1);
        return mødeID;

    }

    //Besked der vises når der skal skiftes fragement
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

    }
}