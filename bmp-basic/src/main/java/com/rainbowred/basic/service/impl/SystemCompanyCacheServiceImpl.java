package com.rainbowred.basic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.common.enums.RedisField;
import com.rainbowred.common.service.RedisService;
import com.rainbowred.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Desc: 公司配置缓存业务
 * @Date: 2023/5/15 10:06
 * @Author: pengweibiao
 **/
@Service
@Slf4j
public class SystemCompanyCacheServiceImpl implements SystemCompanyCacheService {

    @Autowired
    private RedisService redisService;

    /**
     * 公司配置缓存key
     */
    private static final String REDIS_KEY = RedisField.SYSTEM + ":basic:companyconfig:";

    @Override
    public void setSystemCompanyConfig(SystemCompany companyConfig) {
        if (Objects.nonNull(companyConfig)) {
            String companyId = companyConfig.getCompanyId();
            if (StringUtil.nonEmpty(companyId)) {
                redisService.set(REDIS_KEY+companyId, companyConfig);
            }
        }
    }

    @Override
    public SystemCompany getSystemCompanyConfig(String companyId) {
        if (StringUtil.nonEmpty(companyId)) {
            JSONObject jsonObject = redisService.get(REDIS_KEY + companyId);
            try {
                SystemCompany systemCompany = JSONObject.parseObject(jsonObject.toString(), SystemCompany.class);
                return systemCompany;
            }catch (Exception e) {
                log.info("=====SystemCompanyCacheServiceImpl-getSystemCompanyConfig=====Error====="+e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String getCompanyToken(String companyId) {
        if (StringUtil.nonEmpty(companyId)) {
            JSONObject jsonObject = redisService.get(REDIS_KEY + companyId);
            if (Objects.nonNull(jsonObject)) {
                return (String) jsonObject.get("token");
            }
        }
        return null;
    }

    @Override
    public void delSystemCompanyId(String companyId) {
        if (StringUtil.nonEmpty(companyId)) {
            redisService.del(REDIS_KEY+companyId);
        }
    }
}
