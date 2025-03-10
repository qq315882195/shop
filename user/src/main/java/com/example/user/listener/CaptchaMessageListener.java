package com.example.user.listener;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.user.dto.CaptchaMessageDTO;
import com.example.user.util.EmailUtil;
import com.example.user.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CaptchaMessageListener {

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private SmsUtil smsUtil;

    //@RabbitListener(queues = "captcha-queue")
    @JmsListener(destination = "captcha-queue")
    public void handleMessage(String message) {
        CaptchaMessageDTO captchaMessageDTO= JSON.parseObject(message, CaptchaMessageDTO.class);
        // 发送邮件
        if(!StringUtils.isBlank(captchaMessageDTO.getEmail())){
            String captcha="您的验证码是: " + captchaMessageDTO.getCaptcha() + "，请勿泄露给他人";
            emailUtil.sendEmail(captchaMessageDTO.getEmail(), captcha,"验证码");
        }

        // 发送短信
        /*if(!StringUtils.isBlank(captchaMessageDTO.getPhoneNumber())) {
            smsUtil.sendSms(captchaMessageDTO.getPhoneNumber(), captchaMessageDTO.getCaptcha());
        }*/
    }
}