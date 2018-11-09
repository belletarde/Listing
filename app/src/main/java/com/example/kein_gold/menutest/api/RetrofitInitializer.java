package com.example.kein_gold.menutest.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializer {

    private Retrofit retrofit;

    public RetrofitInitializer() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://sva.gold360.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ArticleApi articleApi() {
        return retrofit.create(ArticleApi.class);
    }
}
