package com.nmz.accounting.auther.exception;

import com.nmz.common.exception.BaseException;
import lombok.Getter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public class AuthException extends BaseException {

    public static final AuthException USERNAME_ALREADY_EXIST = new AuthException(BAD_REQUEST.value(), "同名用户已存在");

    public static final AuthException USER_NOT_EXIST = new AuthException(BAD_REQUEST.value(), "用户不存在");

    public static final AuthException USER_STATUS_NOT_EXIST = new AuthException(BAD_REQUEST.value(), "用户状态不存在");

    public static final AuthException PERMISSION_DENIED = new AuthException(BAD_REQUEST.value(), "用户权限不足");

    public static final AuthException USER_NAME_OR_PASSWORD_ERROR = new AuthException(BAD_REQUEST.value(), "用户名或密码错误");

    public static final AuthException USER_DATA_EMPTY_EXCEPTION = new AuthException(BAD_REQUEST.value(), "用户信息不能为空");

    public static final AuthException USERNAME_OR_PASSWORD_EMPTY = new AuthException(BAD_REQUEST.value(), "用户名或密码不能为空");

    public static final AuthException CERTIFICATION_FAILED = new AuthException(BAD_REQUEST.value(), "认证失败");

    private final int code;
    private final String message;


    public AuthException(int code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
