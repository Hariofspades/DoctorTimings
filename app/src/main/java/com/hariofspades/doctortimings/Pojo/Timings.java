package com.hariofspades.doctortimings.Pojo;

import java.util.ArrayList;

/**
 * Created by Hari on 15/02/16.
 */
public class Timings {
    private String week;
    private String mornFrom,mornTo;
    private String eveFrom,eveTo;
    private ArrayList<Timings> customPojo =new ArrayList<>();

    public Timings(){

    }

    //getting content value
    public String getWeek(){return week;}
    //setting content value
    public void setWeek(String week){this.week=week;}

    public String getMornTo(){return mornTo;}
    public void setMornTo(String time){this.mornTo=mornTo;}

    public String getMornFrom() {
        return mornFrom;
    }

    public void setMornFrom(String mornFrom) {
        this.mornFrom = mornFrom;
    }
    public String getEveFrom() {
        return eveFrom;
    }

    public void setEveFrom(String eveFrom) {
        this.eveFrom = eveFrom;
    }
    public String getEveTo() {
        return eveTo;
    }

    public void setEveTo(String eveTo) {
        this.eveTo = eveTo;
    }
}
