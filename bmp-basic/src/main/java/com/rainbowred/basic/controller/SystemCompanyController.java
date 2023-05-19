package com.rainbowred.basic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.basic.service.SystemCompanyService;
import com.rainbowred.common.controller.BaseController;
import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @Date: 2023/5/15 16:36
 * @Author: pengweibiao
 **/
@RestController
@RequestMapping("/basic/companyConfig")
@Slf4j
public class SystemCompanyController extends BaseController {

    @Autowired
    private SystemCompanyService service;

    @Autowired
    private SystemCompanyCacheService cacheService;

    /**
     * 根据id获取公司详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CommonResult<SystemCompany> getList(@PathVariable(value = "id") String id) {
        return success(service.getById(id));
    }

    /**
     * 获取公司配置列表
     * @return
     */
    @GetMapping("/list")
    public CommonResult<List<SystemCompany>> getList() {
        QueryWrapper<SystemCompany> qw = new QueryWrapper<>();
        qw.select("id", "company_id", "name")
                .eq("disable", 0)
                .eq("del_flag", 0)
                .orderBy(true, true, "create_date");
        return success(service.list(qw));
    }

    /**
     * 新增公司
     * @param pojo
     * @return
     */
    @PostMapping("")
    public CommonResult<SystemCompany> add(@RequestBody SystemCompany pojo) {
        if (StringUtil.nonEmpty(pojo.getName())) {
            return success(service.addCompany(pojo));
        }
        return error("数据为空，新增失败");
    }

    /**
     * 更新公司配置
     * @param pojo
     * @return
     */
    @PutMapping("")
    public CommonResult<SystemCompany> update(@RequestBody SystemCompany pojo) {
        SystemCompany systemCompanyConfig = cacheService.getSystemCompanyConfig(pojo.getCompanyId());
        if (Objects.nonNull(systemCompanyConfig) && service.update(pojo, new QueryWrapper<>())) {
            cacheService.setSystemCompanyConfig(pojo);
            return success("更新成功");
        }
        return error("更新失败");
    }

    /**
     * 删除公司配置
     * @param pojo
     * @return
     */
    @DeleteMapping("")
    public CommonResult<String> del(@RequestBody SystemCompany pojo) {
        String id = pojo.getId();
        if (StringUtil.nonEmpty(id)) {
            UpdateWrapper<SystemCompany> uw = new UpdateWrapper<>();
            uw.set("disable", 1).set("del_flag", 1).eq("id", pojo.getId());
            if (service.update(uw)) {
                cacheService.delSystemCompanyId(pojo.getCompanyId());
                return success("删除成功");
            }
        }
        return error("删除失败");
    }
}
