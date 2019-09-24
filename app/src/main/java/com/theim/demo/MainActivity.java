package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnScreen1,btnScreen2,btnScreen3,buttonRecyclerView,buttonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScreen1 = findViewById(R.id.btnScreen1);
        btnScreen2 = findViewById(R.id.btnScreen2);
        btnScreen3 = findViewById(R.id.btnScreen3);
        buttonRecyclerView = findViewById(R.id.buttonRecyclerView);
        //buttonFragment = findViewById(R.id.buttonFragment);

        // set on click
        btnScreen1.setOnClickListener(this);
        btnScreen2.setOnClickListener(this);
        btnScreen3.setOnClickListener(this);
        buttonRecyclerView.setOnClickListener(this);
        //buttonFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnScreen1:
                goScreen1();
                break;
            case R.id.btnScreen2:
                goScreen2();
                break;
            case R.id.btnScreen3:
                goScreen3();
                break;
            case R.id.buttonRecyclerView:
                goRecyclerView();
                break;
        }

    }

    private void goScreen1(){
        Intent intent = new Intent(this,Screen1Activity.class);
        startActivity(intent);
    }
    private void goScreen2(){
        Intent intent = new Intent(this,Screen2Activity.class);
        intent.putExtra("ref","MainActivity");
        startActivity(intent);
    }
    private void goScreen3(){
        Intent intent = new Intent(this,Screen3Activity.class);
        intent.putExtra("number",1);
        startActivity(intent);
    }

    private void goRecyclerView(){
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    private void goFragmentView(){
        Intent intent = new Intent(this, FragmentViewActivity.class);
        startActivity(intent);
    }
}
