package com.example.android.tourguideapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = getTitle().toString();
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.requestLayout();
        mDrawerList = findViewById(R.id.navList);
        mDrawerList.bringToFront();

        addDrawerItems();
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ViewPager viewPager = findViewById(R.id.viewpager);
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager(), 1);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void addDrawerItems() {
        final ArrayList list = new ArrayList();
        list.add(getString(R.string.main_menu));
        list.add(getString(R.string.tourist_information_menu));
        list.add(getString(R.string.transportation_menu));
        list.add(getString(R.string.emergency_menu));
        final LinearLayout fragmentContainer = findViewById(R.id.secondaryList);
        fragmentContainer.setVisibility(View.GONE);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.VISIBLE);
                    fragmentContainer.setVisibility(View.GONE);
                    mTitle = getTitle().toString();
                    getSupportActionBar().setTitle(mTitle);

                } else if (position == 1) {
                    FragmentTouristInformation fragment = new FragmentTouristInformation();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.secondaryList, fragment);
                    fragmentContainer.setVisibility(View.VISIBLE);
                    transaction.commit();
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.INVISIBLE);
                    mTitle = getString(R.string.tourist_information_menu);
                    getSupportActionBar().setTitle(mTitle);

                } else if (position == 2) {
                    FragmentTransportation fragment = new FragmentTransportation();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.secondaryList, fragment);
                    fragmentContainer.setVisibility(View.VISIBLE);
                    transaction.commit();
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.INVISIBLE);
                    mTitle = getString(R.string.transportation_menu);
                    getSupportActionBar().setTitle(mTitle);

                } else {
                    FragmentEmergency fragment = new FragmentEmergency();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.secondaryList, fragment);
                    fragmentContainer.setVisibility(View.VISIBLE);
                    transaction.commit();
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.INVISIBLE);
                    mTitle = getString(R.string.emergency_menu);
                    getSupportActionBar().setTitle(mTitle);
                }

                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.navigation);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}