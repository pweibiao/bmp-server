package com.rainbowred.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.basic.domain.SystemCompany;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_basic_system_company(公司配置)】的数据库操作Mapper
* @createDate 2023-05-15 09:33:01
* @Entity generator.domain.SystemCompany
*/
public interface SystemCompanyMapper extends BaseMapper<SystemCompany> {

    void addCompany(@Param("e") SystemCompany systemCompany);

    void updateCompany(@Param("e") SystemCompany systemCompany);

}
