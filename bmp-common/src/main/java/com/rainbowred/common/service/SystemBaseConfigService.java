package com.rainbowred.common.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.rainbowred.common.domain.SystemBaseConfig;
import com.rainbowred.pojo.PageParam;

import java.util.List;

/**
* @author pengweibiao
* @description 针对表【system_base_config(系统内置参数表)】的数据库操作Service
* @createDate 2022-11-25 15:40:37
*/
public interface SystemBaseConfigService extends IService<SystemBaseConfig> {

    /**
     * 根据data_name 查询配置
     * @param dataName
     * @return
     */
    SystemBaseConfig selectByDataName(String dataName);

    /**
     * 根据data_name 创建配置
     * @param pojo
     * @return
     */
    SystemBaseConfig saveByDataName(SystemBaseConfig pojo);

    /**
     * 分页查询
     * @param pageParam 分页参数
     * @param queryWrapper 查询参数
     * @return
     */
    PageInfo<SystemBaseConfig> selectPageList(PageParam pageParam, QueryWrapper<SystemBaseConfig> queryWrapper);

    /**
     * 存在更新
     * 不存在新增
     * @param pojo
     * @return
     */
    boolean insertOrUpdate(SystemBaseConfig pojo);

    /**
     * 批量操作
     * 存在更新
     * 不存在新增
     * @param list
     * @return
     */
    boolean insertOrUpdateBatch(List<SystemBaseConfig> list);


}
