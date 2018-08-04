package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentTouristInformation extends Fragment {

    public FragmentTouristInformation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> place = new ArrayList<>();
        place.add(new Place(getString(R.string.mcit), getString(R.string.mcit_description), getString(R.string.mcit_address), getString(R.string.mcit_web), getString(R.string.mcit_url), getString(R.string.mcit_phone), getString(R.string.mcit_latitude), getString(R.string.mcit_longitude), R.drawable.mcit));
        place.add(new Place(getString(R.string.silesia), getString(R.string.silesia_description), getString(R.string.silesia_address), getString(R.string.silesia_web), getString(R.string.silesia_url), getString(R.string.silesia_phone), getString(R.string.silesia_latitude), getString(R.string.sitbb_longitude), R.drawable.slaskie));
        place.add(new Place(getString(R.string.sitbb), getString(R.string.sitbb_description), getString(R.string.sitbb_address), getString(R.string.sitbb_web), getString(R.string.sitbb_url), getString(R.string.sitbb_phone), getString(R.string.sitbb_longitude), getString(R.string.sitbb_latitude), R.drawable.sitbb));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}