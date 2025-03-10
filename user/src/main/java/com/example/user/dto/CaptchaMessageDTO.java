package com.example.user.dto;

import java.io.Serializable;

public class CaptchaMessageDTO  implements Serializable {
    private String email;
    private String phone;
    private String captcha;

    // 构造函数、getter 和 setter
    public CaptchaMessageDTO(String email, String phone, String captcha) {
        this.email = email;
        this.phone = phone;
        this.captcha = captcha;
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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
