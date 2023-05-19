package com.rainbowred.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rainbowred.domain.BaseDomain;
import lombok.Data;

import java.util.List;

/**
 * @Desc: 层级通用
 * @Date: 2022/11/2 20:43
 * @Author: pengweibiao
 **/
@Data
public class ElementPojo<T extends ElementPojo> extends BaseDomain{

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 排序
     */
    private Integer orderNo;

    @TableField(exist = false)
    private List<T> children;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
