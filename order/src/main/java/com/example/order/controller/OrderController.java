package com.example.order.controller;


import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderQuery;
import com.example.order.sevice.OrderService;
import com.example.order.vo.OrderVO;
import com.example.order.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/getOrderPage")
    public Result getOrderPage(@RequestBody OrderQuery orderQuery){
        List<OrderVO> orderList=orderService.getOrderPage(orderQuery);
        return Result.success(orderList);
    }


    @RequestMapping("/getOrderById")
    public Result getOrderById(@RequestBody OrderDTO orderDTO){
        OrderVO orderVO=orderService.getOrderById(orderDTO);
        return Result.success(orderVO);
    }

    @RequestMapping("/createOrder")
    public Result createOrder(@RequestBody OrderDTO orderDTO){
        boolean result=orderService.createOrder(orderDTO);
        return Result.success(result);
    }

}
