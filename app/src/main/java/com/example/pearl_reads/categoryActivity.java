package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class categoryActivity extends AppCompatActivity {
    private Button fictionButton;
    private Button spiritualButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        fictionButton = (Button)findViewById(R.id.buttontofiction);
        spiritualButton = (Button)findViewById(R.id.buttontospiritual);

        fictionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(categoryActivity.this, fictionBooksActivity.class);
                startActivity(intent);
            }
        });
        spiritualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(categoryActivity.this, spiritualBooksActivity.class);
                startActivity(intent);
            }
        });

    }
}
