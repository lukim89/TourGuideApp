package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmergencyAdapter extends ArrayAdapter<EmergencyContact> {

    EmergencyAdapter(Activity context, ArrayList<EmergencyContact> emergencyContact) {
        super(context, 0, emergencyContact);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.emergency_list_item, parent, false);
        }

        final EmergencyContact currentEmergencyContact = getItem(position);

        String name = currentEmergencyContact.getName();
        String phone = currentEmergencyContact.getPhone();

        TextView nameTextView = listItemView.findViewById(R.id.name);
        nameTextView.setTextSize(24);
        nameTextView.setGravity(Gravity.CENTER_VERTICAL);
        nameTextView.setText(name);

        TextView phoneTextView = listItemView.findViewById(R.id.phone);
        phoneTextView.setTextSize(24);
        phoneTextView.setGravity(Gravity.CENTER_VERTICAL);
        phoneTextView.setGravity(Gravity.END);
        phoneTextView.setText(phone);

        return listItemView;
    }


}
