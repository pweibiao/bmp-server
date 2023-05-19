package com.rainbowred.echatServer.service;

import com.rainbowred.echatServer.domain.BmpServerCrmData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerTrackRecord;

/**
* @author pengweibiao
* @description 针对表【bmp_server_crm_data(客户数据)】的数据库操作Service
* @createDate 2023-05-17 10:27:06
*/
public interface BmpServerCrmDataService extends IService<BmpServerCrmData> {

    void insertOrUpdate(BmpServerCrmData pojo);

}
