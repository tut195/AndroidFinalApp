package com.skillup.finalapp.view.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final Integer SCREEN_COUNT = 2;

    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case (1): break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return SCREEN_COUNT;
    }
}
