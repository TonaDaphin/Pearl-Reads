package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class fictionBooksActivity extends AppCompatActivity {

    private ListView fictionListView;

    @BindView(R.id.fictionTextView) TextView fictionTextView;
    @BindView(R.id.fictlistView) TextView fictionlistView;


    private String[] fictionals = new String[] {"Deception Point", "Hello, Darkness",
            "The Fault in our stars", "Divergent", "Insurgent", "The Hunger Games",
            "Knight", "Legend", "Warsong", "Orison",
            "Cosmos", "Nether", "Born A Crime",
            "Amethyst", "Onyx"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiction_books);
        ButterKnife.bind(this);

        fictionListView = (ListView) findViewById(R.id.fictlistView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fictionals);
        fictionListView.setAdapter(adapter);

        fictionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(fictionBooksActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

    }
}
