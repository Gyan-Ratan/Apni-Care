package com.example.apnicare;

import java.security.PublicKey;

public class CartManager {
    public CartManager(String itemName, int qty, String slug, Double price, Double mrp) {
        this.itemName = itemName;
        this.qty = qty;
        this.slug = slug;
        this.price = price;
        this.mrp = mrp;
    }

    public String itemName;
    public int qty;
    public String slug;
    public Double price;

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Double mrp;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
