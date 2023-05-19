package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerSkillStatus;
import com.rainbowred.echatServer.domain.BmpServerStaffStatus;

/**
* @author pengweibiao
* @description 针对表【bmp_server_staff_status(客服状态)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerStaffStatusService extends IService<BmpServerStaffStatus> {

    void insertOrUpdate(BmpServerStaffStatus pojo);

}
