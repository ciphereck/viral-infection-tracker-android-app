package com.ciphereck.viralinfectiontracker.retrofit.statistics;


import com.ciphereck.viralinfectiontracker.reports.StatisticsClientInstance;
import com.ciphereck.viralinfectiontracker.retrofit.RetrofitClientInstance;
import com.ciphereck.viralinfectiontracker.retrofit.RetrofitStatisticsRoutes;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RetrofitStatisticsHelper {
    public static void updateCountryStatistics() {
        RetrofitClientInstance
                .getInstance()
                .create(RetrofitStatisticsRoutes.class)
                .getCountryStatistics()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((countryStatistics) -> StatisticsClientInstance.getInstance()
                                                        .setCountryStatisticsList(countryStatistics));
    }
}
