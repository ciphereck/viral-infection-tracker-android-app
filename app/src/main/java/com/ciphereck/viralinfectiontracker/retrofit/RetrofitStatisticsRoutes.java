package com.ciphereck.viralinfectiontracker.retrofit;

import com.ciphereck.viralinfectiontracker.reports.CountryStatistics;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface RetrofitStatisticsRoutes {
    @GET("https://corona.lmao.ninja/countries")
    Observable<List<CountryStatistics>> getCountryStatistics();
}
