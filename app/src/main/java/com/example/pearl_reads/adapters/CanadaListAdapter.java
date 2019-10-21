package com.example.pearl_reads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Business;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CanadaListAdapter extends RecyclerView.Adapter<CanadaListAdapter.BookstoreViewHolder> {
    private List<Business> mBookstores;
    private Context mContext;

    public CanadaListAdapter(Context context, List<Business> bookstores) {
        mContext = context;
        mBookstores = bookstores;
    }

    @Override
    public CanadaListAdapter.BookstoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.canada_list_item, parent, false);
        BookstoreViewHolder viewHolder = new BookstoreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CanadaListAdapter.BookstoreViewHolder holder, int position) {
        holder.bindBookstore(mBookstores.get(position));
    }

    @Override
    public int getItemCount() {
        return mBookstores.size();
    }

    public class BookstoreViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bookstoreImageView) ImageView mBookstoreImageView;
        @BindView(R.id.bookstoreNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public BookstoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBookstore(Business bookstore) {
            Picasso.get().load(bookstore.getImageUrl()).into(mBookstoreImageView);

            mNameTextView.setText(bookstore.getName());
            mCategoryTextView.setText(bookstore.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + bookstore.getRating() + "/5");
        }
    }
}
