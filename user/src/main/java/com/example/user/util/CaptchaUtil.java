package com.example.user.util;

import java.util.Random;

public class CaptchaUtil {

    // 生成 6 位随机数字验证码
    public static String generateCaptcha() {
        Random random = new Random();
        int captcha = 100000 + random.nextInt(900000); // 生成 100000 到 999999 之间的随机数
        return String.valueOf(captcha);
    }
}
