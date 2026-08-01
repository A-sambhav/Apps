package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    // using the custom layouts --> MyCustomAdapter
    //using the custom  Objects --> Planet
    private ArrayList<Planet> planetsArrayList;
    Context context;
    //constructor
    public MyCustomAdapter(Context context, ArrayList<Planet> planetsArrayList) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    // View Holder CLass: used to cache references to the views within an item layout, so that the don't need to be looked up every time during scrolling
    private static class ViewHolder {
        TextView txt1;
        TextView textView5;
        ImageView img1;
    }
    //getView() : used to display the data at the specified position in the data set.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get planet object for the current position
        Planet planet = getItem(position);
        // inflate the layout
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent, false);
            viewHolder.txt1 = convertView.findViewById(R.id.txt1);
            viewHolder.textView5 = convertView.findViewById(R.id.textView5);
            viewHolder.img1 = convertView.findViewById(R.id.img1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // set the planet name and moon count
        viewHolder.txt1.setText(planet.getPlanetname());
        viewHolder.textView5.setText(planet.getMooncount());
        // set the planet image
        viewHolder.img1.setImageResource(planet.getPlanetImage());


        return convertView;
    }
}
