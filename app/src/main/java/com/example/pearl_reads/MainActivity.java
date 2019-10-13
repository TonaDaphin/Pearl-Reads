package com.example.pearl_reads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.buttontolibrary) Button libraryButton;
    @BindView(R.id.nameEditText) EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        libraryButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
        if(v == libraryButton) {
            String name= usernameEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, categoryActivity.class);
            intent.putExtra("name", name );
            startActivity(intent);
        }
            }

    }

