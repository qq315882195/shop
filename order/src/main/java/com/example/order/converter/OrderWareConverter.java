package com.example.order.converter;


import com.example.order.dto.OrderWareDTO;
import com.example.order.dto.OrderWareMessageDTO;
import com.example.order.pojo.OrderWare;
import com.example.order.vo.OrderWareVO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderWareConverter {

    /**
     * DTO转换成POJO
     */
    public static OrderWare toPO(OrderWareDTO orderWareDTO) {
        OrderWare orderWare = new OrderWare();
        orderWare.setOrderNo(orderWareDTO.getOrderNo());
        orderWare.setStoreId(orderWareDTO.getStoreId());
        orderWare.setWareName(orderWareDTO.getWareName());
        orderWare.setPrice(orderWareDTO.getPrice());
        return orderWare;
    }

    public static List<OrderWareVO> toVOList(List<OrderWare> orderWares) {
        List<OrderWareVO> orderWareVOS = new ArrayList<>();
        for (OrderWare orderWare : orderWares) {
            orderWareVOS.add(toVO(orderWare));
        }
        return orderWareVOS;
    }

    private static OrderWareVO toVO(OrderWare orderWare) {
        OrderWareVO orderWareVO = new OrderWareVO();
        orderWareVO.setOrderNo(orderWare.getOrderNo());
        orderWareVO.setStoreId(orderWare.getStoreId());
        orderWareVO.setWareName(orderWare.getWareName());
        orderWareVO.setPrice(orderWare.getPrice());
        orderWareVO.setId(orderWare.getId());
        orderWareVO.setCreated(orderWare.getCreated());
        orderWareVO.setUpdated(orderWare.getUpdated());
        return orderWareVO;
    }

    private static OrderWareDTO toDTO(OrderWare orderWare) {
        OrderWareDTO orderWareDTO = new OrderWareDTO();
        orderWareDTO.setOrderNo(orderWare.getOrderNo());
        orderWareDTO.setStoreId(orderWare.getStoreId());
        orderWareDTO.setWareName(orderWare.getWareName());
        orderWareDTO.setPrice(orderWare.getPrice());
        orderWareDTO.setId(orderWare.getId());
        orderWareDTO.setCreated(orderWare.getCreated());
        orderWareDTO.setUpdated(orderWare.getUpdated());
        return orderWareDTO;
    }

    public static List<OrderWareMessageDTO> toMessageDTO(List<OrderWare> orderWareList) {
        if (CollectionUtils.isEmpty(orderWareList)) {
            return null;
        }
        List<OrderWareMessageDTO> orderWareMessageDTOList = new ArrayList<>();
        for (OrderWare orderWare : orderWareList) {
            orderWareMessageDTOList.add(toMessageDTO(orderWare));
        }
        return orderWareMessageDTOList;
    }

    private static OrderWareMessageDTO toMessageDTO(OrderWare orderWare) {
        OrderWareMessageDTO orderWareMessageDTO = new OrderWareMessageDTO();
        orderWareMessageDTO.setOrderNo(orderWare.getOrderNo());
        orderWareMessageDTO.setStoreId(orderWare.getStoreId());
        orderWareMessageDTO.setWareName(orderWare.getWareName());
        orderWareMessageDTO.setPrice(orderWare.getPrice());
        orderWareMessageDTO.setId(orderWare.getId());
        orderWareMessageDTO.setCreated(orderWare.getCreated());
        orderWareMessageDTO.setUpdated(orderWare.getUpdated());
        return orderWareMessageDTO;
    }
}
