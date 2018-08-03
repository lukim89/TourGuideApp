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
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = getTitle().toString();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.requestLayout();
        mDrawerList = (ListView) findViewById(R.id.navList);
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
        list.add("Main");
        list.add("Tourist Information");
        list.add("Transportation");
        list.add("Emergency");
        final LinearLayout fragmentContainer = findViewById(R.id.secondaryList);
        fragmentContainer.setVisibility(View.GONE);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
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
                    mTitle = "Tourist Information";
                    getSupportActionBar().setTitle(mTitle);
                } else if (position == 2) {
                    FragmentTransportation fragment = new FragmentTransportation();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.secondaryList, fragment);
                    fragmentContainer.setVisibility(View.VISIBLE);
                    transaction.commit();
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.INVISIBLE);
                    mTitle = "Transportation";
                    getSupportActionBar().setTitle(mTitle);
                } else {
                    FragmentEmergency fragment = new FragmentEmergency();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.secondaryList, fragment);
                    fragmentContainer.setVisibility(View.VISIBLE);
                    transaction.commit();
                    LinearLayout mainList = findViewById(R.id.mainList);
                    mainList.setVisibility(View.INVISIBLE);
                    mTitle = "Emergency";
                    getSupportActionBar().setTitle(mTitle);
                }

                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely closed state. */
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

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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