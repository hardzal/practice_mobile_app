package com.example.pelatihanitcandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Button btnSendActivity = findViewById(R.id.sendButton);
        Button btnWhoActivity = findViewById(R.id.whoButton);

        final EditText nameField = (EditText) findViewById(R.id.nameField);

        btnSendActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEdit = nameField.getText().toString();
                Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                intent.putExtra("nameData", nameEdit);
                startActivity(intent);
            }
        });

        btnWhoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
