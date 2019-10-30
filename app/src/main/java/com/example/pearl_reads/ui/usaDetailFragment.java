package com.example.pearl_reads.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class usaDetailFragment extends Fragment {
    @BindView(R.id.restaurantImageView)
    ImageView mImageLabel;
    @BindView(R.id.bookstoreNameTextView)
    TextView mNameLabel;
    @BindView(R.id.cuisineTextView)
    TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView)
    TextView mRatingLabel;
    @BindView(R.id.websiteTextView)
    TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView)
    TextView mPhoneLabel;
    @BindView(R.id.addressTextView)
    TextView mAddressLabel;
    @BindView(R.id.saveBookstoreButton)
    TextView mSaveBookstoreButton;

    private Business mBookstores;

    public usaDetailFragment() {
        // Required empty public constructor
    }

    public static usaDetailFragment newInstance(Business restaurant) {
        usaDetailFragment restaurantDetailFragment = new usaDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restaurant", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookstores = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usa_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mBookstores.getImageUrl()).into(mImageLabel);
        List<String> categories = new ArrayList<>();

        for (Category category : mBookstores.getCategories()) {
            categories.add(category.getTitle());
        }

        mNameLabel.setText(mBookstores.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText(Double.toString(mBookstores.getRating()) + "/5");
        mPhoneLabel.setText(mBookstores.getPhone());
        mAddressLabel.setText(mBookstores.getLocation().toString());

        return view;
    }

}

