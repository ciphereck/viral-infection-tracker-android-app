package com.ciphereck.viralinfectiontracker.reports;

public class StatisticsClientInstance {
    private static volatile StatisticsStorage statisticsStorage;

    private StatisticsClientInstance() {
        if(statisticsStorage != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static StatisticsStorage getInstance() {
        if(statisticsStorage == null) {
            synchronized (StatisticsStorage.class) {
                if(statisticsStorage == null) {
                    statisticsStorage = new StatisticsStorage();
                }
            }
        }
        return statisticsStorage;
    }
}
