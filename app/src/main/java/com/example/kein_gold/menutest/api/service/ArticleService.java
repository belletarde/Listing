package com.example.kein_gold.menutest.api.service;

import android.util.Log;

import com.example.kein_gold.menutest.api.RetrofitInitializer;
import com.example.kein_gold.menutest.model.ArticleDetail;
import com.example.kein_gold.menutest.model.ResponseArticlePagination;
import com.example.kein_gold.menutest.utils.RxFunctions;

import io.reactivex.Single;

public class ArticleService {

    private RetrofitInitializer retrofitInitializer;

    public ArticleService() {}

    public Single<ArticleDetail> getArticleById(long id) {
        retrofitInitializer = new RetrofitInitializer();
        return retrofitInitializer
                .articleApi()
                .getArticleDetail(id)
                .compose(RxFunctions.applySingleSchedulers())
                .doOnError( throwable -> Log.e("ERROR", ""));
    }

    public Single<ResponseArticlePagination> getArticleList() {
        retrofitInitializer = new RetrofitInitializer();
        return retrofitInitializer
                .articleApi()
                .getArticleList()
                .compose(RxFunctions.applySingleSchedulers())
                .doOnError(throwable -> Log.e("ERROR", ""));
    }
}
