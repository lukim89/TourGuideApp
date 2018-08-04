package com.example.android.tourguideapp;

public class EmergencyContact {

    private String mName;
    private String mPhone;

    EmergencyContact(String name, String phone) {
        mName = name;
        mPhone = phone;

    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }
}
