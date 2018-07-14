package com.example.android.tourguideapp;

public class Place {

    private String mName;
    private String mDescription;
    private String mShortDescription;
    private int mImageResourceId;

    public Place(String name,String shortDescription, String description, int imageResourceId) {
        mName = name;
        mShortDescription = shortDescription;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
