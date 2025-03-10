package com.example.user.util;
/*
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;*/
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AliyunSmsUtil {

    // 发送短信
    public  void sendSms(String phoneNumber, String captcha) {
        // 阿里云短信服务配置
        String accessKeyId = "your-access-key-id";
        String accessKeySecret = "your-access-key-secret";
        String signName = "your-sign-name";
        String templateCode = "your-template-code";

        // 短信内容
        Map<String, String> params = new HashMap<>();
        params.put("code", captcha);

        // 构造请求
        String url = "https://dysmsapi.aliyuncs.com/";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + accessKeyId);
/*
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }

            // 构造请求体
            String requestBody = String.format(
                    "{\"PhoneNumbers\":\"%s\",\"SignName\":\"%s\",\"TemplateCode\":\"%s\",\"TemplateParam\":\"%s\"}",
                    phoneNumber, signName, templateCode, params
            );
            httpPost.setEntity(new StringEntity(requestBody));

            // 发送请求
            HttpResponse response = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("短信发送结果: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("短信发送失败！");
        }*/
    }
}
