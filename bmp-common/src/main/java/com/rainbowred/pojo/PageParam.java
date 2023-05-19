package com.rainbowred.pojo;

import com.rainbowred.domain.BaseBizDomain;
import lombok.Data;

/**
 * @Desc: 分页参数
 * @Date: 2022/11/2 11:32
 * @Author: pengweibiao
 **/
@Data
public class PageParam extends BaseBizDomain {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 排序参数
     */
    private OrderValue orderValue;

}
