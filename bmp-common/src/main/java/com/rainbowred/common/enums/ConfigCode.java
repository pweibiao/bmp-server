package com.rainbowred.common.enums;

/**
 * @Desc:
 * @Date: 2023/1/5 14:23
 * @Author: pengweibiao
 **/
public enum ConfigCode implements IValue{

    /**
     * 管理员的主类型配置code
     */
    ADMIN_MAIN_CODE("auth"),

    /**
     * 管理员的辅类型配置code
     */
    ADMIN_SUB_CODE("admin"),

    /**
     * 管理菜单 subCode
     */
    SYS_SUB_CODE("sys"),

    /**
     * 发布验证码接收邮箱
     */
    EMAIL_RECIPIENT("email_recipient"),

    ;

    private final String value;

    ConfigCode(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
