package com.rainbowred.common.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseDomain;
import lombok.Data;

/**
 * 系统内置参数表
 * @TableName bmp_base_system_base_config
 */
@TableName(value = "bmp_base_system_base_config")
@Data
public class SystemBaseConfig extends BaseDomain {

    /**
     * 名称
     */
    private String dataName;

    /**
     * 值
     */
    private String dataValue;

    /**
     * 参数类型
     */
    private String dataType;

    /**
     * 主类型
     */
    private String mainCode;

    /**
     * 辅类型
     */
    private String subCode;

    /**
     * 关联业务ID
     */
    private String bizId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 内容
     */
    private String content;

}
