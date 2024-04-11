package com.nmz.accounting.modules.auther.handler;


import com.nmz.accounting.modules.auther.exception.AuthException;
import com.nmz.accounting.modules.common.exception.BaseException;
import com.nmz.accounting.modules.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@Slf4j
@RestControllerAdvice("com.nmz.map.controller")
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public Result<Object> handleException(Exception e) {
        log.error("发生了错误，被全局异常处理检查到:{}", e.getMessage());
        return Result.failed("接口调用失败");
    }

    @ExceptionHandler(AuthException.class)
    public Result<Object> handleUserException(AuthException exception) {
        log.error("用户操作存在异常: {}", exception.getMessage(), exception);
        return Result.failed(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Object> handleIllegalArgumentException(IllegalArgumentException exception) {
        log.error("参数校验异常: {}", exception.getMessage(), exception);
        return Result.failed(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    //参数校验异常
    @ExceptionHandler(BindException.class)
    public Result<Object> handleBindException(BindException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                log.error("参数校验异常：" + error.getField() + "原因:" + error.getDefaultMessage());
            }
        }
        return Result.failed("接口调用失败");
    }


}  
