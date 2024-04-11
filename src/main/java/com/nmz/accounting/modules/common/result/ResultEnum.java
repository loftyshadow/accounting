package com.nmz.common.result;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.OK;

//常用结果的枚举
public enum ResultEnum implements IResult {

    SUCCESS(OK.value(), "接口调用成功"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "请求错误"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "账号未登录"),
    COMMON_FAILED(HttpStatus.FORBIDDEN.value(), "没有该操作权限"),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "请求未找到"),
    METHOD_NOT_ALLOWED (HttpStatus.METHOD_NOT_ALLOWED.value(), "请求方法不正确"),
    LOCKED (HttpStatus.LOCKED.value(), "请求失败，请稍后重试"),
    TOO_MANY_REQUESTS (HttpStatus.TOO_MANY_REQUESTS.value(), "请求过于频繁，请稍后重试"),
    INTERNAL_SERVER_ERROR (HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");

    private final Integer code;
    private final String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}