package com.ciphereck.viralinfectiontracker.reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsStorage {
    private List<CountryStatistics> countryStatisticsList;
    private List<StateStatistics> stateStatistics;

    public StatisticsStorage() {
        countryStatisticsList = Collections.synchronizedList(new ArrayList<>());
        stateStatistics = Collections.synchronizedList(new ArrayList<>());
    }

    public List<CountryStatistics> getCountryStatistics() {
        return this.countryStatisticsList;
    }

    public void setCountryStatisticsList(List<CountryStatistics> countryStatisticsList) {
        countryStatisticsList.add(0, this.getTotalCases(countryStatisticsList));
        this.countryStatisticsList.clear();
        this.countryStatisticsList.addAll(countryStatisticsList);
    }

    public List<StateStatistics> getStateStatistics() {
        return this.stateStatistics;
    }

    public void setStateStatistics(List<StateStatistics> stateStatistics) {
        this.stateStatistics.clear();
        this.stateStatistics.addAll(stateStatistics);
    }

    private CountryStatistics getTotalCases(List<CountryStatistics> statistics) {
        Integer totalCases = 0, totalDeaths = 0, totalRecovered = 0;
        Integer totalActiveCases = 0, totalCriticalCases = 0, totalTestsPerformed = 0;
        Double irrelevant = Double.valueOf(0);
        for(int i=0; i<statistics.size(); i++) {
            totalCases+= statistics.get(i).getTotalCases();
            totalDeaths+= statistics.get(i).getTotalDeaths();
            totalRecovered+= statistics.get(i).getTotalRecovered();
            totalActiveCases+= statistics.get(i).getTotalActiveCases();
            totalCriticalCases+= statistics.get(i).getTotalCriticalCases();
            totalTestsPerformed+= statistics.get(i).getTotalTestsPerformed();
        }
        return new CountryStatistics("Total", totalCases, totalDeaths, totalRecovered,
                totalActiveCases, totalCriticalCases, irrelevant, irrelevant, totalTestsPerformed, irrelevant);
    }
}
