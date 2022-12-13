package com.example.apnicare.ModelResponses.UpdateUser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("email_verified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("has_password")
    @Expose
    private Boolean hasPassword;
    @SerializedName("retail")
    @Expose
    private String retail;
    @SerializedName("form_20")
    @Expose
    private List<String> form20 = null;
    @SerializedName("form_21")
    @Expose
    private List<String> form21 = null;
    @SerializedName("food_license")
    @Expose
    private List<String> foodLicense = null;
    @SerializedName("gstin")
    @Expose
    private List<String> gstin = null;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(Boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getRetail() {
        return retail;
    }

    public void setRetail(String retail) {
        this.retail = retail;
    }

    public List<String> getForm20() {
        return form20;
    }

    public void setForm20(List<String> form20) {
        this.form20 = form20;
    }

    public List<String> getForm21() {
        return form21;
    }

    public void setForm21(List<String> form21) {
        this.form21 = form21;
    }

    public List<String> getFoodLicense() {
        return foodLicense;
    }

    public void setFoodLicense(List<String> foodLicense) {
        this.foodLicense = foodLicense;
    }

    public List<String> getGstin() {
        return gstin;
    }

    public void setGstin(List<String> gstin) {
        this.gstin = gstin;
    }
}
