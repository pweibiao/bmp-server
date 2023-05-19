package com.rainbowred.echatServer.mapper;

import com.rainbowred.echatServer.domain.BmpServerCrmData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_crm_data(客户数据)】的数据库操作Mapper
* @createDate 2023-05-17 10:27:06
* @Entity com.rainbowred.echatServer.domain.BmpServerCrmData
*/
public interface BmpServerCrmDataMapper extends BaseMapper<BmpServerCrmData> {

    void insertOrUpdate(@Param("e") BmpServerCrmData pojo);

}
