package com.example.order.vo;

import java.io.Serializable;
import java.util.List;

public class OrderVO implements Serializable {

    private Long id;

    private Long amount;
    private Long created;
    private Long updated;
    private String storeCode;
    private String storeName;
    private Long storeId;
    private Integer orderStatus;
    private String orderNo;

    private List<OrderWareVO> orderWareVOS;

    private OrderConsigneeVO orderConsigneeVO;

    public List<OrderWareVO> getOrderWareVOS() {
        return orderWareVOS;
    }

    public void setOrderWareVOS(List<OrderWareVO> orderWareVOS) {
        this.orderWareVOS = orderWareVOS;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderConsigneeVO(OrderConsigneeVO orderConsigneeVO) {
        this.orderConsigneeVO = orderConsigneeVO;
    }

    public OrderConsigneeVO getOrderConsigneeVO() {
        return orderConsigneeVO;
    }
}
