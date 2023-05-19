package com.rainbowred.basic.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.basic.domain.SystemCompany;

/**
* @author pengweibiao
* @description 针对表【bmp_basic_system_company(公司配置)】的数据库操作Service
* @createDate 2023-05-15 09:33:01
*/
public interface SystemCompanyService extends IService<SystemCompany> {

    public SystemCompany addCompany(SystemCompany pojo);

}
