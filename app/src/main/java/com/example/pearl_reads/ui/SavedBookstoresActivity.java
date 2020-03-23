package com.example.pearl_reads.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pearl_reads.Constants;
import com.example.pearl_reads.R;
import com.example.pearl_reads.adapters.FirebaseBookstoreViewHolder;
import com.example.pearl_reads.models.Bookstore;
import com.example.pearl_reads.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedBookstoresActivity extends AppCompatActivity {
    private DatabaseReference mRestaurantReference;
    private FirebaseRecyclerAdapter<Bookstore, FirebaseBookstoreViewHolder> mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstores);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BOOKSTORES).child(uid);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Bookstore> options =
                new FirebaseRecyclerOptions.Builder<Bookstore>()
                        .setQuery(mRestaurantReference, Bookstore.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Bookstore, FirebaseBookstoreViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseBookstoreViewHolder firebaseRestaurantViewHolder, int position, @NonNull Bookstore bookstore) {
                firebaseRestaurantViewHolder.bindRestaurant(bookstore);
            }

            @NonNull
            @Override
            public FirebaseBookstoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usa_list_item, parent, false);
                return new FirebaseBookstoreViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

}
