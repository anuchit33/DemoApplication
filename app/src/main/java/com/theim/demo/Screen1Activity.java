package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Screen1Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        findViewById(R.id.button).setOnClickListener(this);
    }

    private void goScreen2(){
        Intent intent = new Intent(this,Screen2Activity.class);
        intent.putExtra("ref","Screen1Activity");
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        goScreen2();
    }
}
