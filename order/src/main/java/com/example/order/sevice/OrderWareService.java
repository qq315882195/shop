package com.example.order.sevice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.mapper.OrderWareMapper;
import com.example.order.pojo.OrderWare;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderWareService extends ServiceImpl<OrderWareMapper, OrderWare> {

    @Resource
    private OrderWareMapper orderWareMapper;
}
