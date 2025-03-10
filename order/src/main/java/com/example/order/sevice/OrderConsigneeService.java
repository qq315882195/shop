package com.example.order.sevice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.mapper.OrderConsigneeMapper;
import com.example.order.pojo.OrderConsignee;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderConsigneeService extends ServiceImpl<OrderConsigneeMapper, OrderConsignee> {
    @Resource
    private OrderConsigneeMapper orderConsigneeMapper;
}
