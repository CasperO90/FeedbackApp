package com.example.casper.feedbackapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.example.casper.feedbackapp.Fragment.MainActivity;
import com.example.casper.feedbackapp.Mødedeltager.MoedeDeltagActivity;
import com.example.casper.feedbackapp.Mødeleder.FoersteLederActivity;
import io.fabric.sdk.android.Fabric;

public class StartActivity extends AppCompatActivity implements OnClickListener{

        private Button lederBtn, facebookBtn, linkedinBtn, hjemmesideBtn, deltagBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Intent intent = new Intent(this, Main2Activity.class);
       // startActivity(intent);

        //crashlytics.
       boolean EMULATOR = Build.PRODUCT.contains("sdk") || Build.MODEL.contains("Emulator");
        if (!EMULATOR) {
            Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        }
        setContentView(R.layout.activity_start);

        getSupportActionBar().setDisplayShowTitleEnabled(false); // for set actionbar title
        getSupportActionBar().setElevation(0);

        //Buttons
        deltagBtn = findViewById(R.id.deltagBtn);
        deltagBtn.setOnClickListener(this);

        lederBtn = findViewById(R.id.lederBtn);
        lederBtn.setOnClickListener(this);


        facebookBtn = findViewById(R.id.facebookBtn);   facebookBtn.setOnClickListener(this);

        linkedinBtn = findViewById(R.id.linkedinBtn);
        linkedinBtn.setOnClickListener(this);

        hjemmesideBtn = findViewById(R.id.hjemmesideBtn);
        hjemmesideBtn.setOnClickListener(this);


    }
    public void deltagMøde(){
        Intent intent = new Intent(this, MoedeDeltagActivity.class);
        startActivity(intent);
    }

    public void lederForside(){
        Intent intent = new Intent(this, FoersteLederActivity.class);
        startActivity(intent);
    }

    public void browserFacebook(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/spinoff.nu?fref=ts)"));
        startActivity(browserIntent);
    }

    public void browserLinkedin(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/spinoff/"));
        startActivity(browserIntent);
    }

    public void browserHjemmeside(){
        Intent browserIntet = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spinoff.nu/"));
        startActivity(browserIntet);
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Button button = (Button)view;

            if (button == deltagBtn){
                deltagMøde();
            }

            else if (button == lederBtn){
                lederForside();
            }

            else if(button == facebookBtn){
                browserFacebook();
            }

            else if (button == linkedinBtn){
                browserLinkedin();
            }

            else if (button == hjemmesideBtn){
                browserHjemmeside();
            }
        }
    }
}