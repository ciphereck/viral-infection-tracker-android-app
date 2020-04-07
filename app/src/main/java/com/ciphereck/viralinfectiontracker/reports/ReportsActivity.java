package com.ciphereck.viralinfectiontracker.reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ciphereck.viralinfectiontracker.R;

public class ReportsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView totalCases;
    private TextView totalTestsPerformed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activtity_reports_main);
        initView();
    }

    private void initView() {
        totalCases = findViewById(R.id.totalCases);
        totalTestsPerformed = findViewById(R.id.totalTest);

        updateData();
    }

    private void updateData() {
        if(StatisticsClientInstance.getInstance().getCountryStatistics().size() == 0) {
            return;
        }
        CountryStatistics countryStatistics = StatisticsClientInstance.getInstance().getCountryStatistics().get(0);
        totalCases.setText(countryStatistics.getTotalCases().toString());
        totalTestsPerformed.setText(countryStatistics.getTotalTestsPerformed().toString());
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryStatisticAdapter(StatisticsClientInstance.getInstance().getCountryStatistics(), this);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
