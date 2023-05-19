package com.rainbowred.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainbowred.common.domain.SystemBaseConfig;
import com.rainbowred.common.enums.ErrorCode;
import com.rainbowred.common.exception.BusinessException;
import com.rainbowred.common.mapper.SystemBaseConfigMapper;
import com.rainbowred.common.service.SystemBaseConfigService;
import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.pojo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* @author pengweibiao
* @description 针对表【system_base_config(系统内置参数表)】的数据库操作Service实现
* @createDate 2022-11-25 15:40:37
*/
@Service
public class SystemBaseConfigServiceImpl extends ServiceImpl<SystemBaseConfigMapper, SystemBaseConfig>
implements SystemBaseConfigService {

    @Autowired
    private SystemBaseConfigMapper mapper;

    @Override
    public SystemBaseConfig selectByDataName(String dataName) {
        QueryWrapper<SystemBaseConfig> qw = new QueryWrapper<>();
        qw.eq("data_name", dataName)
                .eq("disable", 0)
                .eq("del_flag", 0);
        return this.getOne(qw);
    }

    @Override
    public SystemBaseConfig saveByDataName(SystemBaseConfig pojo) {
        // 校验配置是否有效
        String dataName = pojo.getDataName();
        if (StringUtil.isEmpty(dataName)) {
            throw new BusinessException(ErrorCode.E415, "dataName为空");
        }
        // 查询是否有重复配置
        QueryWrapper<SystemBaseConfig> qw = new QueryWrapper<>();
        qw.eq("data_name", dataName)
                .eq("disable", 0)
                .eq("del_flag", 0);
        if (this.count(qw) > 0) {
            throw new BusinessException(ErrorCode.E415, "存在相同dataName");
        }
        // 新增数据
        if (StringUtil.isEmpty(pojo.getId())) {
            pojo.setId(PojoUtil.getUUID());
        }
        if (Objects.isNull(pojo.getCreateDate())) {
            pojo.setCreateDate(new Date());
        }
//        if (StringUtil.isEmpty(pojo.getCreateBy())) {
//            pojo.setCreateBy(PojoUtil.getUsername());
//        }
        this.save(pojo);

        return pojo;
    }


    @Override
    public PageInfo<SystemBaseConfig> selectPageList(PageParam pageParam, QueryWrapper<SystemBaseConfig> queryWrapper) {
        // 校验参数
        if (Objects.isNull(pageParam.getPageSize()) || Objects.isNull(pageParam.getPageNum())) {
            return null;
        }
        // 分页
        Page<SystemBaseConfig> page = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        this.list(queryWrapper);
        return new PageInfo<>(page);
    }

    @Override
    public boolean insertOrUpdate(SystemBaseConfig pojo) {
        if (Objects.isNull(pojo)) {
            return false;
        }
        int i = mapper.insertOrUpdate(pojo);
        return i == 1 ? true : false;
    }

    @Override
    public boolean insertOrUpdateBatch(List<SystemBaseConfig> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        int i = mapper.insertOrUpdateBatch(list);
        return i > 0 ? true : false;
    }
}
