package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class fictionBooksActivity extends AppCompatActivity {

    private String[] books = new String[] {"Deception Point", "Hello, Darkness",
            "The Fault in our stars", "Divergent", "Insurgent", "The Hunger Games",
            "Knight", "Legend", "Warsong", "Orison",
            "Cosmos", "Nether", "Born A Crime",
            "Amethyst", "Onyx"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_books);
    }
}
