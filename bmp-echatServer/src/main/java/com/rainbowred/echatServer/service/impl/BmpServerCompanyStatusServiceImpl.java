package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerCompanyStatus;
import com.rainbowred.echatServer.mapper.BmpServerCompanyStatusMapper;
import com.rainbowred.echatServer.service.BmpServerCompanyStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_company_status(公司状态)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerCompanyStatusServiceImpl extends ServiceImpl<BmpServerCompanyStatusMapper, BmpServerCompanyStatus>
implements BmpServerCompanyStatusService{

    @Autowired
    private BmpServerCompanyStatusMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerCompanyStatus pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
