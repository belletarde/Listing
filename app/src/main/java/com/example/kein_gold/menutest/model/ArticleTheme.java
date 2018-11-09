package com.example.kein_gold.menutest.model;

import com.google.gson.annotations.SerializedName;

public class ArticleTheme {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;

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
}
