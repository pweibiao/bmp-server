package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerSkillStatus;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_skill_status(接待组状态)】的数据库操作Mapper
* @createDate 2023-05-17 10:19:46
* @Entity com.rainbowred.echatServer.domain.BmpServerSkillStatus
*/
public interface BmpServerSkillStatusMapper extends BaseMapper<BmpServerSkillStatus> {

    void insertOrUpdate(@Param("e") BmpServerSkillStatus pojo);

}
