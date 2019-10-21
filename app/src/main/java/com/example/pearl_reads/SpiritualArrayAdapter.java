package com.example.pearl_reads;

import android.content.Context;
import android.widget.ArrayAdapter;

public class SpiritualArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mBookstores;
    private String[] mCategory;

    public SpiritualArrayAdapter(Context mContext, int resource, String[] mBookstores, String[] mCategory) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mBookstores = mBookstores;
        this.mCategory = mCategory;
    }
    @Override
    public Object getItem(int position) {
        String bookstore = mBookstores[position];
        String category = mCategory[position];
        return String.format("%s \nCategory: %s", bookstore, category);
    }

    @Override
    public int getCount() {
        return mBookstores.length;
    }
}
