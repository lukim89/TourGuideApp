package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentEmergency extends Fragment {

    public FragmentEmergency() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayList<EmergencyContact> emergency = new ArrayList<>();
        emergency.add(new EmergencyContact(getString(R.string.emergency), getString(R.string.emergency_phone)));
        emergency.add(new EmergencyContact(getString(R.string.police), getString(R.string.police_phone)));
        emergency.add(new EmergencyContact(getString(R.string.ambulance), getString(R.string.ambulance_phone)));
        emergency.add(new EmergencyContact(getString(R.string.municipal_police), getString(R.string.municipal_police_phone)));
        emergency.add(new EmergencyContact(getString(R.string.mountain_rescue), getString(R.string.mountain_rescue_phone)));
        emergency.add(new EmergencyContact(getString(R.string.mountain_rescue2), getString(R.string.mountain_rescue_phone2)));
        emergency.add(new EmergencyContact(getString(R.string.road_help), getString(R.string.road_help_phone)));

        EmergencyAdapter adapter = new EmergencyAdapter(getActivity(), emergency);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity().getIntent().ACTION_DIAL, Uri.parse("tel:" + emergency.get(position).getPhone()));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
