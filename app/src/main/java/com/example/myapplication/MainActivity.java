package com.example.myapplication;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private int stepsNumber = 1;
    private int stepsGoal = 100;
    private int stepsIncrement = 1;
    private float percent = 0;

    private TextView stepsAmountText;
    private TextView stepsGoalText;
    private TextView stepsPercent;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TEST", " start main Activity");

        setContentView(R.layout.activity_main);
        findView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        initDefaultValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TEST", "onResume initListener");

        initListener();
    }

    private void findView() {
        stepsAmountText = (TextView) findViewById(R.id.steps_amount);
        stepsGoalText = (TextView) findViewById(R.id.steps_total);
        stepsPercent = (TextView) findViewById(R.id.steps_percent);
        progressBar = (ProgressBar) findViewById(R.id.steps_progress_bar);
    }

    private void initListener() {
        stepsAmountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsNumber = stepsNumber + stepsIncrement;
                stepsAmountText.setText(String.valueOf(stepsNumber));
                stepsPercent.setText(String.valueOf(percent));
                percent = (stepsNumber / (float) stepsGoal);
                progressBar.setProgress(stepsNumber);

                Log.i("Test tag", "percent progress bar = " + percent);

                if (stepsNumber > stepsGoal) {
                    Log.w("TAG", "maximum value exceeded = " + stepsGoal);
                }
            }
        });
    }

    private void initDefaultValues() {
        stepsAmountText.setText(String.valueOf(stepsNumber));
        stepsGoalText.setText(String.valueOf(stepsGoal));
        stepsPercent.setText(String.valueOf(percent));
        progressBar.setMax(stepsGoal);
    }
}


