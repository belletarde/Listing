package com.example.kein_gold.menutest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleListDetail {

    @Expose
    @SerializedName("id")
    private long id;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("short_title")
    private String shortTitle;
    /*@Expose
    @SerializedName("image")
    private ArticleImage imageUrl;*/
    @SerializedName("image")
    private String imageUrl;
    @Expose
    @SerializedName("type_title")
    private String articleType;
    @Expose
    @SerializedName("themes")
    private List<ArticleTheme> articleThemeList;
    @Expose
    @SerializedName("body")
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

//    public ArticleImage getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(ArticleImage imageUrl) {
//        this.imageUrl = imageUrl;
//    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public List<ArticleTheme> getArticleThemeList() {
        return articleThemeList;
    }

    public void setArticleThemeList(List<ArticleTheme> articleThemeList) {
        this.articleThemeList = articleThemeList;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
