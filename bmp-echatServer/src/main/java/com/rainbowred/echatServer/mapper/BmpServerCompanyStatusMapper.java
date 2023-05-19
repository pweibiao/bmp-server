package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerCompanyStatus;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_company_status(公司状态)】的数据库操作Mapper
* @createDate 2023-05-17 10:19:46
* @Entity com.rainbowred.echatServer.domain.BmpServerCompanyStatus
*/
public interface BmpServerCompanyStatusMapper extends BaseMapper<BmpServerCompanyStatus> {

    void insertOrUpdate(@Param("e") BmpServerCompanyStatus pojo);

}
