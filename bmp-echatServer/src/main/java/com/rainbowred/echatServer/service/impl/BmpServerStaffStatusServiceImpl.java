package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerStaffStatus;
import com.rainbowred.echatServer.mapper.BmpServerStaffStatusMapper;
import com.rainbowred.echatServer.service.BmpServerStaffStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_staff_status(客服状态)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerStaffStatusServiceImpl extends ServiceImpl<BmpServerStaffStatusMapper, BmpServerStaffStatus>
implements BmpServerStaffStatusService{

    @Autowired
    private BmpServerStaffStatusMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerStaffStatus pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
