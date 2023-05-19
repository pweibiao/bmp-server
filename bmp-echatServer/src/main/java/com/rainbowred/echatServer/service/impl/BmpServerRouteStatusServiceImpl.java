package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerRouteStatus;
import com.rainbowred.echatServer.mapper.BmpServerRouteStatusMapper;
import com.rainbowred.echatServer.service.BmpServerRouteStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_route_status(路由状态)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerRouteStatusServiceImpl extends ServiceImpl<BmpServerRouteStatusMapper, BmpServerRouteStatus>
implements BmpServerRouteStatusService{

    @Autowired
    private BmpServerRouteStatusMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerRouteStatus pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
