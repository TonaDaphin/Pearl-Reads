package com.example.pearl_reads.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.ui.usaDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FictionListAdapter extends RecyclerView.Adapter<FictionListAdapter.BookstoreViewHolder> {
    private List<Business> mBookstores;
    private Context mContext;

    public FictionListAdapter(Context context, List<Business> bookstores) {
        mContext = context;
        mBookstores = bookstores;
    }

    @Override
    public FictionListAdapter.BookstoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usa_list_item, parent, false);
        BookstoreViewHolder viewHolder = new BookstoreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FictionListAdapter.BookstoreViewHolder holder, int position) {
        holder.bindBookstore(mBookstores.get(position));
    }

    @Override
    public int getItemCount() {
        return mBookstores.size();
    }

    public class BookstoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.bookstoreImageView)
        ImageView mBookstoreImageView;
        @BindView(R.id.bookstoreNameTextView)
        TextView mNameTextView;
        @BindView(R.id.categoryTextView)
        TextView mCategoryTextView;
        @BindView(R.id.ratingTextView)
        TextView mRatingTextView;
        private Context mContext;

        public BookstoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, usaDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mBookstores));
            mContext.startActivity(intent);
        }

        public void bindBookstore(Business bookstore) {
            Picasso.get().load(bookstore.getImageUrl()).into(mBookstoreImageView);

            mNameTextView.setText(bookstore.getName());
            mCategoryTextView.setText(bookstore.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + bookstore.getRating() + "/5");
        }
    }
}