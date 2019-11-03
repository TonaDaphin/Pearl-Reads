package com.example.pearl_reads.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pearl_reads.Constants;
import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Bookstore;
import com.example.pearl_reads.ui.usaDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseBookstoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseBookstoreViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindRestaurant(Bookstore bookstore){
        ImageView bookstoreImageView = mView.findViewById(R.id.bookstoreImageView);
        TextView nameTextView = mView.findViewById(R.id.bookstoreNameTextView);
        TextView categoryTextView = mView.findViewById(R.id.categoryTextView);
        TextView ratingTextView = mView.findViewById(R.id.ratingTextView);

        nameTextView.setText(bookstore.getName());
        categoryTextView.setText(bookstore.getCategories().get(0));
        ratingTextView.setText("Rating: " + bookstore.getRating() + "/5");
        Picasso.get().load(bookstore.getImageUrl()).into(bookstoreImageView);
    }

    @Override
    public void onClick(View view){
        final ArrayList<Bookstore> bookstores = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BOOKSTORES).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    bookstores.add(snapshot.getValue(Bookstore.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, usaDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(bookstores));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
