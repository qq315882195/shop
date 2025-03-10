package com.example.order.sevice;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.order.converter.OrderConsigneeConverter;
import com.example.order.converter.OrderConverter;
import com.example.order.converter.OrderWareConverter;
import com.example.order.dto.*;
import com.example.order.enums.OrderErrorEnum;
import com.example.order.exception.BusinessException;
import com.example.order.mapper.OrderMapper;
import com.example.order.pojo.Order;
import com.example.order.pojo.OrderConsignee;
import com.example.order.pojo.OrderWare;
import com.example.order.vo.OrderVO;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderWareService orderWareService;

    @Resource
    private OrderConsigneeService orderConsigneeService;

    @Autowired
    private JmsTemplate jmsTemplate;

    public List<OrderVO> getOrderList(OrderDTO orderDTO) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getStoreId, orderDTO.getStoreId());
        queryWrapper.eq(!StringUtils.isEmpty(orderDTO.getOrderNo()),Order::getOrderNo, orderDTO.getOrderNo());
        queryWrapper.eq(orderDTO.getOrderStatus()!=null,Order::getOrderStatus, orderDTO.getOrderStatus());

        List<Order> orders = orderMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(orders)){
            return null;
        }
        List<OrderVO> orderList = Lists.newArrayList();
        orders.forEach(order -> {
            //转换为OrderVO
            orderList.add(OrderConverter.toVO(order));
        });
        return orderList;
    }

    public OrderVO getOrderById(OrderDTO orderDTO) {
        Order order = orderMapper.selectById(orderDTO.getId());
        if (order == null) {
            throw new BusinessException(OrderErrorEnum.ORDER_NOT_EXIST.getDesc(), OrderErrorEnum.ORDER_NOT_EXIST.getCode());
        }
        String orderNo = order.getOrderNo();
        OrderVO orderVO = OrderConverter.toVO(order);
        //查询订单商品信息
        List<OrderWare> orderWares = orderWareService.list(new LambdaQueryWrapper<OrderWare>().eq(OrderWare::getOrderNo, orderNo));
        orderVO.setOrderWareVOS(OrderWareConverter.toVOList(orderWares));
        //查询订单收货人信息
        OrderConsignee orderConsignee = orderConsigneeService.getOne(new LambdaQueryWrapper<OrderConsignee>().eq(OrderConsignee::getOrderNo, orderNo),false);
        if (orderConsignee != null) {
            orderVO.setOrderConsigneeVO(OrderConsigneeConverter.toVO(orderConsignee));
        }
        return orderVO;
    }

    public boolean createOrder(OrderDTO orderDTO) {
        Order order = OrderConverter.toPO(orderDTO);
        orderMapper.insert(order);
        OrderMessageDTO orderMessageDTO =OrderConverter.toMessageDTO(order);

        List<OrderWareDTO> orderWareList = orderDTO.getOrderWareList();
        if (!CollectionUtils.isEmpty(orderWareList)){
            List<OrderWare> orderWares=Lists.newArrayList();
            orderWareList.forEach(orderWareDTO -> {
                OrderWare orderWare = OrderWareConverter.toPO(orderWareDTO);
                orderWare.setOrderNo(order.getOrderNo());
                orderWares.add(orderWare);
            });
            orderWareService.saveBatch(orderWares);
            List<OrderWareMessageDTO> orderWareMessageDTOS=OrderWareConverter.toMessageDTO(orderWares);
            orderMessageDTO.setOrderWareMessageDTOS(orderWareMessageDTOS);
        }
        if (orderDTO.getOrderConsigneeDTO()!=null){
            OrderConsignee orderConsignee = OrderConsigneeConverter.toPO(orderDTO.getOrderConsigneeDTO());
            orderConsigneeService.save(orderConsignee);
            orderMessageDTO.setOrderConsigneeDTO(OrderConsigneeConverter.toMessageDTO(orderConsignee));
        }
        try {
            //发送消息，异步写入es
            jmsTemplate.convertAndSend("order-create-queue", JSON.toJSONString(orderMessageDTO));
        }catch (Exception e){
            log.error("发送写入es消息失败",e);
        }
        return true;
    }
}
