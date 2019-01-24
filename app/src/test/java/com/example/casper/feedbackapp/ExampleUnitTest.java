package com.example.casper.feedbackapp;

import com.example.casper.feedbackapp.DagsordenLogik.Dagsorden;
import com.example.casper.feedbackapp.DagsordenLogik.Singleton;
import com.example.casper.feedbackapp.Fragment.Tab1;
import com.example.casper.feedbackapp.Fragment.Tab8;
import com.example.casper.feedbackapp.Mødeleder.LogIn;
import com.example.casper.feedbackapp.Mødeleder.MoedeOprettet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void SetOgGetNavn(){
        Singleton.get().setNavn("jens");
        String expectedName = "jens";
        assertEquals(expectedName, Singleton.get().getNavn());
    }
    @Test
    public void SetOgGetTid(){
        Singleton.get().setLokation("Lyngby");
        String expectedName = "Lyngby";
        assertEquals(expectedName, Singleton.get().getLokation());
    }
    @Test
    public void SetOgGetLokaltion(){
        Singleton.get().setTidspunkt("10-09-2018");
        String expectedName = "10-09-2018";
        assertEquals(expectedName, Singleton.get().getTidspunkt());
    }

    @Test
    public void SetOgGetMødeID(){
        AppState.setMødeID(22);
        int expectedName = 22;
        assertEquals(expectedName, AppState.getMødeID());
    }




}