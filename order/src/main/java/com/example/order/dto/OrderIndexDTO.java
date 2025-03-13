package com.example.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderIndexDTO implements Serializable {

    private Long created;
    private Long storeId;
    private Integer orderStatus;
    private String orderNo;
}
