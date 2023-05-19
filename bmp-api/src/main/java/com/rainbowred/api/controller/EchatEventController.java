package com.rainbowred.api.controller;

import com.rainbowred.api.pojo.ServerPojo;
import com.rainbowred.api.service.EchatEventService;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.common.controller.BaseController;
import com.rainbowred.common.util.EchatUtil;
import com.rainbowred.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc:
 * @Date: 2023/5/15 08:42
 * @Author: pengweibiao
 **/
@RestController
@RequestMapping("/api")
@Slf4j
public class EchatEventController extends BaseController {

    @Autowired
    private EchatEventService eventService;

    @Autowired
    private SystemCompanyCacheService companyCacheService;

    /**
     * 一洽服务器交互接口
     * @param serverPojo
     * @param xml
     * @return
     */
    @PostMapping("/interaction")
    public String interaction(HttpServletRequest request,
                              @ModelAttribute ServerPojo serverPojo,
                              @RequestBody(required = false) String xml) {
        String echostr = serverPojo.getEchostr();
        if (StringUtil.isEmpty(echostr)){
            try {
                // 校验Signature有效
                if (validSignature(
                        companyCacheService.getCompanyToken(serverPojo.getCompanyId()),
                        serverPojo.getSignature(),
                        serverPojo.getTimestamp().toString(),
                        serverPojo.getNonce())
                ) {
                    serverPojo.setXml(xml);
                    // 处理一洽服务器交互事件
                    eventService.saveEchatEvent(request, serverPojo);
                    return EchatUtil.SUCCESS;
                }else {
                    log.info("=====EchatEventController-interaction=====error=====Signature不通过");
                }
            } catch (Exception e) {
                log.info("=====EchatEventController-interaction=====error=====xml:"+ xml);
            }
        }else {
            return echostr;
        }
        return EchatUtil.SUCCESS;
    }


}
