package com.example.pearl_reads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.pearl_reads.R;
import com.example.pearl_reads.models.Bookstore;
import com.example.pearl_reads.util.ItemTouchHelperAdapter;
import com.example.pearl_reads.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class FirebaseBookstoreListAdapter  extends FirebaseRecyclerAdapter<Bookstore, FirebaseBookstoreViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseBookstoreListAdapter(FirebaseRecyclerOptions<Bookstore> options,
                                        DatabaseReference ref,
                                        OnStartDragListener onStartDragListener,
                                        Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }
    @Override
    protected void onBindViewHolder(@NonNull FirebaseBookstoreViewHolder firebaseRestaurantViewHolder, int position, @NonNull Bookstore bookstore) {
        firebaseRestaurantViewHolder.bindRestaurant(bookstore);
    }

    @NonNull
    @Override
    public FirebaseBookstoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usa_list_item_drag, parent, false);
        return new FirebaseBookstoreViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        return false;
    }

    @Override
    public void onItemDismiss(int position){

    }
}
