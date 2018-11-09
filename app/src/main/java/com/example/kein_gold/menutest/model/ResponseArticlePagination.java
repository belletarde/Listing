package com.example.kein_gold.menutest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseArticlePagination {

    @SerializedName("items")
    @Expose
    private List<ArticleListDetail> items;

    public ResponseArticlePagination() {

    }

    public List<ArticleListDetail> getItems() {
        return items;
    }

    public void setItems(List<ArticleListDetail> items) {
        this.items = items;
    }
}
