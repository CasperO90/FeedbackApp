package com.example.casper.feedbackapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

public class AppState {

    private static int mødeID1;
    private static final String MØDEIDE1 = "mødeid1";

    public static void setMødeID(int IDmøde) {
        mødeID1 = IDmøde;
    }

    public static int getMødeID() {
        return mødeID1;
    }

    public static int hentMødeID(SharedPreferences preferences) {
        int loadMødeID1 = preferences.getInt(MØDEIDE1, MODE_PRIVATE);
        return loadMødeID1;
    }

    public static void gemMødeID(SharedPreferences preferences) {
        int nytMødeID1 = hentMødeID(preferences);
        SharedPreferences.Editor editor1 = preferences.edit();
        editor1.commit();
    }

    //Metoder der opretter et tilfældigt møde id
    //Metoden skal udvides, så den også kan kontrollere eksisterende møde id'er
    public static int opretMødeID() {
        Random random = new Random();
        mødeID1 = random.nextInt((1000) + 1);
        return mødeID1;
    }

    //Besked der vises når der skal skiftes fragement
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

    }


}