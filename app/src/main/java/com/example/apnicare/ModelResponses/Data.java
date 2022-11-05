package com.example.apnicare.ModelResponses;

public class Data {
    String phone,access_token;
    int otp;

    public Data(String phone, String access_token, int otp) {
        this.phone = phone;
        this.access_token = access_token;
        this.otp = otp;
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
}
