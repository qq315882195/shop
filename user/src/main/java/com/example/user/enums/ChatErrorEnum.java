package com.example.user.enums;

public enum ChatErrorEnum {
    OPERATION_ERROR("0001", "操作异常"),
    PASSWORD_ERROR("1001", "密码错误"),
    ACCOUNT_NOT_EXIST("1002", "账号不存在"),
    ACCOUNT_REGISTER_ERROR("1003","注册失败" ),
    CAPTCHA_ERROR("1004", "验证码错误或已过期！"),

    ACCOUNT_ALREADY_EXIST("1005","账号已注册");

    private String code;
    private String desc;
    ChatErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public static ChatErrorEnum getEnumByCode(String code) {
        for (ChatErrorEnum chatErrorEnum : ChatErrorEnum.values()) {
            if (chatErrorEnum.getCode().equals(code)) {
                return chatErrorEnum;
            }
        }
        return null;
    }
}
