package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerRouteStatus;

/**
* @author pengweibiao
* @description 针对表【bmp_server_route_status(路由状态)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerRouteStatusService extends IService<BmpServerRouteStatus> {

    void insertOrUpdate(BmpServerRouteStatus pojo);

}
