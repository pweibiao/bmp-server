package com.rainbowred.common.enums;

/**
 * @Desc: 错误码
 * @Date: 2022/9/5 10:13
 * @Author: pengweibiao
 **/
public enum ErrorCode {

    /**
     * 通用业务问题
     */
    E400("请求信息有误"),

    E415("执行不被允许"),

    E416("缺少请求参数"),

    /**
     * 密码校验
     */
    E401("登陆失败，密码错误"),
    E402("过期或无效的token"),
    E403("登陆失败，账号不存在"),
    E404("登陆失败，账号已被禁用"),
    E405("账号权限不足"),

    /**
     * 服务器数据bug
     */
    E500("数据不存在"),


    ;



    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.name();
    }
}
