package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private Runnable runnable;
    private Handler handler;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("DEMO_DEBUG","Number: "+(number++));
                runNumber();
            }
        };

        runNumber();
    }

    private void runNumber(){
        handler.postDelayed(runnable,1000);
    }
    private void stopNumber(){
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DEMO_DEBUG","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DEMO_DEBUG","onDestroy");

        stopNumber();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DEMO_DEBUG","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DEMO_DEBUG","onStop");
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("แจ้งเตือน")
                .setMessage("ยืนยันปิด?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        onBackPressed2();
                    }})
                .setNegativeButton(android.R.string.no, null).show();

        Log.i("DEMO_DEBUG","onBackPressed");
    }

    private void onBackPressed2(){
        super.onBackPressed();
    }
}
