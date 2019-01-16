package com.example.casper.feedbackapp.DagsordenLogik;

import java.util.ArrayList;

public class Singleton {

    private ArrayList<DagsordenData> listeDagsorden;
    private String navn, tidspunkt, lokation;

    public static Singleton singleton;

    public static Singleton get(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    private Singleton(){listeDagsorden = new ArrayList<>();}

    public ArrayList<DagsordenData> getDagsordenData(){return listeDagsorden;}

    public void tilføjPunkt(DagsordenData dataObjekt){listeDagsorden.add(dataObjekt);}

    public void fjernPunkt(int index){listeDagsorden.remove(index);}

    //get'er og set'er metoder
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }
}
