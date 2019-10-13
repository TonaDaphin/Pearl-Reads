package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class spiritualBooksActivity extends AppCompatActivity {

    private TextView spiritualTextView;
    private ListView spiritualListView;

    private String[] spirituals = new String[] {"The Great Controversy", "The Desire of Ages",
            "Steps to Christ", "Country Living", "Last Day Events", "In Heavenly Places",
            "The Impending Conflict", "Early Writings", "Counsels on Health", "Education",
            "The Story of Redemption", "Prophets and Kings", "Patriachs and Prophets",
            "Christ Object lessons", "Blessings on the Mount"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritual_books);

        spiritualListView = (ListView) findViewById(R.id.spilistView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spirituals);
        spiritualListView.setAdapter(adapter);

        spiritualListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(spiritualBooksActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

    }
}
