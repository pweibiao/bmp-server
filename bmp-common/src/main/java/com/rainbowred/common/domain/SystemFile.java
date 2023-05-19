package com.rainbowred.common.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseDomain;
import lombok.Data;

/**
 * 系统附件表
 * @TableName bmp_base_system_file
 */
@TableName(value = "bmp_base_system_file")
@Data
public class SystemFile extends BaseDomain {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件后缀名
     */
    private String fileExt;

    /**
     * 绑定的业务id
     */
    private String bizId;

    /**
     * 绑定的业务名称，表名
     */
    private String bizName;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 绝对路径
     */
    private String realPath;

}
