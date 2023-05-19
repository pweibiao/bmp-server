package com.rainbowred.common.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.common.domain.SystemBaseConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pengweibiao
* @description 针对表【system_base_config(系统内置参数表)】的数据库操作Mapper
* @createDate 2022-11-25 15:40:37
* @Entity generator.domain.SystemBaseConfig
*/
public interface SystemBaseConfigMapper extends BaseMapper<SystemBaseConfig> {

    int insertOrUpdate(@Param("item") SystemBaseConfig pojo);

    int insertOrUpdateBatch(@Param("list") List<SystemBaseConfig> list);

}
