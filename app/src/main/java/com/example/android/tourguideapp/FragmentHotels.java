package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentHotels extends Fragment {

    public FragmentHotels() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> place = new ArrayList<>();
        place.add(new Place(getString(R.string.sahara), getString(R.string.sahara_description), getString(R.string.sahara_address), getString(R.string.sahara_web), getString(R.string.sahara_url), getString(R.string.sahara_phone), getString(R.string.sahara_latitude), getString(R.string.sahara_longitude), R.drawable.sahara));
        place.add(new Place(getString(R.string.qubus), getString(R.string.qubus_description), getString(R.string.qubus_address), getString(R.string.qubus_web), getString(R.string.qubus_url), getString(R.string.qubus_phone), getString(R.string.qubus_latitude), getString(R.string.qubus_longitude), R.drawable.qubus));
        place.add(new Place(getString(R.string.president), getString(R.string.president_description), getString(R.string.president_address), getString(R.string.president_web), getString(R.string.president_url), getString(R.string.president_phone), getString(R.string.president_latitude), getString(R.string.president_longitude), R.drawable.president));
        place.add(new Place(getString(R.string.wroblowka), getString(R.string.wroblowka_description), getString(R.string.wroblowka_address), getString(R.string.wroblowka_web), getString(R.string.wroblowka_url), getString(R.string.wroblowka_phone), getString(R.string.wroblowka_latitude), getString(R.string.wroblowka_longitude), R.drawable.wroblowka));
        place.add(new Place(getString(R.string.grepielnia), getString(R.string.grepielnia_description), getString(R.string.grepielnia_address), getString(R.string.grepielnia_web), getString(R.string.grepielnia_url), getString(R.string.grepielnia_phone), getString(R.string.grepielnia_latitude), getString(R.string.grepielnia_longitude), R.drawable.grepielnia));
        place.add(new Place(getString(R.string.vienna), getString(R.string.vienna_description), getString(R.string.vienna_address), getString(R.string.vienna_web), getString(R.string.vienna_url), getString(R.string.vienna_phone), getString(R.string.vienna_latitude), getString(R.string.vienna_longitude), R.drawable.vienna));
        place.add(new Place(getString(R.string.beskidzka), getString(R.string.beskidzka_description), getString(R.string.beskidzka_address), getString(R.string.beskidzka_web), getString(R.string.beskidzka_url), getString(R.string.beskidzka_phone), getString(R.string.beskidzka_latitude), getString(R.string.beskidzka_longitude), R.drawable.beskidzka));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}