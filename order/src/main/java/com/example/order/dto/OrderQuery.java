package com.example.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderQuery implements Serializable {

    private Long createdStartTime;
    private Long createdEndTime;
    private Long storeId;
    private Integer orderStatus;
    private String orderNo;
    private Integer page=1;
    private Integer size=10;
}
