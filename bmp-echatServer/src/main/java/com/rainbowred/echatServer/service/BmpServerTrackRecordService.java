package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerChatRecord;
import com.rainbowred.echatServer.domain.BmpServerTrackRecord;

/**
* @author pengweibiao
* @description 针对表【bmp_server_track_record(浏览数据)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerTrackRecordService extends IService<BmpServerTrackRecord> {

    void insertOrUpdate(BmpServerTrackRecord pojo);

}
