package com.ciphereck.viralinfectiontracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.ciphereck.viralinfectiontracker.retrofit.statistics.RetrofitStatisticsHelper;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    private static final int splashScreenWaitTimeInMS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        runAllThreads();
    }

    private void runAllThreads() {
        Thread changeScreenThread = new Thread(() -> changeScreen());
        Thread fetchDataThread = new Thread(() -> fetchData());

        changeScreenThread.start();
        fetchDataThread.start();
    }

    public void fetchData() {
        RetrofitStatisticsHelper.updateCountryStatistics();
    }

    public void changeScreen() {
        try {
            sleep(splashScreenWaitTimeInMS);
        } catch(Exception e) {

        }

        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        finish();
    }
}
