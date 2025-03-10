package com.example.user.controller;

import com.alibaba.fastjson.JSON;
import com.example.user.dto.CaptchaMessageDTO;
import com.example.user.enums.ChatErrorEnum;
import com.example.user.response.Result;
import com.example.user.util.CaptchaStorage;
import com.example.user.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
/*
    @Autowired
    private RabbitTemplate rabbitTemplate;*/

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private CaptchaStorage captchaStorage;

    /**
     * 获取验证码
     * @param captchaMessageDTO
     * @return
     */
    @PostMapping("/getCaptcha")
    public Result getCaptcha(@RequestBody CaptchaMessageDTO captchaMessageDTO) {
        // 生成验证码
        String captcha = CaptchaUtil.generateCaptcha();

        // 存储验证码
        String email = captchaMessageDTO.getEmail();
        String phone = captchaMessageDTO.getPhone();
        captchaStorage.storeCaptcha(email, captcha);
        captchaStorage.storeCaptcha(phone, captcha);

        // 发送消息到 RabbitMQ,异步去处理发送邮件和短信(由于windows环境安装rabbit比较麻烦，使用activemq代替)
        CaptchaMessageDTO message = new CaptchaMessageDTO(email, phone, captcha);
        //rabbitTemplate.convertAndSend("captcha-exchange", "captchaKey", message);
        jmsTemplate.convertAndSend("captcha-queue", JSON.toJSONString(message));
        return Result.success();
    }

    /**
     * 验证验证码
     * @param captchaMessageDTO
     * @return
     */
    @PostMapping("/verifyCaptcha")
    public Result verifyCaptcha(@RequestBody CaptchaMessageDTO captchaMessageDTO) {
        String storedCaptcha = captchaStorage.getCaptcha(captchaMessageDTO.getPhone());
        if (storedCaptcha != null){
             storedCaptcha = captchaStorage.getCaptcha(captchaMessageDTO.getEmail());
        }
        if (storedCaptcha == null) {
            return Result.error(ChatErrorEnum.CAPTCHA_ERROR.getDesc(), ChatErrorEnum.CAPTCHA_ERROR.getCode());
        }
        if (storedCaptcha != null && !storedCaptcha.equals(captchaMessageDTO.getCaptcha())) {
            return Result.error(ChatErrorEnum.CAPTCHA_ERROR.getDesc(), ChatErrorEnum.CAPTCHA_ERROR.getCode());
        }
        return Result.success();
    }
}
