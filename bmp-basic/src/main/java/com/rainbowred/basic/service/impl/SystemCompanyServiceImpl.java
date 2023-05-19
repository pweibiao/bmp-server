package com.rainbowred.basic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.mapper.SystemCompanyMapper;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.basic.service.SystemCompanyService;
import com.rainbowred.common.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author pengweibiao
* @description 针对表【bmp_basic_system_company(公司配置)】的数据库操作Service实现
* @createDate 2023-05-15 09:33:01
*/
@Service
public class SystemCompanyServiceImpl extends ServiceImpl<SystemCompanyMapper, SystemCompany>
implements SystemCompanyService {

    @Autowired
    private SystemCompanyMapper mapper;

    @Autowired
    private SystemCompanyCacheService cacheService;

    @Override
    public SystemCompany addCompany(SystemCompany pojo) {
        pojo.setId(PojoUtil.getUUID());
        pojo.setCreateDate(new Date());
        mapper.addCompany(pojo);
        // 同步缓存
        cacheService.setSystemCompanyConfig(pojo);
        return pojo;
    }
}
