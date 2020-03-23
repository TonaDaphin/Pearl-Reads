package com.example.pearl_reads.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pearl_reads.Constants;
import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.models.Category;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class usaDetailFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.bookstoreImageView)
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

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mBookstores.getWebsite()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mBookstores.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mBookstores.getLatitude()
                            + "," + mBookstores.getLongitude()
                            + "?q=(" + mBookstores.getName() + ")"));
            startActivity(mapIntent);
        }
        if (v == mSaveBookstoreButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_BOOKSTORES)
                    .child(uid);
            DatabaseReference pushRef = restaurantRef.push();
            String pushId = pushRef.getKey();
            mBookstores.setPushId(pushId);
            pushRef.setValue(mBookstores);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}
