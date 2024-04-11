package com.nmz.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> Result<T> failed() {
        return new Result<>(ResultEnum.BAD_REQUEST.getCode(), ResultEnum.BAD_REQUEST.getMessage(), null);
    }


    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultEnum.BAD_REQUEST.getCode(), message, null);
    }


    public static <T> Result<T> failed(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> failed(IResult errorResult) {
        return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}