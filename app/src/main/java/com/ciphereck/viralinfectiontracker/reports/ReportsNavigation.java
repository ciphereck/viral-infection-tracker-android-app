package com.ciphereck.viralinfectiontracker.reports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.ciphereck.viralinfectiontracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import android.view.MenuItem;

public class ReportsNavigation extends AppCompatActivity {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_navigation);

        navView = findViewById(R.id.nav_view);

        navView.setItemIconTintList(null);
        navView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container, new ReportsActivity()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {

                        case R.id.navigation_home:
                            selectedFragment = new ReportsActivity();
                            break;

                        case R.id.navigation_country:
                        case R.id.navigation_state:
                            selectedFragment = new StatisticsList();
                            break;


                    }
                    if(selectedFragment!=null)
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container, selectedFragment).commit();
                    return true;
                }
            };

}
