package com.example.android.tourguideapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;


import java.util.ArrayList;

public class FragmentTwo extends Fragment {

    public FragmentTwo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        ArrayList<Place> place = new ArrayList<Place>();
        place.add(new Place(getString(R.string.sulkowski_castle), getString(R.string.sulkowski_castle_description), getString(R.string.sulkowski_castle_address), getString(R.string.sulkowski_castle_web), getString(R.string.sulkowski_castle_url), getString(R.string.sulkowski_castle_phone), getString(R.string.sulkowski_castle_latitude), getString(R.string.sulkowski_castle_longitude), R.drawable.bielsko));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}