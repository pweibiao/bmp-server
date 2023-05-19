package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerRouteStatus;
import com.rainbowred.echatServer.domain.BmpServerSkillStatus;

/**
* @author pengweibiao
* @description 针对表【bmp_server_skill_status(接待组状态)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerSkillStatusService extends IService<BmpServerSkillStatus> {

    void insertOrUpdate(BmpServerSkillStatus pojo);

}
