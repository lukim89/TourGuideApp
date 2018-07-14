package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int mType;

    public CategoryAdapter(Context context, FragmentManager fragmentManager, int type) {
        super(fragmentManager);
        mContext = context;
        mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        if (mType == 1) {
            if (position == 0) {
                return new FragmentOne();
            } else if (position == 1) {
                return new FragmentTwo();
            } else {
                return new FragmentThree();
            }
        } else {
            if (position == 0) {
                return new DetailsFragment();
            } else {
                return new DetailsMapFragment();
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
                return mContext.getString(R.string.One);
            } else if (position == 1) {
                return mContext.getString(R.string.Two);
            } else {
                return mContext.getString(R.string.Three);
            }
        } else {
            if (position == 0) {
                return mContext.getString(R.string.Details);
            } else {
                return mContext.getString(R.string.Map);
            }
        }
    }
}
