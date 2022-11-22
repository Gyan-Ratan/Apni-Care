package com.example.apnicare.ModelResponses.Search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("page")
    private int page;
    @SerializedName("pages")
    private int pages;
    @SerializedName("total")
    private int total;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("next_num")
    private int nextNum;
    @SerializedName("prev_num")
    private String prevNum;
    @SerializedName("has_next")
    private Boolean hasNext;
    @SerializedName("has_prev")
    private Boolean hasPrev;
    @SerializedName("items")
    private List<items> items = null;
    @SerializedName("filters")
    private List<Object> filters = null;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getNextNum() {
        return nextNum;
    }

    public void setNextNum(int nextNum) {
        this.nextNum = nextNum;
    }

    public String getPrevNum() {
        return prevNum;
    }

    public void setPrevNum(String prevNum) {
        this.prevNum = prevNum;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(Boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public List<items> getItems() {
        return items;
    }

    public void setItems(List<items> items) {
        this.items = items;
    }

    public List<Object> getFilters() {
        return filters;
    }

    public void setFilters(List<Object> filters) {
        this.filters = filters;
    }

}

