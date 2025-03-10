package com.example.user.util;


import org.springframework.stereotype.Component;

@Component
public class TwilioSmsUtil {

    // Twilio 账号信息
    /*@Value("${twilio.accountSid}")
    private String ACCOUNT_SID;
    @Value("${twilio.authToken}")
    private String AUTH_TOKEN;*/

    // 发送短信
    /*public void sendSms(String toPhoneNumber, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
                new PhoneNumber(toPhoneNumber), // 接收者号码
                new PhoneNumber("your-twilio-phone-number"), // Twilio 提供的号码
                message // 短信内容
        ).create();

        System.out.println("短信发送成功！");
    }*/
}
