package com.rainbowred.echatServer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.basic.service.SystemCompanyService;
import com.rainbowred.common.controller.BaseController;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.echatServer.domain.*;
import com.rainbowred.echatServer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @Date: 2023/5/17 15:16
 * @Author: pengweibiao
 **/
@Controller
@RequestMapping("/echatServer/data")
@Slf4j
public class ServerDataController extends BaseController {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private SystemCompanyService companyService;

    @Autowired
    private SystemCompanyCacheService companyCacheService;

    @Autowired
    private BmpServerApiLogService apiLogService;

    @Autowired
    private BmpServerCompanyStatusService companyStatusService;

    @Autowired
    private BmpServerRouteStatusService routeStatusService;

    @Autowired
    private BmpServerSkillStatusService skillStatusService;

    @Autowired
    private BmpServerStaffStatusService staffStatusService;

    @Autowired
    private BmpServerChatRecordService chatRecordService;

    @GetMapping("/{dataType}/list")
    public String getList(Model model,
                                      @PathVariable("dataType") String dataType,
                                      @ModelAttribute BmpServerApiLog pojo) {
        // 传入的companyId
        String companyId = pojo.getCompanyId();
        if (StringUtil.isEmpty(companyId)) {
            companyId = "选择公司ID";
        }
        // 公司列表
        QueryWrapper<SystemCompany> compQW = new QueryWrapper<>();
        compQW.select("company_id", "name").eq("disable", 0).eq("del_flag", 0);
        List<SystemCompany> companyList = companyService.list(compQW);
        model.addAttribute("companyList", companyList);
        model.addAttribute("companyId", companyId);
        String companyName = " - ";
        SystemCompany systemCompanyConfig = companyCacheService.getSystemCompanyConfig(companyId);
        if (Objects.nonNull(systemCompanyConfig)) {
            companyName = systemCompanyConfig.getName();
        }
        model.addAttribute("companyName", companyName);
        switch (dataType) {
            case "apiLog":
                QueryWrapper<BmpServerApiLog> apiLogQueryWrapper = new QueryWrapper<>();
                apiLogQueryWrapper.orderBy(true, false, "timestamp")
                        .eq("company_id", companyId);
                List<BmpServerApiLog> apiLogs = apiLogService.list(apiLogQueryWrapper);
                if (!CollectionUtils.isEmpty(apiLogs)) {
                    apiLogs.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setTimeEd();
                    });
                }
                model.addAttribute("apiLogs", apiLogs);
                break;
            case "companyStatus":
                QueryWrapper<BmpServerCompanyStatus> companyStatusQueryWrapper = new QueryWrapper<>();
                companyStatusQueryWrapper.orderBy(true, false, "create_date")
                        .eq("company_id", companyId);
                List<BmpServerCompanyStatus> companyStatuses = companyStatusService.list(companyStatusQueryWrapper);
                if (!CollectionUtils.isEmpty(companyStatuses)) {
                    companyStatuses.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setUpdateDateStr(format);
                    });
                }
                model.addAttribute("companyStatuses", companyStatuses);
                break;
            case "routeStatus":
                QueryWrapper<BmpServerRouteStatus> routeStatusQueryWrapper = new QueryWrapper<>();
                routeStatusQueryWrapper.orderBy(true, false, "create_date")
                        .eq("company_id", companyId);
                List<BmpServerRouteStatus> routeStatuses = routeStatusService.list(routeStatusQueryWrapper);
                if (!CollectionUtils.isEmpty(routeStatuses)) {
                    routeStatuses.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setUpdateDateStr(format);
                    });
                }
                model.addAttribute("routeStatuses", routeStatuses);
                break;
            case "skillStatus":
                QueryWrapper<BmpServerSkillStatus> skillStatusQueryWrapper = new QueryWrapper<>();
                skillStatusQueryWrapper.orderBy(true, false, "create_date")
                        .eq("company_id", companyId);
                List<BmpServerSkillStatus> skillStatuses = skillStatusService.list(skillStatusQueryWrapper);
                if (!CollectionUtils.isEmpty(skillStatuses)) {
                    skillStatuses.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setUpdateDateStr(format);
                    });
                }
                model.addAttribute("skillStatuses", skillStatuses);
                break;
            case "staffStatus":
                QueryWrapper<BmpServerStaffStatus> staffStatusQueryWrapper = new QueryWrapper<>();
                staffStatusQueryWrapper.orderBy(true, false, "create_date")
                        .eq("company_id", companyId);
                List<BmpServerStaffStatus> staffStatuses = staffStatusService.list(staffStatusQueryWrapper);
                if (!CollectionUtils.isEmpty(staffStatuses)) {
                    staffStatuses.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setUpdateDateStr(format);
                    });
                }
                model.addAttribute("staffStatuses", staffStatuses);
                break;
            case "chatRecord":
                QueryWrapper<BmpServerChatRecord> chatRecordQueryWrapper = new QueryWrapper<>();
                chatRecordQueryWrapper.orderBy(true, false, "create_date")
                        .eq("company_id", companyId);
                List<BmpServerChatRecord> chatRecords = chatRecordService.list(chatRecordQueryWrapper);
                if (!CollectionUtils.isEmpty(chatRecords)) {
                    chatRecords.stream().forEach(o -> {
                        o.setCreateDateStr(format);
                        o.setUpdateDateStr(format);
                    });
                }
                model.addAttribute("chatRecords", chatRecords);
                break;
            default:
                model.addAttribute("apiLogs", Lists.newArrayList());
                return "view/echatServer/apiLog";
        }
        return "view/echatServer/"+dataType;
    }

    @GetMapping("/apiLog/del")
    public String getList(Model model, @ModelAttribute BmpServerApiLog pojo) {
        String companyId = pojo.getCompanyId();
        if (StringUtil.nonEmpty(companyId)) {
            QueryWrapper<BmpServerApiLog> qw = new QueryWrapper<>();
            qw.eq("company_id", companyId);
            apiLogService.remove(qw);
        }
        return getList(model, "apiLog", pojo);
    }

}
