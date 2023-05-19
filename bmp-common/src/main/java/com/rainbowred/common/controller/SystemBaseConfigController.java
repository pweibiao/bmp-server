package com.rainbowred.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbowred.common.domain.SystemBaseConfig;
import com.rainbowred.common.service.SystemBaseConfigService;
import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Desc:
 * @Date: 2022/12/2 11:23
 * @Author: pengweibiao
 **/
@RestController
@RequestMapping("/baseConfig")
public class SystemBaseConfigController extends BaseController{

    @Autowired
    private SystemBaseConfigService service;

    @GetMapping("/list")
    public CommonResult<List<SystemBaseConfig>> getList(@ModelAttribute SystemBaseConfig pojo) {
        validAdmin();
        QueryWrapper<SystemBaseConfig> sbQw = new QueryWrapper<>();
        if ( StringUtil.nonEmpty(pojo.getDataName()) ) {
            sbQw.eq("data_name", pojo.getDataName());
        }
        if ( StringUtil.nonEmpty(pojo.getDataType()) ) {
            sbQw.eq("data_type", pojo.getDataType());
        }
        if ( StringUtil.nonEmpty(pojo.getMainCode()) ) {
            sbQw.eq("main_code", pojo.getMainCode());
        }
        if ( StringUtil.nonEmpty(pojo.getSubCode()) ) {
            sbQw.eq("sub_code", pojo.getSubCode());
        }
        return success(service.list(sbQw));
    }

    @PostMapping("")
    public CommonResult<SystemBaseConfig> addConfig(@RequestBody SystemBaseConfig pojo) {
        validAdmin();
        pojo.setId(PojoUtil.getUUID());
        pojo.setCreateDate(new Date());
        pojo.setCreateBy(getUsername());
        return service.save(pojo) ? success("新增成功", pojo) : error("新增失败");
    }

    @PutMapping("")
    public CommonResult<SystemBaseConfig> updConfig(@RequestBody SystemBaseConfig pojo) {
        validAdmin();
        return service.updateById(pojo) ? success("更新成功", pojo) : error("更新失败");
    }

    @DeleteMapping("")
    public CommonResult<SystemBaseConfig> delConfig(@RequestBody SystemBaseConfig pojo) {
        validAdmin();
        return service.removeById(pojo) ? success("删除成功") : error("删除失败");
    }

}
