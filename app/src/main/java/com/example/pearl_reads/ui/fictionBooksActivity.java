package com.example.pearl_reads.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pearl_reads.FictionArrayAdapter;
import com.example.pearl_reads.R;
import com.example.pearl_reads.network.YelpApi;
import com.example.pearl_reads.network.YelpClient;
import com.example.pearl_reads.models.Bookstoresearch;
import com.example.pearl_reads.models.Business;
import com.example.pearl_reads.models.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fictionBooksActivity extends AppCompatActivity {


    @BindView(R.id.fictionTextView) TextView fictionTextView;
    @BindView(R.id.fictlistView) ListView fictionlistView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

//
//    private String[] fictionals = new String[] {"Deception Point", "Hello, Darkness",
//            "The Fault in our stars", "Divergent", "Insurgent", "The Hunger Games",
//            "Knight", "Legend", "Warsong", "Orison",
//            "Cosmos", "Nether", "Born A Crime",
//            "Amethyst", "Onyx"};
//
//    private String[] fictionauthors = new String[] {"Deception Point", "Hello, Darkness",
//            "The Fault in our stars", "Divergent", "Insurgent", "The Hunger Games",
//            "Knight", "Legend", "Warsong", "Orison",
//            "Cosmos", "Nether", "Born A Crime",
//            "Amethyst", "Onyx"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_books);

        YelpApi client = YelpClient.getClient();
        Call<Bookstoresearch> call = client.getBookstores("usa", "bookstores");

        call.enqueue(new Callback<Bookstoresearch>() {
            @Override
            public void onResponse(Call<Bookstoresearch> call, Response<Bookstoresearch> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Business> bookstoresList = response.body().getBusinesses();
                    String[] bookstores = new String[bookstoresList.size()];
                    String[] categories = new String[bookstoresList.size()];
                    for (int i = 0; i < bookstores.length; i++){
                        bookstores[i] = bookstoresList.get(i).getName();
                    }
                    for (int i = 0; i < categories.length; i++) {
                        Category category = bookstoresList.get(i).getCategories().get(0);
                        categories[i] = category.getTitle();
                    }
                    ArrayAdapter adapter = new FictionArrayAdapter(fictionBooksActivity.this, android.R.layout.simple_list_item_1, bookstores, categories);
                    fictionlistView.setAdapter(adapter);
                    showBookstores();
                }else{
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

//        FictionArrayAdapter adapter = new FictionArrayAdapter(this, android.R.layout.simple_list_item_1, fictionals,fictionauthors); // must match constructor!
//        fictionlistView.setAdapter(adapter);

        fictionlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(fictionBooksActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }

        });

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
        fictionlistView.setVisibility(View.VISIBLE);
        fictionTextView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
