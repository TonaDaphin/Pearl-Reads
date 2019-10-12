package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class categoryActivity extends AppCompatActivity {

    private String[] books = new String[] {"The Great Controversy", "The Desire of Ages",
            "Steps to Christ", "Country Living", "Last Day Events", "In Heavenly Places",
            "Knight", "Legend", "Warsong", "Orison",
            "Cosmos", "Nether", "Born A Crime",
            "Amethyst", "Onyx"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }
}
