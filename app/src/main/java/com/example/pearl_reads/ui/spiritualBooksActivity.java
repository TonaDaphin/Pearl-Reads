package com.example.pearl_reads.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pearl_reads.R;
import com.example.pearl_reads.SpiritualArrayAdapter;
import com.example.pearl_reads.adapters.CanadaListAdapter;
import com.example.pearl_reads.adapters.FictionListAdapter;
import com.example.pearl_reads.models.Bookstoresearch;
import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.models.Category;
import com.example.pearl_reads.network.YelpApi;
import com.example.pearl_reads.network.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class spiritualBooksActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private CanadaListAdapter mAdapter;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritual_books);

        YelpApi client = YelpClient.getClient();

        Call<Bookstoresearch> call = client.getBookstores("Canada", "bookstores");
        call.enqueue(new Callback<Bookstoresearch>() {

            @Override
            public void onResponse(Call<Bookstoresearch> call, Response<Bookstoresearch> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Business> mBookstores = response.body().getBusinesses();
                    mAdapter = new CanadaListAdapter(spiritualBooksActivity.this, mBookstores);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(spiritualBooksActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);


                    showBookstores();
                } else {
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<Bookstoresearch> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });


        ButterKnife.bind(this);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showBookstores() {
        mRecyclerView.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}
