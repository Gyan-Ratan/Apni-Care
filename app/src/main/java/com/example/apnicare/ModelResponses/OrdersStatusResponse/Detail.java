package com.example.apnicare.ModelResponses.OrdersStatusResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detail {
    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("next_num")
    @Expose
    private int nextNum;
    @SerializedName("prev_num")
    @Expose
    private int prevNum;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("has_prev")
    @Expose
    private Boolean hasPrev;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
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

    public int getPrevNum() {
        return prevNum;
    }

    public void setPrevNum(int prevNum) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
