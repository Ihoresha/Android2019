package com.example.laba2;

import android.content.Intent;

import android.os.Handler;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;



public class MainActivity extends AppCompatActivity {



    private int time;

    private boolean isWork;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        StartTimer();



    }



    public void nextActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);

    }



    public void OnStartBtnClick(View view) {

        isWork = true;

    }



    public void OnStopBtnClick(View view) {

        isWork = false;



    }

    public void OnResetBtnClick(View view) {

        isWork = false;

        time = 0;

    }

    private void StartTimer(){

        final TextView viewForTime = findViewById(R.id.time_view);

        final Handler handler = new Handler();



        handler.post(new Runnable() {

            @Override

            public void run() {

                int[] timeFormat = new int[]{time/3600, (time%3600)/60, time%60};





                String timeView = String.format("%d:%02d:%02d",timeFormat[0],timeFormat[1],timeFormat[2]);

                viewForTime.setText(timeView);



                if(isWork){

                    time++;

                }

                handler.postDelayed(this,950);

            }

        });





    }

}