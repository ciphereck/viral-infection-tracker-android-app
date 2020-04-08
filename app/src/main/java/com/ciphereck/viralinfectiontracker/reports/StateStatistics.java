package com.ciphereck.viralinfectiontracker.reports;

import com.google.gson.annotations.SerializedName;

public class StateStatistics {
    @SerializedName("state")
    private String stateName;
    @SerializedName("statecode")
    private String stateCode;
    @SerializedName("confirmed")
    private Integer totalCases;
    @SerializedName("deaths")
    private Integer totalDeaths;
    @SerializedName("recovered")
    private Integer totalRecovered;
    @SerializedName("active")
    private Integer totalActiveCases;

    public StateStatistics(String stateName, String stateCode, Integer totalCases, Integer totalDeaths, Integer totalRecovered,
                           Integer totalActiveCases) {
        this.stateName = stateName;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
        this.totalActiveCases = totalActiveCases;
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
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
}
