package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerApiLog;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_api_log(服务器交互日志)】的数据库操作Mapper
* @createDate 2023-05-15 14:30:05
* @Entity com.rainbowred.echatServer.domain.BmpServerApiLog
*/
public interface BmpServerApiLogMapper extends BaseMapper<BmpServerApiLog> {

    void insertOrUpdate(@Param("e") BmpServerApiLog pojo);

}
