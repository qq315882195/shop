package com.example.order.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderResponeDTO implements Serializable {

    private List<OrderIndexDTO> orderIndexDTOS;
    private Integer total;
    private Integer page;
    private Integer size;
}
