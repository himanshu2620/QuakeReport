package com.example.android.quakereport;

/**
 * Created by Dell pc on 10-01-2019.
 */

public class EarthQuake {
    private double  magnitude;
    private String location;
    private long milliseconds;
    private String url;
    public EarthQuake(double  mMagnitude,String mLocation,long mmilliseconds,String murl){
        magnitude = mMagnitude;
        location = mLocation;
        milliseconds = mmilliseconds;
        url = murl;
    }
    public double getMagnitude(){
        return magnitude;
    }
    public String getLocation(){
        return location;
    }
    public long getMilliseconds(){
        return milliseconds;
    }
    public String getUrl(){
        return url;
    }
}
