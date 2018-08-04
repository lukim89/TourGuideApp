package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import java.util.ArrayList;

public class FragmentGastronomy extends Fragment {

    public FragmentGastronomy() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> place = new ArrayList<>();
        place.add(new Place(getString(R.string.amici), getString(R.string.amici_description), getString(R.string.amici_address), getString(R.string.amici_web), getString(R.string.amici_url), getString(R.string.amici_phone), getString(R.string.amici_latitude), getString(R.string.amicia_longitude), R.drawable.amici));
        place.add(new Place(getString(R.string.fabryczna), getString(R.string.fabryczna_description), getString(R.string.fabryczna_address), getString(R.string.fabryczna_web), getString(R.string.fabryczna_url), getString(R.string.fabryczna_phone), getString(R.string.fabryczna_latitude), getString(R.string.fabryczna_longitude), R.drawable.fabryczna));
        place.add(new Place(getString(R.string.nowy_swiat), getString(R.string.nowy_swiat_description), getString(R.string.nowy_swiat_address), getString(R.string.nowy_swiat_web), getString(R.string.nowy_swiat__url), getString(R.string.nowy_swiat_phone), getString(R.string.nowy_swiat_latitude), getString(R.string.nowy_swiat_longitude), R.drawable.nowy_swiat));
        place.add(new Place(getString(R.string.browar_miejski), getString(R.string.browar_miejski_description), getString(R.string.browar_miejski_address), getString(R.string.browar_miejski_web), getString(R.string.browar_miejski_url), getString(R.string.browar_miejski_phone), getString(R.string.browar_miejski_latitude), getString(R.string.browar_miejski_longitude), R.drawable.browar_miejski));
        place.add(new Place(getString(R.string.strefa), getString(R.string.strefa_description), getString(R.string.strefa_address), getString(R.string.strefa_web), getString(R.string.strefa_url), getString(R.string.strefa_phone), getString(R.string.strefa_latitude), getString(R.string.strefa_longitude), R.drawable.strefa));
        place.add(new Place(getString(R.string.rogata), getString(R.string.rogata_description), getString(R.string.rogata_address), getString(R.string.rogata_web), getString(R.string.rogata_url), getString(R.string.rogata_phone), getString(R.string.rogata_latitude), getString(R.string.rogata_longitude), R.drawable.rogata));
        place.add(new Place(getString(R.string.trattoria), getString(R.string.trattoria_description), getString(R.string.trattoria_address), getString(R.string.trattoria_web), getString(R.string.trattoria_url), getString(R.string.trattoria_phone), getString(R.string.trattoria_latitude), getString(R.string.trattoria_longitude), R.drawable.trattoria));
        place.add(new Place(getString(R.string.karczma_straconka), getString(R.string.karczma_straconka_description), getString(R.string.karczma_straconka_address), getString(R.string.karczma_straconka_web), getString(R.string.karczma_straconka_url), getString(R.string.karczma_straconka_phone), getString(R.string.karczma_straconka_latitude), getString(R.string.karczma_straconka_longitude), R.drawable.karczma_straconka));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}