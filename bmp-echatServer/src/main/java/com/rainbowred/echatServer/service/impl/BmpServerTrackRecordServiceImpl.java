package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerTrackRecord;
import com.rainbowred.echatServer.mapper.BmpServerTrackRecordMapper;
import com.rainbowred.echatServer.service.BmpServerTrackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_track_record(浏览数据)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerTrackRecordServiceImpl extends ServiceImpl<BmpServerTrackRecordMapper, BmpServerTrackRecord>
implements BmpServerTrackRecordService{

    @Autowired
    private BmpServerTrackRecordMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerTrackRecord pojo) {
        mapper.insertOrUpdate(pojo);
    }
}
