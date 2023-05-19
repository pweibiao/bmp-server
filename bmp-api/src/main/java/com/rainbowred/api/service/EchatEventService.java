package com.rainbowred.api.service;

import com.rainbowred.api.pojo.ServerPojo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc:
 * @Date: 2023/5/15 17:02
 * @Author: pengweibiao
 **/
public interface EchatEventService {

    /**
     * 存储一洽服务器交互事件
     */
    void saveEchatEvent(HttpServletRequest request, ServerPojo pojo);


}
