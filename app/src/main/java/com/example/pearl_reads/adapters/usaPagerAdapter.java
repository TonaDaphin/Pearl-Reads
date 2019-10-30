package com.example.pearl_reads.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.ui.usaDetailFragment;

import java.util.List;

public class usaPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mBookstores;

    public usaPagerAdapter(FragmentManager fm, List<Business> restaurants){
        super(fm);
        mBookstores = restaurants;
    }

    @Override
    public Fragment getItem(int position){
        return usaDetailFragment.newInstance(mBookstores.get(position));
    }

    @Override
    public int getCount(){
        return mBookstores.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mBookstores.get(position).getName();
    }
}
