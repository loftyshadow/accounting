package com.nmz.accounting.modules.common.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/25-15:38
 */
@Getter
public class BaseException extends RuntimeException {

    public static final BaseException BAD_PARAMETER = new BaseException(BAD_REQUEST.value(), "参数错误");


    private final int code;
    private final String message;


    public BaseException(int  code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
