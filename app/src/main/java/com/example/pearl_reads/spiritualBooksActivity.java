package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class spiritualBooksActivity extends AppCompatActivity {

    private String[] books = new String[] {"The Great Controversy", "The Desire of Ages",
            "Steps to Christ", "Country Living", "Last Day Events", "In Heavenly Places",
            "The Imp", "Early Writings", "Counsels on Health", "Education",
            "ending Conflicts", "The Story of Redemption", "Prophets and Kings", "Patriachs and Prophets",
            "Christ Object lessons", "Blessings on the Mount"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritual_books);
    }
}
