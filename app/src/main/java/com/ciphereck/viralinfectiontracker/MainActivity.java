package com.ciphereck.viralinfectiontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ciphereck.viralinfectiontracker.aboutUs.AboutUs;
import com.ciphereck.viralinfectiontracker.reports.ReportsActivity;
import com.jakewharton.rxbinding3.view.RxView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Unit;

public class MainActivity extends AppCompatActivity {
    private Button showReportButton;
    private Button showAboutUsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
    }

    private void initializeView() {
        showReportButton = findViewById(R.id.showReport);
        showAboutUsButton = findViewById(R.id.aboutUs);

        navigationInitialization();
    }


    private void navigationInitialization() {
        mapButtonToScreen(getClickObservable(showReportButton), ReportsActivity.class);
        mapButtonToScreen(getClickObservable(showAboutUsButton), AboutUs.class);
    }

    private void mapButtonToScreen(Observable<Unit> clickObservable, final Class<? extends Activity> activity) {
        clickObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((irrelevant) -> startActivity(new Intent(getApplicationContext(), activity)));
    }

    private Observable<Unit> getClickObservable(Button button) {
        return RxView.clicks(button);
    }
}
