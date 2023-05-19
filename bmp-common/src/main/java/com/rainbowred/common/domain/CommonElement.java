package com.rainbowred.common.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import lombok.Data;

/**
 * 通用层级表
 * @TableName bmp_base_common_element
 */
@TableName(value = "bmp_base_common_element")
@Data
public class CommonElement extends BaseBizDomain {

    /**
     * 层级名称
     */
    private String name;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 顶级id
     */
    private String topId;

    /**
     * 业务对象id
     */
    private String bizId;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 业务数据
     */
    private String bizContent;

}
