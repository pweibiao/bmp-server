package com.rainbowred.common.enums;

/**
 * @Desc:
 * @Date: 2022/12/2 17:27
 * @Author: pengweibiao
 **/
public enum Motion implements IValue{
    ADD("新增"),
    UPD("更新"),
    DEL("删除"),

    LOGIN("登陆"),
    LOGOUT("登出"),

    UPLOAD("附件上传"),

    TEST("审核通过生成静态文件"),

    ROLLBACK("回退"),


    ERROR("错误"),
    ;

    private final String value;

    Motion(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
