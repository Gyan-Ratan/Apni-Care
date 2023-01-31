package com.example.apnicare;

import java.security.PublicKey;

public class CartManager {
    public String itemName;
    public int qty;
    public String slug;
    public Double price;

    public CartManager(String itemName, int qty, String slug, Double price) {
        this.itemName = itemName;
        this.qty = qty;
        this.slug = slug;
        this.price = price;
    }
}
