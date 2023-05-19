package com.rainbowred.common.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowred.common.domain.SystemFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author pengweibiao
* @description 针对表【system_file(系统附件表)】的数据库操作Mapper
* @createDate 2022-11-22 14:54:30
* @Entity generator.domain.SystemFile
*/
public interface SystemFileMapper extends BaseMapper<SystemFile> {

    /**
     * 批量新增
     * @param list
     */
    void insertBatch(@Param("list") List<SystemFile> list);

    void disableFile(@Param("ids") List<String> ids);

}
