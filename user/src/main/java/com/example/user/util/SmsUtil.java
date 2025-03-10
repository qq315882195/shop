package com.example.user.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SmsUtil {

    @Autowired
    private TwilioSmsUtil twilioSmsUtil;
    @Autowired
    private AliyunSmsUtil aliyunSmsUtil;

    // 发送短信
    public  void sendSms(String phoneNumber, String captcha) {
        //aliyunSmsUtil.sendSms(phoneNumber, captcha);
        //twilioSmsUtil.sendSms(phoneNumber, captcha);
    }
}
