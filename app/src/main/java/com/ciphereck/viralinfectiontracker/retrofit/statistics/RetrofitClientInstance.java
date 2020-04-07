package com.ciphereck.viralinfectiontracker.retrofit.statistics;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static volatile Retrofit retrofit;

    private RetrofitClientInstance() {
        if(retrofit != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Retrofit getInstance() {
        if(retrofit == null) {
            synchronized (Retrofit.class) {
                if(retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl("http://localhost/")
                            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        
        return retrofit;
    }
}
