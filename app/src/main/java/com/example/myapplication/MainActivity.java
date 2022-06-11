package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int stepsNumber = 0;
    int stepsGoal = 9000;
    int stepsIncrement = 111;
    float percent = 0;


    TextView stepsAmountText;
    TextView stepsGoalText;
    TextView stepsPercent;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TEST", "onCreate");
        setContentView(R.layout.activity_main);
        stepsAmountText = (TextView) findViewById(R.id.steps_amount);
        stepsGoalText = (TextView) findViewById(R.id.steps_total);
        stepsPercent = (TextView) findViewById(R.id.steps_percent);
        progressBar = (ProgressBar) findViewById(R.id.steps_progress_bar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        stepsAmountText.setText(String.valueOf(stepsNumber));
        stepsGoalText.setText(String.valueOf(stepsGoal));
        stepsPercent.setText(String.valueOf(percent));
        progressBar.setMax(stepsGoal);
        Log.e("TEST", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TEST", "onResume");

        stepsAmountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsNumber = stepsNumber + stepsIncrement;
                stepsAmountText.setText(String.valueOf(stepsNumber));
                stepsPercent.setText(String.valueOf(percent));
                percent = stepsNumber / (float) stepsGoal;
                progressBar.setProgress(stepsNumber);
                Log.i("Test tag", "percent = " + percent);
            }

        });


    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TEST", "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TEST", "onStop");
    }
}