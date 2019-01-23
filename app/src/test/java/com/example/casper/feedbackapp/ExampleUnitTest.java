package com.example.casper.feedbackapp;

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
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrectglad() throws Exception {
        int expected = Tab8.glad7;
        int glad = 0; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, glad);
    }

    @Test
    public void addition_isCorrectsur() throws Exception {
        int expected = Tab8.sur;
        int sur = 0; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, sur);
    }

    @Test
    public void addition_isCorrecttilfreds() throws Exception {
        int expected = Tab8.tilfreds;
        int tilfreds = 0; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, tilfreds);
    }

    @Test
    public void addition_isCorrectneutral() throws Exception {
        int expected = Tab8.neutral7;
        int neutral = 0; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, neutral);
    }

    @Test
    public void addition_isCorrectLogin() throws Exception {
        int expected = LogIn.u;
        int forventede = 1; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, forventede);
    }

    @Test
    public void addition_isCorrectBoolean() throws Exception {
        boolean expected = MoedeOprettet.a;
        boolean forventede = false; // pretend this is a static method in the Util class in your android project
        assertEquals(expected, forventede);
    }

}