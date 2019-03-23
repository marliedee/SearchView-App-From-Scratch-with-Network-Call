package org.pursuit.searchviewappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StatesRetrofitSingleton {

    private static Retrofit statesInstance;

    public static Retrofit getInstance() {
        if (statesInstance != null) {
            return statesInstance;
        }
        statesInstance = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return statesInstance;
    }

    private StatesRetrofitSingleton() {
    }
}
