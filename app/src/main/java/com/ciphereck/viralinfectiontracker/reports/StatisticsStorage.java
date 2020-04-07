package com.ciphereck.viralinfectiontracker.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StatisticsStorage {
    private List<CountryStatistics> countryStatisticsList;

    public StatisticsStorage() {
        countryStatisticsList = Collections.synchronizedList(new ArrayList<>());
    }

    public List<CountryStatistics> getCountryStatistics() {
        return this.countryStatisticsList;
    }

    public void setCountryStatisticsList(List<CountryStatistics> countryStatisticsList) {
        countryStatisticsList.add(0, getTotalCases(countryStatisticsList));
        this.countryStatisticsList.clear();
        this.countryStatisticsList.addAll(countryStatisticsList);
    }

    public CountryStatistics getTotalCases(List<CountryStatistics> countryStatistics) {
        Integer totalCases = 0, totalDeaths = 0, totalRecovered = 0;
        Integer totalActiveCases = 0, totalCriticalCases = 0, totalTestsPerformed = 0;
        Double irrevant = Double.valueOf(0);
        for(int i=0; i<countryStatisticsList.size(); i++) {
            totalCases+= countryStatisticsList.get(i).getTotalCases();
            totalDeaths+= countryStatisticsList.get(i).getTotalDeaths();
            totalRecovered+= countryStatisticsList.get(i).getTotalRecovered();
            totalRecovered+= countryStatisticsList.get(i).getTotalRecovered();
            totalActiveCases+= countryStatisticsList.get(i).getTotalActiveCases();
            totalCriticalCases+= countryStatisticsList.get(i).getTotalCriticalCases();
            totalTestsPerformed+= countryStatisticsList.get(i).getTotalTestsPerformed();
        }
        return new CountryStatistics("Total", totalCases, totalDeaths, totalRecovered,
                totalActiveCases, totalCriticalCases, irrevant, irrevant, totalTestsPerformed, irrevant);
    }
}
