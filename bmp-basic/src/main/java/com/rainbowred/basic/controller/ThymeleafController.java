package com.rainbowred.basic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.basic.service.SystemCompanyService;
import com.rainbowred.common.controller.BaseController;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.pojo.CommonResult;
import com.rainbowred.pojo.EncryptPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @Date: 2023/5/15 16:36
 * @Author: pengweibiao
 **/
@Controller
@RequestMapping("/basic/thy")
@Slf4j
public class ThymeleafController extends BaseController {

    @Autowired
    private SystemCompanyService service;

    @Autowired
    private SystemCompanyCacheService cacheService;

    /**
     * ========== 公司配置 ==========
     */

    /**
     * 公司列表
     * @return
     */
    @GetMapping("/companyConfig/list")
    public String getListThy(Model model) {
        QueryWrapper<SystemCompany> qw = new QueryWrapper<>();
        qw.eq("disable", 0)
                .eq("del_flag", 0)
                .orderBy(true, false, "create_date");
        List<SystemCompany> list = service.list(qw);
        model.addAttribute("companyList", list);
        return "view/basic/companyConfig/companyConfig";
    }

    /**
     * 公司配置添加页
     */
    @GetMapping("/companyConfig/add")
    public String addThy(Model model) {
        SystemCompany systemCompany = new SystemCompany();
        systemCompany.setCompanyId("请输入公司ID");
        systemCompany.setName("请输入公司名称");
        model.addAttribute("systemCompany", systemCompany);
        return "view/basic/companyConfig/addCompanyConfig";
    }

    /**
     * 添加公司配置
     * @return
     */
    @PostMapping("/companyConfig/add")
    public String add(@ModelAttribute SystemCompany systemCompany, Model model) {
        if (StringUtil.nonEmpty(systemCompany.getName())) {
            service.addCompany(systemCompany);
        }
        return getListThy(model);
    }

    /**
     * 公司配置更新页
     * @param pojo
     * @return
     */
    @GetMapping("/companyConfig/update")
    public String updateHtml(@ModelAttribute SystemCompany pojo, Model model) {
        SystemCompany systemCompany = service.getById(pojo.getId());
        model.addAttribute("systemCompany", systemCompany);
        return "view/basic/companyConfig/editCompanyConfig";
    }

    /**
     * 更新公司配置
     * @param pojo
     * @return
     */
    @PostMapping("/companyConfig/update")
    public String update(@ModelAttribute SystemCompany pojo, Model model) {
        QueryWrapper<SystemCompany> qw = new QueryWrapper<>();
        qw.eq("id", pojo.getId());
        if (service.update(pojo, qw)) {
            cacheService.setSystemCompanyConfig(pojo);
        }
        return getListThy(model);
    }

    /**
     * 删除公司配置
     * @param pojo
     * @return
     */
    @GetMapping("/companyConfig/delete")
    public String del(@ModelAttribute SystemCompany pojo, Model model) {
        UpdateWrapper<SystemCompany> uw = new UpdateWrapper<>();
        uw.set("disable", 1).set("del_flag", 1)
                .eq("id", pojo.getId());
        if (service.update(uw)) {
            cacheService.delSystemCompanyId(pojo.getCompanyId());
        }
        return getListThy(model);
    }

    /**
     * ========== 加解密 ==========
     */

    /**
     * Signature 加解密
     */
    @PostMapping("/signature/sha1")
    public String SHA1Encoding(@ModelAttribute EncryptPojo pojo, Model model) {
        if (StringUtil.isEmpty(pojo.getToken()) ||
                StringUtil.isEmpty(pojo.getTm())||
                StringUtil.isEmpty(pojo.getNonce())) {
            pojo = new EncryptPojo();
        }else {
            // 生成Signature
            String signature = getSignature(pojo.getToken(), pojo.getTm(), pojo.getNonce());
            pojo.setMsgSignature("生成的Signature： "+signature);
        }
        model.addAttribute("encryptPojo", pojo);
        return "view/basic/common/SHA1";
    }

    /**
     * Signature 加解密
     */
    @GetMapping("/signature/sha1")
    public String SHA1page(@ModelAttribute EncryptPojo pojo, Model model) {
        model.addAttribute("encryptPojo", new EncryptPojo());
        return "view/basic/common/SHA1";
    }

}
