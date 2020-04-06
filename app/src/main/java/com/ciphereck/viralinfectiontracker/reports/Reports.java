package com.ciphereck.viralinfectiontracker.reports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Reports extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(StatisticsClientInstance.getInstance().getCountryStatistics().size());
    }
}
