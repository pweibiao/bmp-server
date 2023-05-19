package com.rainbowred.pojo;

import com.rainbowred.common.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Desc: 统一返回结构
 * @Date: 2022/7/6 16:24
 * @Author: pengweibiao
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T extends Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态码
    private Integer code;

    // 返回描述
    private String msg;

    // 返回数据
    private T data;

    public CommonResult(Integer errorCode) {
        super();
        this.code = errorCode;
    }

    public static <T> CommonResult<T> newInstance() {
        return new CommonResult<T>(200);
    }

    public static <T> CommonResult<T> success(){
        return newInstance();
    }

    public static <T> CommonResult<T> error(){
        return new CommonResult<>(400);
    }

    public static <T> CommonResult<T> success(T entity){
        return new CommonResult(200, null, entity);
    }

    public static <T> CommonResult<T> success(String message){
        return new CommonResult(200, message, null);
    }

    public static <T> CommonResult<T> success(String message, T entity){
        return new CommonResult(200, message, entity);
    }

    public static <T> CommonResult<T> error(T entity) {
        return new CommonResult(400, null, entity);
    }

    public static <T> CommonResult<T> error(String msg, T entity) {
        return new CommonResult(400, msg, entity);
    }

    public static <T> CommonResult<T> error(String msg) {
        return new CommonResult(400, msg, null);
    }

    public static <T> CommonResult<T> error(Integer code, String msg) {
        return new CommonResult(code, msg, null);
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        String strCode = errorCode.getCode();
        Integer substring = new Integer(strCode.substring(1));
        return error(substring, errorCode.getMessage());
    }

}
