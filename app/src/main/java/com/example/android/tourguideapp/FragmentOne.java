package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        place.add(new Place(getString(R.string.sulkowski_castle), getString(R.string.sulkowski_castle_description), getString(R.string.sulkowski_castle_address), getString(R.string.sulkowski_castle_web), getString(R.string.sulkowski_castle_url), getString(R.string.sulkowski_castle_phone), getString(R.string.sulkowski_castle_latitude), getString(R.string.sulkowski_castle_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.old_factory), getString(R.string.old_factory_description), getString(R.string.old_factory_address), getString(R.string.old_factory_web), getString(R.string.old_factory_url), getString(R.string.old_factory_phone), getString(R.string.old_factory_latitude), getString(R.string.old_factory_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.weaver_house), getString(R.string.weaver_house_description), getString(R.string.weaver_house_address), getString(R.string.weaver_house_web), getString(R.string.weaver_house_url), getString(R.string.weaver_house_phone), getString(R.string.weaver_house_latitude), getString(R.string.weaver_house_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.falatowka), getString(R.string.falatowka_description), getString(R.string.falatowka_address), getString(R.string.falatowka_web), getString(R.string.falatowka_url), getString(R.string.falatowka_phone), getString(R.string.falatowka_latitude), getString(R.string.falatowka_longitude), R.drawable.bielsko));

        place.add(new Place(getString(R.string.teatr_poski), getString(R.string.teatr_poski_description), getString(R.string.teatr_poski_address), getString(R.string.teatr_poski_web), getString(R.string.teatr_poski_url), getString(R.string.teatr_poski_phone), getString(R.string.teatr_poski_latitude), getString(R.string.teatr_poski_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.sfr), getString(R.string.sfr_description), getString(R.string.sfr_address), getString(R.string.sfr_web), getString(R.string.sfr_url), getString(R.string.sfr_phone), getString(R.string.sfr_latitude), getString(R.string.sfr_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.szyndzielnia), getString(R.string.szyndzielnia_description), getString(R.string.szyndzielnia_address), getString(R.string.szyndzielnia_web), getString(R.string.szyndzielnia_url), getString(R.string.szyndzielnia_phone), getString(R.string.szyndzielnia_latitude), getString(R.string.szyndzielnia_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.zar), getString(R.string.zar_description), getString(R.string.zar_address), getString(R.string.zar_web), getString(R.string.zar_url), getString(R.string.zar_phone), getString(R.string.zar_latitude), getString(R.string.zar_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.skrzyczne), getString(R.string.skrzyczne_description), getString(R.string.skrzyczne_address), getString(R.string.skrzyczne_web), getString(R.string.skrzyczne_web), getString(R.string.skrzyczne_phone), getString(R.string.skrzyczne_latitude), getString(R.string.skrzyczne_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.zywiec_brewery), getString(R.string.zywiec_brewery_description), getString(R.string.zywiec_brewery_address), getString(R.string.zywiec_brewery_web), getString(R.string.zywiec_brewery_url), getString(R.string.zywiec_brewery_phone), getString(R.string.zywiec_brewery_latitude), getString(R.string.zywiec_brewery_longitude), R.drawable.bielsko));
        place.add(new Place(getString(R.string.zamek_pszczyna), getString(R.string.zamek_pszczyna_description), getString(R.string.zamek_pszczyna_address), getString(R.string.zamek_pszczyna_web), getString(R.string.zamek_pszczyna_url), getString(R.string.zamek_pszczyna_phone), getString(R.string.zamek_pszczyna_latitude), getString(R.string.zamek_pszczyna_longitude), R.drawable.bielsko));


        PlaceAdapter adapter = new PlaceAdapter(getActivity(), place);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
