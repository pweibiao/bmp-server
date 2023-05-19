package com.rainbowred.echatServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.echatServer.domain.BmpServerTrackRecord;
import org.apache.ibatis.annotations.Param;

/**
* @author pengweibiao
* @description 针对表【bmp_server_track_record(浏览数据)】的数据库操作Mapper
* @createDate 2023-05-17 10:19:46
* @Entity com.rainbowred.echatServer.domain.BmpServerTrackRecord
*/
public interface BmpServerTrackRecordMapper extends BaseMapper<BmpServerTrackRecord> {

    void insertOrUpdate(@Param("e") BmpServerTrackRecord pojo);

}
