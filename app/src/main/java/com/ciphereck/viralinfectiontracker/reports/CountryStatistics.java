package com.ciphereck.viralinfectiontracker.reports;

import com.google.gson.annotations.SerializedName;

public class CountryStatistics {
    @SerializedName("country")
    private String countryName;
    @SerializedName("cases")
    private Integer totalCases;
    @SerializedName("deaths")
    private Integer totalDeaths;
    @SerializedName("recovered")
    private Integer totalRecovered;
    @SerializedName("active")
    private Integer totalActiveCases;
    @SerializedName("critical")
    private Integer totalCriticalCases;
    @SerializedName("casesPerOneMillion")
    private Double casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    private Double deathsPerOneMillion;
    @SerializedName("tests")
    private Integer totalTestsPerformed;
    @SerializedName("testsPerOneMillion")
    private Double testsPerOneMillion;


    public CountryStatistics(String countryName, Integer totalCases, Integer totalDeaths, Integer totalRecovered,
                             Integer totalActiveCases, Integer totalCriticalCases, Double casesPerOneMillion,
                             Double deathsPerOneMillion, Integer totalTestsPerformed, Double testsPerOneMillion) {
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
        this.totalActiveCases = totalActiveCases;
        this.totalCriticalCases = totalCriticalCases;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.totalTestsPerformed = totalTestsPerformed;
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public Integer getTotalActiveCases() {
        return totalActiveCases;
    }

    public Integer getTotalCriticalCases() {
        return totalCriticalCases;
    }

    public Double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public Double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public Integer getTotalTestsPerformed() {
        return totalTestsPerformed;
    }

    public Double getTestsPerOneMillion() {
        return testsPerOneMillion;
    }
}
