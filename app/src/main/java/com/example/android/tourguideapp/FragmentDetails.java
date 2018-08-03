package com.example.android.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentDetails extends Fragment {

    public FragmentDetails() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(bundle.getString("NAME"));

        TextView title = rootView.findViewById(R.id.details_title);
        title.setTextSize(20);
        title.setText(bundle.getString("NAME"));

        ImageView image = rootView.findViewById(R.id.details_image);
        image.setImageResource(bundle.getInt("IMAGE_ID"));

        TextView description = rootView.findViewById(R.id.details_text);
        description.setText(bundle.getString("DESCRIPTION"));

        return rootView;
    }
}
