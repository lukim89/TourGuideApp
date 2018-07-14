package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    public FragmentOne() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        final ArrayList<Place> place = new ArrayList<>();
        place.add(new Place("name", "shortDescription","description", R.drawable.bielsko));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent details = new Intent(getActivity(),DetailsActivity.class);
                startActivity(details);
            }
        });

        return rootView;
    }
}
