package com.example.kein_gold.menutest.api;

import com.example.kein_gold.menutest.model.ArticleDetail;
import com.example.kein_gold.menutest.model.ResponseArticlePagination;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArticleApi {

    @GET("/api/v1/article/2?page=1&limit=1021")
    Single<ResponseArticlePagination> getArticleList();

    @GET("/api/v1/article/detail/{articleId}")
    Single<ArticleDetail> getArticleDetail(@Path("articleId") long articleId);

}
