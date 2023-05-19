package com.rainbowred.echatServer.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerApiLog;
import com.rainbowred.echatServer.mapper.BmpServerApiLogMapper;
import com.rainbowred.echatServer.service.BmpServerApiLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_api_log(服务器交互日志)】的数据库操作Service实现
* @createDate 2023-05-15 14:30:05
*/
@Service
public class BmpServerApiLogServiceImpl extends ServiceImpl<BmpServerApiLogMapper, BmpServerApiLog>
implements BmpServerApiLogService {

    @Autowired
    private BmpServerApiLogMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerApiLog pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
