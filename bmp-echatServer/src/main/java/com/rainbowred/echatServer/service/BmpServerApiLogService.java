package com.rainbowred.echatServer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerApiLog;

/**
* @author pengweibiao
* @description 针对表【bmp_server_api_log(服务器交互日志)】的数据库操作Service
* @createDate 2023-05-15 14:30:05
*/
public interface BmpServerApiLogService extends IService<BmpServerApiLog> {

    void insertOrUpdate(BmpServerApiLog pojo);

}
