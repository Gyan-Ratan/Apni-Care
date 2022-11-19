package com.example.apnicare.myCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddItemResponse {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("cart_id")
        @Expose
        private int cartId;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("quantity")
        @Expose
        private int quantity;

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}}
