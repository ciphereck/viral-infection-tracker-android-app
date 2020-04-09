package com.ciphereck.viralinfectiontracker.reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.ciphereck.viralinfectiontracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReportsMain extends AppCompatActivity {

    private BottomNavigationView navView;
    private NavController navController

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_main);

        navView = findViewById(R.id.nav_view);

        navView.setItemIconTintList(null);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navView, navController);
    }
}
