package com.ciphereck.viralinfectiontracker.reports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.ciphereck.viralinfectiontracker.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ReportsActivity extends AppCompatActivity {
    PieChart worldActivePieChart, worldClosedPieChart, countryTotalPieChart;
    TextView worldActive, worldClosed, worldTotal, worldTotalTest;
    TextView countryActive, countryTotal, countryDeath, countryRecovered;
    CountryStatistics worldData = null;
    StateStatistics countryData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activtity_reports_main);
        initView();
        updateData();
    }

    private void initView() {
        if(StatisticsClientInstance.getInstance().getCountryStatistics().size() > 0) {
            worldData = StatisticsClientInstance.getInstance().getCountryStatistics().get(0);
        }
        if(StatisticsClientInstance.getInstance().getStateStatistics().size() > 0) {
            countryData = StatisticsClientInstance.getInstance().getStateStatistics().get(0);
        }
        worldActive = findViewById(R.id.world_active);
        worldClosed = findViewById(R.id.world_closed);
        worldActivePieChart = findViewById(R.id.world_pieChart_active);
        worldClosedPieChart = findViewById(R.id.world_pieChart_inactive);
        worldTotal = findViewById(R.id.world_total);
        worldTotalTest = findViewById(R.id.world_total_test);

        countryTotal = findViewById(R.id.country_total);
        countryActive = findViewById(R.id.country_total_active);
        countryDeath = findViewById(R.id.country_total_deaths);
        countryRecovered = findViewById(R.id.country_total_recovered);
        countryTotalPieChart = findViewById(R.id.country_pieChart_total);
    }

    private void updateData() {
        updateWorldData();
        updateCountryData();
    }

    private void updateCountryData() {
        if(countryData != null) {
            countryTotal.setText("Total Confirmed Cases:\n" + countryData.getTotalCases().toString());
            countryActive.setText("Active Cases:\n" + countryData.getTotalActiveCases().toString());
            countryDeath.setText("Total Deaths:\n" + countryData.getTotalDeaths().toString());
            countryRecovered.setText("Total Recovered:\n" + countryData.getTotalRecovered().toString());
            updateCountryTotalCases();
        }
    }

    private void updateCountryTotalCases() {
        ArrayList pieEntries = new ArrayList();
        pieEntries.add(new PieEntry(countryData.getTotalRecovered(), "Recovered"));
        pieEntries.add(new PieEntry(countryData.getTotalDeaths(), "Deaths"));
        pieEntries.add(new PieEntry(countryData.getTotalActiveCases(), "Active Cases"));

        ArrayList pieColors = new ArrayList();
        pieColors.add((Color.rgb(40, 167, 69)));
        pieColors.add(Color.rgb(255, 7, 58));
        pieColors.add(Color.rgb(0, 123, 255));

        updatePieChart(countryTotalPieChart, pieEntries, pieColors);
    }

    private void updateWorldData() {
        if(worldData != null) {
            updateWorldActiveCases();
            updateWorldClosedCases();
            worldTotal.setText("Total Cases:\n" + worldData.getTotalCases());
            worldTotalTest.setText("Total Tests Performed:\n" + worldData.getTotalTestsPerformed());
        }
    }

    private void updateWorldActiveCases() {
        worldActive.setText("Active Cases:\n" + worldData.getTotalActiveCases());

        ArrayList pieEntries = new ArrayList();
        pieEntries.add(new PieEntry(worldData.getTotalCriticalCases()
                , "Critical Cases"));
        pieEntries.add(new PieEntry(worldData.getTotalActiveCases() - worldData.getTotalCriticalCases()
                , "Mild Cases"));

        ArrayList pieColors = new ArrayList();
        pieColors.add(Color.rgb(184, 15, 10));
        pieColors.add(Color.rgb(0, 128, 255));

        updatePieChart(worldActivePieChart, pieEntries, pieColors);
    }

    private void updateWorldClosedCases() {
        worldClosed.setText("Closed Cases:\n" + (worldData.getTotalDeaths() + worldData.getTotalRecovered()));

        ArrayList pieEntries = new ArrayList();
        pieEntries.add(new PieEntry(worldData.getTotalDeaths(), "Total Deaths"));
        pieEntries.add(new PieEntry(worldData.getTotalRecovered(), "Recovered"));

        ArrayList pieColors = new ArrayList();
        pieColors.add(Color.rgb(139, 0, 0));
        pieColors.add((Color.rgb(40, 167, 69)));

        updatePieChart(worldClosedPieChart, pieEntries, pieColors);
    }

    private void updatePieChart(PieChart pieChart, ArrayList pieEntries , ArrayList colors) {
        DisplayMetrics width = Resources.getSystem().getDisplayMetrics();
        pieChart.setMinimumWidth((width.widthPixels/2) - 16);

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieChart.setCenterTextRadiusPercent(10);

        PieData pieData = new PieData(pieDataSet);

        pieDataSet.setColors(colors);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setValueTextSize(10);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueLinePart1Length(0.5f);
        pieDataSet.setValueLinePart2Length(0);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawSliceText(false);
    }

}
