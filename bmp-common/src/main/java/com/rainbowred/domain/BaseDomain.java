package com.rainbowred.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rainbowred.pojo.BasePojo;
import com.rainbowred.pojo.OrderValue;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc: 数据库实体抽象
 * @Date: 2022/11/17 20:19
 * @Author: pengweibiao
 **/
@Data
public abstract class BaseDomain extends BasePojo {

    public BaseDomain() {}

    public BaseDomain(String id) {
        this.id = id;
    }

    /**
     * 唯一ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 是否禁用。0：启用，1：禁用
     */
    private Integer disable;

    /**
     * 是否删除。0：未删，1：已删
     */
    private Integer delFlag;


    /**
     * ========== 查询参数 ==========
     */

    /**
     * 开始时间
     */
    @TableField(exist = false)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField(exist = false)
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     * 页码
     */
    @TableField(exist = false)
    private Integer pageNum;

    /**
     * 每页显示数量
     */
    @TableField(exist = false)
    private Integer pageSize;

    /**
     * 排序参数
     */
    @TableField(exist = false)
    private OrderValue orderValue;

    /**
     * 创建时间格式化
     */
    @TableField(exist = false)
    private String createDateStr;

    public void setCreateDateStr(SimpleDateFormat simpleDateFormat) {
        if (this.getCreateDate() != null) {
            this.createDateStr = simpleDateFormat.format(this.getCreateDate());
        }
    }

    /**
     * 更新时间格式化
     */
    @TableField(exist = false)
    private String UpdateDateStr;

    public void setUpdateDateStr(SimpleDateFormat simpleDateFormat) {
        if (this.getUpdateDate() != null) {
            this.UpdateDateStr = simpleDateFormat.format(this.getUpdateDate());
        }
    }
}

