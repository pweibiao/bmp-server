package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerSkillStatus;
import com.rainbowred.echatServer.mapper.BmpServerSkillStatusMapper;
import com.rainbowred.echatServer.service.BmpServerSkillStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_skill_status(接待组状态)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerSkillStatusServiceImpl extends ServiceImpl<BmpServerSkillStatusMapper, BmpServerSkillStatus>
implements BmpServerSkillStatusService{

    @Autowired
    private BmpServerSkillStatusMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerSkillStatus pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
