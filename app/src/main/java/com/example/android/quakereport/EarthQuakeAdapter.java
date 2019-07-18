package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Dell pc on 10-01-2019.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake>{
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes){
        super(context,0,earthQuakes);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude){
        int color;
        if(magnitude<=2.0){
            color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
        else if(magnitude<=3.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude2);
        }
        else if(magnitude<=4.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude3);
        }
        else if(magnitude<=5.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude4);
        }
        else if(magnitude<=6.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude5);
        }
        else if(magnitude<=7.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude6);
        }
        else if(magnitude<=8.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude7);
        }
        else if(magnitude<=9.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude8);
        }
        else if(magnitude<=10.0){
            color =ContextCompat.getColor(getContext(),R.color.magnitude9);
        }
        else{
            color= ContextCompat.getColor(getContext(),R.color.magnitude10plus);
        }
        return  color;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }
        EarthQuake currentEarthQuake = getItem(position);
        TextView magnitudeView = (TextView)listItemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentEarthQuake.getMagnitude());
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
                GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String loc = currentEarthQuake.getLocation();
        String[] arrofStr = loc.split("of",10);
        String direction;
        String location;
        if(arrofStr.length==1) {
             direction = "Near the";
             location = arrofStr[0];
        }
        else{
            direction =  arrofStr[0]+"of";
            location =  arrofStr[1];
        }
        TextView locationView = (TextView)listItemView.findViewById(R.id.location);
        locationView.setText(location);
        TextView directionView = (TextView)listItemView.findViewById(R.id.direction);
        directionView.setText(direction);
        Date dateObject = new Date(currentEarthQuake.getMilliseconds());
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);
        return listItemView;
    }
}

