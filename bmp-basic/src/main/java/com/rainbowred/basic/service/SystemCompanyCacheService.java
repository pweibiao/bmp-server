package com.rainbowred.basic.service;

import com.rainbowred.basic.domain.SystemCompany;

/**
 * @Desc:
 * @Date: 2023/5/15 10:06
 * @Author: pengweibiao
 **/
public interface SystemCompanyCacheService {

    /**
     * 设置公司配置缓存
     */
    void setSystemCompanyConfig(SystemCompany companyConfig);

    /**
     * 获取公司配置缓存
     */
    SystemCompany getSystemCompanyConfig(String companyId);

    /**
     * 获取公司配置的Token
     */
    String getCompanyToken(String companyId);

    /**
     * 删除公司配置缓存
     */
    void delSystemCompanyId(String companyId);

}
