package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerStaffStatus;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_staff_status(客服状态)】的数据库操作Mapper
* @createDate 2023-05-17 10:19:46
* @Entity com.rainbowred.echatServer.domain.BmpServerStaffStatus
*/
public interface BmpServerStaffStatusMapper extends BaseMapper<BmpServerStaffStatus> {

    void insertOrUpdate(@Param("e") BmpServerStaffStatus pojo);


}
