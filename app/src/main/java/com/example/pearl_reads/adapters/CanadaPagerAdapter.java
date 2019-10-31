package com.example.pearl_reads.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.ui.CanadaDetailFragment;

import java.util.List;

public class CanadaPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mRestaurants;

    public CanadaPagerAdapter(FragmentManager fm, List<Business> restaurants) {
        super(fm);
        mRestaurants = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return CanadaDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}
