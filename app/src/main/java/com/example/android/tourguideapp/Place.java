package com.example.android.tourguideapp;

public class Place {

    private String mName;
    private String mAddress;
    private String mWeb;
    private String mURL;
    private String mPhone;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private int mImageResourceId;

    Place(String name, String description, String address, String web, String url, String phone, String latitude, String longitude, int imageResourceId) {
        mName = name;
        mDescription = description;
        mAddress = address;
        mWeb = web;
        mURL = url;
        mPhone = phone;
        mLatitude = Double.parseDouble(latitude);
        mLongitude = Double.parseDouble(longitude);
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getWeb() {
        return mWeb;
    }

    public String getURL() {
        return mURL;
    }

    public String getPhone() {
        return mPhone;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
