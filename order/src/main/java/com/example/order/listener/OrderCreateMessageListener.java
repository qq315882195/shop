package com.example.order.listener;


import com.alibaba.fastjson.JSON;
import com.example.order.dto.OrderMessageDTO;
import com.example.order.sevice.EsOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderCreateMessageListener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private EsOptionService esOptionService;

    @JmsListener(destination = "order.create.queue")
    public void handleMessage(String message) {
        OrderMessageDTO orderMessageDTO= JSON.parseObject(message,OrderMessageDTO.class);

        //写入ES
        esOptionService.addOrderToEs(orderMessageDTO);
    }
}
