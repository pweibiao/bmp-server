package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerCrmData;
import com.rainbowred.echatServer.service.BmpServerCrmDataService;
import com.rainbowred.echatServer.mapper.BmpServerCrmDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_crm_data(客户数据)】的数据库操作Service实现
* @createDate 2023-05-17 10:27:06
*/
@Service
public class BmpServerCrmDataServiceImpl extends ServiceImpl<BmpServerCrmDataMapper, BmpServerCrmData>
implements BmpServerCrmDataService{

    @Autowired
    private BmpServerCrmDataMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerCrmData pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
