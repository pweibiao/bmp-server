package com.rainbowred.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc: 查询参数
 * @Date: 2022/11/25 10:15
 * @Author: pengweibiao
 **/
@Data
public class BaseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排序参数
     */
    private OrderValue orderValue;

}
