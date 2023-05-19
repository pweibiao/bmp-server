package com.rainbowred.domain;

import lombok.Data;

/**
 * @Desc: 业务基类
 * @Date: 2023/5/17 15:08
 * @Author: pengweibiao
 **/
@Data
public abstract class BaseBizDomain extends BaseDomain{

    /**
     * 公司ID
     */
    private String companyId;

}
