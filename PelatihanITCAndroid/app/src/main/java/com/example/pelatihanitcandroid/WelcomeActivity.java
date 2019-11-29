package com.example.pelatihanitcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent dataIntent = getIntent();

        if(dataIntent.hasExtra("nameData")) {
            TextView tvNameView = (TextView) findViewById(R.id.nameView);

            String tvName = dataIntent.getStringExtra("nameData");

            if (tvName.equals("")) {
                tvName = "Hi!";
            }

            tvNameView.setText(tvName);
        }
    }
}
