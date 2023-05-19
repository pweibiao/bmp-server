package com.rainbowred.echatServer.data;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Desc:
 * @Date: 2022/7/7 19:31
 * @Author: pengweibiao
 **/
@Data
public class BaseData implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 事件类型
     */
    private String dataType;
}
