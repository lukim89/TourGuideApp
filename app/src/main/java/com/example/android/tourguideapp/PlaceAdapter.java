package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context context = getContext();

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

        String name = currentPlace.getName();
        String description = currentPlace.getDescription();
        String address = currentPlace.getAddress();
        String web = currentPlace.getWeb();
        String url = currentPlace.getURL();
        String phone = currentPlace.getPhone();
        double longitude = currentPlace.getLongitude();
        double latitude = currentPlace.getLatitude();
        int imageID = currentPlace.getImageResourceId();

        TextView oneTextView = listItemView.findViewById(R.id.title);
        oneTextView.setTextSize(20);
        oneTextView.setText(name);

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(imageID);

        final Intent detailsIntent = new Intent(context, DetailsActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString("NAME", name);
        bundle.putString("DESCRIPTION", description);
        bundle.putString("ADDRESS", address);
        bundle.putString("WEB", web);
        bundle.putString("URL", url);
        bundle.putString("PHONE", phone);
        bundle.putDouble("LATITUDE", latitude);
        bundle.putDouble("LONGITUDE", longitude);
        bundle.putInt("IMAGE_ID", imageID);

        detailsIntent.putExtras(bundle);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(detailsIntent);
            }
        });

        return listItemView;
    }
}
