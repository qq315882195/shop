package com.example.order.converter;


import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderMessageDTO;
import com.example.order.pojo.Order;
import com.example.order.vo.OrderVO;

public class OrderConverter {

    /**
     * DTO转换成POJO
     */
    public static Order toPO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNo(orderDTO.getOrderNo());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setAmount(orderDTO.getAmount());
        order.setStoreCode(orderDTO.getStoreCode());
        order.setStoreId(orderDTO.getStoreId());
        order.setStoreName(orderDTO.getStoreName());
        return order;
    }

    /**
     * POJO转换成VO
     */
    public static OrderVO toVO(Order order) {
        OrderVO orderVO = new OrderVO();
        orderVO.setAmount(order.getAmount());
        orderVO.setOrderNo(order.getOrderNo());
        orderVO.setOrderStatus(order.getOrderStatus());
        orderVO.setId(order.getId());
        orderVO.setStoreCode(order.getStoreCode());
        orderVO.setStoreId(order.getStoreId());
        orderVO.setStoreName(order.getStoreName());
        orderVO.setCreated(order.getCreated());
        orderVO.setUpdated(order.getUpdated());
        return orderVO;
    }

    public static OrderMessageDTO toMessageDTO(Order order) {
        OrderMessageDTO orderMessageDTO = new OrderMessageDTO();
        orderMessageDTO.setAmount(order.getAmount());
        orderMessageDTO.setOrderNo(order.getOrderNo());
        orderMessageDTO.setOrderStatus(order.getOrderStatus());
        orderMessageDTO.setId(order.getId());
        orderMessageDTO.setStoreCode(order.getStoreCode());
        orderMessageDTO.setStoreId(order.getStoreId());
        orderMessageDTO.setStoreName(order.getStoreName());
        orderMessageDTO.setCreated(order.getCreated());
        orderMessageDTO.setUpdated(order.getUpdated());
        return orderMessageDTO;
    }
}
