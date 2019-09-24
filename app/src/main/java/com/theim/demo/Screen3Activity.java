package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Screen3Activity extends AppCompatActivity implements View.OnClickListener {

    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Intent intent = this.getIntent();
        number = intent.getIntExtra("number",number);
        ((TextView)findViewById(R.id.textViewNumber)).setText("Number: "+number);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Screen3Activity.this,Screen3Activity.class);
        intent.putExtra("number",number+1);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
