package com.example.user.listener;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.user.dto.RegisterMessageDTO;
import com.example.user.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RegisterMessageListener {

    @Autowired
    private EmailUtil emailUtil;

    //@RabbitListener(queues = "captcha-queue")
    @JmsListener(destination = "register-queue")
    public void handleMessage(String message) {
        RegisterMessageDTO registerMessageDTO= JSON.parseObject(message, RegisterMessageDTO.class);
        // 发送邮件
        if(!StringUtils.isBlank(registerMessageDTO.getEmail())){
            emailUtil.sendEmail(registerMessageDTO.getEmail(), registerMessageDTO.getMessage(),"注册");
        }
    }
}