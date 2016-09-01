package com.example.animatedintro;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Pushpendra on 5/8/16.
 */
public class IntroAdapter extends FragmentPagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#EBF4FA"), position); // blue water
            default:
                return IntroFragment.newInstance(Color.parseColor("#EBF4FA"), position); // blue water
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
