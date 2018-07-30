package com.example.android.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailsMap extends Fragment implements OnMapReadyCallback {


    private double longitude;
    private double latitude;

    public FragmentDetailsMap() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.details_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getActivity().getIntent().getExtras();

        latitude = bundle.getDouble("LATITUDE");
        longitude = bundle.getDouble("LONGITUDE");

        return rootView;
    }


    @Override
    public void onMapReady (GoogleMap googleMap) {

        LatLng mPlace = new LatLng(latitude, longitude);

        googleMap.addMarker(new MarkerOptions().position(mPlace));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mPlace,15.0f));
    }
}
