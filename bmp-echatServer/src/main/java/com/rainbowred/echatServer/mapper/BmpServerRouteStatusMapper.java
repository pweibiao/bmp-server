package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerRouteStatus;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_route_status(路由状态)】的数据库操作Mapper
* @createDate 2023-05-17 10:19:46
* @Entity com.rainbowred.echatServer.domain.BmpServerRouteStatus
*/
public interface BmpServerRouteStatusMapper extends BaseMapper<BmpServerRouteStatus> {

    void insertOrUpdate(@Param("e") BmpServerRouteStatus pojo);

}
