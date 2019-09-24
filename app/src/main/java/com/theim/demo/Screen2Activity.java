package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    TextView textViewRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // intent
        Intent intent = getIntent();
        String textRef = intent.getStringExtra("ref");

        textViewRef = findViewById(R.id.textViewRef);
        textViewRef.setText(textRef);
    }
}
