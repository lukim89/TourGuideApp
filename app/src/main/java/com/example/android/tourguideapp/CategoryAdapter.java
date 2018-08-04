package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int mType;

    CategoryAdapter(Context context, FragmentManager fragmentManager, int type) {
        super(fragmentManager);
        mContext = context;
        mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        if (mType == 1) {
            if (position == 0) {
                return new FragmentTouristAttractions();
            } else if (position == 1) {
                return new FragmentGastronomy();
            } else {
                return new FragmentHotels();
            }
        } else {
            if (position == 0) {
                return new FragmentDetails();
            } else {
                return new FragmentDetailsMap();
            }
        }
    }

    @Override
    public int getCount() {
        if (mType == 1) {
            return 3;
        } else return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mType == 1) {
            if (position == 0) {
                return mContext.getString(R.string.tourist_attractions);
            } else if (position == 1) {
                return mContext.getString(R.string.gastronomy);
            } else {
                return mContext.getString(R.string.hotels);
            }
        } else {
            if (position == 0) {
                return mContext.getString(R.string.Description);
            } else {
                return mContext.getString(R.string.map);
            }
        }
    }
}
