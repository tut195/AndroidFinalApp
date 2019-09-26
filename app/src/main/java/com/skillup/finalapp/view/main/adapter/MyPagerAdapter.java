package com.skillup.finalapp.view.main.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.skillup.finalapp.view.add.AddFragment;
import com.skillup.finalapp.view.map.MapFragment;

import java.util.ArrayList;
import java.util.List;


public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;

    private List<String> fragmentTitleList;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        fragmentTitleList = new ArrayList<>();

        fragmentTitleList.add(com.skillup.finalapp.view.map.MapFragment.TITTLE);
        fragmentTitleList.add(AddFragment.TITLE);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return AddFragment.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return MapFragment.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

}