//package com.example.apnicare.ModelResponses.ComfirmOrder;
//
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//public class Data {
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("order_number")
//    @Expose
//    private String orderNumber;
//    @SerializedName("order_type")
//    @Expose
//    private String orderType;
//    @SerializedName("discount")
//    @Expose
//    private Integer discount;
//    @SerializedName("discount_type")
//    @Expose
//    private String discountType;
//    @SerializedName("sub_total")
//    @Expose
//    private Integer subTotal;
//    @SerializedName("amount")
//    @Expose
//    private Integer amount;
//    @SerializedName("payment_mode")
//    @Expose
//    private String paymentMode;
//    @SerializedName("tax")
//    @Expose
//    private Integer tax;
//    @SerializedName("total")
//    @Expose
//    private Integer total;
//    @SerializedName("delivery_charge")
//    @Expose
//    private Integer deliveryCharge;
//    @SerializedName("paid")
//    @Expose
//    private Boolean paid;
//    @SerializedName("shipping_address")
//    @Expose
//    private ShippingAddress shippingAddress;
//    @SerializedName("billing_address")
//    @Expose
//    private BillingAddress billingAddress;
//    @SerializedName("prescriptions")
//    @Expose
//    private List<Prescription> prescriptions = null;
//    @SerializedName("status")
//    @Expose
//    private String status;
//    @SerializedName("detail")
//    @Expose
//    private List<Detail> detail = null;
//    @SerializedName("expected_delivery")
//    @Expose
//    private String expectedDelivery;
//    @SerializedName("delivered_at")
//    @Expose
//    private String deliveredAt;
//    @SerializedName("placed_at")
//    @Expose
//    private String placedAt;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getOrderNumber() {
//        return orderNumber;
//    }
//
//    public void setOrderNumber(String orderNumber) {
//        this.orderNumber = orderNumber;
//    }
//
//    public String getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(String orderType) {
//        this.orderType = orderType;
//    }
//
//    public Integer getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(Integer discount) {
//        this.discount = discount;
//    }
//
//    public String getDiscountType() {
//        return discountType;
//    }
//
//    public void setDiscountType(String discountType) {
//        this.discountType = discountType;
//    }
//
//    public Integer getSubTotal() {
//        return subTotal;
//    }
//
//    public void setSubTotal(Integer subTotal) {
//        this.subTotal = subTotal;
//    }
//
//    public Integer getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Integer amount) {
//        this.amount = amount;
//    }
//
//    public String getPaymentMode() {
//        return paymentMode;
//    }
//
//    public void setPaymentMode(String paymentMode) {
//        this.paymentMode = paymentMode;
//    }
//
//    public Integer getTax() {
//        return tax;
//    }
//
//    public void setTax(Integer tax) {
//        this.tax = tax;
//    }
//
//    public Integer getTotal() {
//        return total;
//    }
//
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//
//    public Integer getDeliveryCharge() {
//        return deliveryCharge;
//    }
//
//    public void setDeliveryCharge(Integer deliveryCharge) {
//        this.deliveryCharge = deliveryCharge;
//    }
//
//    public Boolean getPaid() {
//        return paid;
//    }
//
//    public void setPaid(Boolean paid) {
//        this.paid = paid;
//    }
//
//    public ShippingAddress getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(ShippingAddress shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    public BillingAddress getBillingAddress() {
//        return billingAddress;
//    }
//
//    public void setBillingAddress(BillingAddress billingAddress) {
//        this.billingAddress = billingAddress;
//    }
//
//    public List<Prescription> getPrescriptions() {
//        return prescriptions;
//    }
//
//    public void setPrescriptions(List<Prescription> prescriptions) {
//        this.prescriptions = prescriptions;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<Detail> getDetail() {
//        return detail;
//    }
//
//    public void setDetail(List<Detail> detail) {
//        this.detail = detail;
//    }
//
//    public String getExpectedDelivery() {
//        return expectedDelivery;
//    }
//
//    public void setExpectedDelivery(String expectedDelivery) {
//        this.expectedDelivery = expectedDelivery;
//    }
//
//    public String getDeliveredAt() {
//        return deliveredAt;
//    }
//
//    public void setDeliveredAt(String deliveredAt) {
//        this.deliveredAt = deliveredAt;
//    }
//
//    public String getPlacedAt() {
//        return placedAt;
//    }
//
//    public void setPlacedAt(String placedAt) {
//        this.placedAt = placedAt;
//    }
//
//}
