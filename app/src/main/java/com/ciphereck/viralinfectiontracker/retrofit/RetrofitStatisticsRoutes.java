package com.ciphereck.viralinfectiontracker.retrofit;

import com.ciphereck.viralinfectiontracker.reports.CountryStatistics;
import com.google.gson.JsonElement;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface RetrofitStatisticsRoutes {
    @GET("https://corona.lmao.ninja/countries")
    Observable<List<CountryStatistics>> getCountryStatistics();

    @GET("https://api.covid19india.org/data.json")
    Observable<JsonElement> getStateStatistics();
}
