package com.ciphereck.viralinfectiontracker.retrofit.statistics;


import com.ciphereck.viralinfectiontracker.reports.StateStatistics;
import com.ciphereck.viralinfectiontracker.reports.StatisticsClientInstance;
import com.ciphereck.viralinfectiontracker.retrofit.RetrofitClientInstance;
import com.ciphereck.viralinfectiontracker.retrofit.RetrofitStatisticsRoutes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RetrofitStatisticsHelper {
    public static void updateCountryStatistics() {
        RetrofitClientInstance
                .getInstance()
                .create(RetrofitStatisticsRoutes.class)
                .getCountryStatistics()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((countryStatistics) -> StatisticsClientInstance.getInstance()
                                                        .setCountryStatisticsList(countryStatistics));
    }

    public static void updateStateStatistics() {
        RetrofitClientInstance
                .getInstance()
                .create(RetrofitStatisticsRoutes.class)
                .getStateStatistics()
                .map((data) -> data.getAsJsonObject().get("statewise"))
                .map(RetrofitStatisticsHelper::convertJsonElementToStateStatisticsList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(((stateStatistics -> StatisticsClientInstance.getInstance().setStateStatistics(stateStatistics))));
    }

    public static List<StateStatistics> convertJsonElementToStateStatisticsList(JsonElement jsonElement) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<StateStatistics>>(){}.getType();
        return gson.fromJson(jsonElement, type);
    }
}
