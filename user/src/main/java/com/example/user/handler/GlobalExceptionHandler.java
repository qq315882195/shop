package com.example.user.handler;

import com.example.user.enums.ChatErrorEnum;
import com.example.user.exception.BusinessException;
import com.example.user.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public final Result handleBusinessExceptions(BusinessException businessException, WebRequest request) {
        return Result.error( businessException.getMessage(),businessException.getCode());
    }

    @ExceptionHandler(value = Exception.class)
    public final Result handleException(Exception exception, WebRequest request) {
        return Result.error(ChatErrorEnum.OPERATION_ERROR.getDesc(),ChatErrorEnum.OPERATION_ERROR.getCode());
    }
}
