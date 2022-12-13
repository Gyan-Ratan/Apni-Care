package com.example.apnicare.ModelResponses.LoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
//    String first_name,last_name,type,email,phone,gender,address,retail,access_token, refresh_token;
//    Boolean email_verified,verified,has_password,new_user;
//
//
//
//    public Data(String first_name, String last_name, String type, String email, String phone, String gender, Boolean email_verified, Boolean verified, String address,Boolean has_password,  String retail, String access_token, String refresh_token, Boolean new_user) {
//
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.type = type;
//        this.email = email;
//        this.phone = phone;
//        this.gender = gender;
//        this.address = address;
//        this.retail = retail;
//        this.access_token = access_token;
//        this.refresh_token = refresh_token;
//        this.email_verified = email_verified;
//        this.verified = verified;
//        this.has_password = has_password;
//        this.new_user = new_user;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getRetail() {
//        return retail;
//    }
//
//    public void setRetail(String retail) {
//        this.retail = retail;
//    }
//
//    public String getAccess_token() {
//        return access_token;
//    }
//
//    public void setAccess_token(String access_token) {
//        this.access_token = access_token;
//    }
//
//    public String getRefresh_token() {
//        return refresh_token;
//    }
//
//    public void setRefresh_token(String refresh_token) {
//        this.refresh_token = refresh_token;
//    }
//
//    public Boolean getEmail_verified() {
//        return email_verified;
//    }
//
//    public void setEmail_verified(Boolean email_verified) {
//        this.email_verified = email_verified;
//    }
//
//    public Boolean getVerified() {
//        return verified;
//    }
//
//    public void setVerified(Boolean verified) {
//        this.verified = verified;
//    }
//
//    public Boolean getHas_password() {
//        return has_password;
//    }
//
//    public void setHas_password(Boolean has_password) {
//        this.has_password = has_password;
//    }
//
//    public Boolean getNew_user() {
//        return new_user;
//    }
//
//    public void setNew_user(Boolean new_user) {
//        this.new_user = new_user;
//    }
    //    String phone,access_token;
//    int otp;
//
//    public Data( String access_token,String phone, int otp) {
//        this.phone = phone;
//        this.access_token = access_token;
//        this.otp = otp;
//    }
//
//    public String getAccess_token() {
//        return access_token;
//    }
//
//    public void setAccess_token(String access_token) {
//        this.access_token = access_token;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public int getOtp() {
//        return otp;
//    }
//
//    public void setOtp(int otp) {
//        this.otp = otp;
//    }

    @SerializedName("first_name")
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
    private Address address;
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
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("refresh_token")
    String refreshToken;
    @SerializedName("new_user")
    @Expose
    private Boolean newUser;

    public Data(String accessToken, String  firstName, String lastName, String type, String email, String phone, String gender, Boolean emailVerified, Boolean verified, Boolean hasPassword, String retail, String refreshToken, Boolean newUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.emailVerified = emailVerified;
        this.verified = verified;
        this.address = address;
        this.hasPassword = hasPassword;
        this.retail = retail;
        this.form20 = form20;
        this.form21 = form21;
        this.foodLicense = foodLicense;
        this.gstin = gstin;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.newUser = newUser;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String  getLastName() {
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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Boolean getNewUser() {
        return newUser;
    }

    public void setNewUser(Boolean newUser) {
        this.newUser = newUser;
    }

}

