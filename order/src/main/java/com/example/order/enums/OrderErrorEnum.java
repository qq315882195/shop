package com.example.order.enums;

public enum OrderErrorEnum {
    OPERATION_ERROR("0001", "操作异常"),
    ORDER_NOT_EXIST("0002", "订单不存在"),
    ES_ORDER_SEARCH_ERROR("0003","ES订单查询异常");

    private String code;
    private String desc;
    OrderErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public static OrderErrorEnum getEnumByCode(String code) {
        for (OrderErrorEnum orderErrorEnum : OrderErrorEnum.values()) {
            if (orderErrorEnum.getCode().equals(code)) {
                return orderErrorEnum;
            }
        }
        return null;
    }
}
