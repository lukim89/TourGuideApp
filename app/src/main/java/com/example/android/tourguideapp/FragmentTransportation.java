package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentTransportation extends Fragment {

    public FragmentTransportation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Place> place = new ArrayList<>();
        place.add(new Place(getString(R.string.mzk), getString(R.string.mzk_description), getString(R.string.mzk_address), getString(R.string.mzk_web), getString(R.string.mzk_url), getString(R.string.mzk_phone), getString(R.string.mzk_latitude), getString(R.string.mzk_longitude), R.drawable.mzk));
        place.add(new Place(getString(R.string.pks), getString(R.string.pks_description), getString(R.string.pks_address), getString(R.string.pks_web), getString(R.string.pks_url), getString(R.string.pks_phone), getString(R.string.pks_latitude), getString(R.string.pks_longitude), R.drawable.pks));
        place.add(new Place(getString(R.string.pkp), getString(R.string.pkp_description), getString(R.string.pkp_address), getString(R.string.pkp_web), getString(R.string.pkp_url), getString(R.string.pkp_phone), getString(R.string.pkp_latitude), getString(R.string.pkp_longitude), R.drawable.pkp));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}