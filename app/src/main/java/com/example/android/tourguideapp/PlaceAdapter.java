package com.example.android.tourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Activity context, ArrayList<Place> place) {
        super(context, 0, place);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView oneTextView = listItemView.findViewById(R.id.title);
        oneTextView.setTextSize(34);
        oneTextView.setText(currentPlace.getName());

        TextView twoTextView = listItemView.findViewById(R.id.shortDescription);
        twoTextView.setText(currentPlace.getShortDescription());


        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentPlace.getImageResourceId());

        return listItemView;
    }
}
