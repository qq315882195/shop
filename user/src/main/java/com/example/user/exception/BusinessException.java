package com.example.user.exception;

import com.example.user.enums.ChatErrorEnum;

public class BusinessException extends RuntimeException{

    private String  code;
    private String  message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(String message, String code) {
        this.message= message;
        this.code=code;
    }
    public BusinessException(String message) {
        this.message= message;
        this.code= ChatErrorEnum.OPERATION_ERROR.getCode();
    }
}
