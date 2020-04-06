package com.ciphereck.viralinfectiontracker.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StatisticsStorage {
    private Collection<CountryStatistics> countryStatisticsList;

    public StatisticsStorage() {
        countryStatisticsList = Collections.synchronizedCollection(new ArrayList<>());
    }

    public Collection<CountryStatistics> getCountryStatistics() {
        return this.countryStatisticsList;
    }

    public void setCountryStatisticsList(List<CountryStatistics> countryStatisticsList) {
        this.countryStatisticsList.clear();
        this.countryStatisticsList.addAll(countryStatisticsList);
    }
}
