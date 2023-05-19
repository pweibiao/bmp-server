package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerCompanyStatus;

/**
* @author pengweibiao
* @description 针对表【bmp_server_company_status(公司状态)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerCompanyStatusService extends IService<BmpServerCompanyStatus> {

    void insertOrUpdate(BmpServerCompanyStatus pojo);

}
