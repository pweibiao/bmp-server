package com.rainbowred.common.enums;

/**
 * @Desc: 枚举类接口
 * @Date: 2022/11/29 09:46
 * @Author: pengweibiao
 **/
public interface ILabelValue {

    /**
     * 获取枚举数值
     * @return
     */
    int getValue();

    /**
     * 获取枚举数值对应的意义
     * @return
     */
    String getLabel();

}
