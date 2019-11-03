package com.example.pearl_reads;

import android.content.Context;
import android.widget.ArrayAdapter;

public class UsaArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] fictionals;
    private String[] fictionauthors;

    public UsaArrayAdapter(Context mContext, int resource, String[] fictionals, String[] fictionauthors) {
        super(mContext, resource);
        this.mContext = mContext;
        this.fictionals = fictionals;
        this.fictionauthors = fictionauthors;
    }
    @Override
    public Object getItem(int position) {
        String fiction = fictionals[position];
        String categories = fictionauthors[position];
        return String.format("%s \nCategory: %s", fiction, categories);
    }

    @Override
    public int getCount() {
        return fictionals.length;
    }
}
