package com.example.apnicare.ModelResponses.OrdersStatusResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("discount")
    @Expose
    private double discount;
    @SerializedName("discount_type")
    @Expose
    private String discountType;
    @SerializedName("discount_amount")
    @Expose
    private double discountAmount;
    @SerializedName("sub_total")
    @Expose
    private Double subTotal;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("tax")
    @Expose
    private Double tax;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("delivery_charge")
    @Expose
    private int deliveryCharge;
    @SerializedName("paid")
    @Expose
    private Boolean paid;
    @SerializedName("shipping_address")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("billing_address")
    @Expose
    private BillingAddress billingAddress;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("detail")
    @Expose
    private List<Detail> detail = null;
    @SerializedName("expected_delivery")
    @Expose
    private String expectedDelivery;
    @SerializedName("delivered_at")
    @Expose
    private String deliveredAt;
    @SerializedName("placed_at")
    @Expose
    private String placedAt;
    @SerializedName("rated")
    @Expose
    private Boolean rated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }


    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    public String getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(String expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(String deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public String getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(String placedAt) {
        this.placedAt = placedAt;
    }

    public Boolean getRated() {
        return rated;
    }

    public void setRated(Boolean rated) {
        this.rated = rated;
    }
}
