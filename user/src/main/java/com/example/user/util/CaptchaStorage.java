package com.example.user.util;


import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CaptchaStorage {

    @Autowired
    private RedissonClient redissonClient;

    private static final int CAPTCHA_EXPIRE_TIME = 60; // 验证码过期时间，单位为秒

    // 存储验证码
    public  void storeCaptcha(String key, String captcha) {
        try {
            RBucket<Object> bucket = redissonClient.getBucket(key);
            bucket.set(captcha, CAPTCHA_EXPIRE_TIME, TimeUnit.SECONDS);
            System.out.println("验证码存储成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("验证码存储失败！");
        }
    }

    // 获取验证码
    public  String getCaptcha(String key) {
        try{
            RBucket<String> bucket = redissonClient.getBucket(key);
            String value = bucket.get();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
