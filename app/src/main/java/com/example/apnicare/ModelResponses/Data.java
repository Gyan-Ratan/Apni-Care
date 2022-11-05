package com.example.apnicare.ModelResponses;

public class Data {


    
    String phone;
    String access_token;
    String refresh_token;
    int otp;

    public Data( String access_token,String phone, int otp, String refresh_token) {
        this.phone = phone;
        this.access_token = access_token;
        this.otp = otp;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
