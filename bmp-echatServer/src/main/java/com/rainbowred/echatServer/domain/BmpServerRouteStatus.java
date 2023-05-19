package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.xml.RouteStatusXml;
import lombok.Data;

/**
 * 路由状态
 * @TableName bmp_server_route_status
 */
@Data
@TableName(value ="bmp_server_route_status")
public class BmpServerRouteStatus extends BaseBizDomain {

    public BmpServerRouteStatus(){}

    public BmpServerRouteStatus(RouteStatusXml pojo) {
        this.routeStatus = pojo.getRouteStatus();
        this.routeId = pojo.getRouteId();
        this.routeName = pojo.getRouteName();
    }

    /**
     * 路由状态。1：在线，2：离线
     */
    private Integer routeStatus;

    /**
     * 路由ID
     */
    private Long routeId;

    /**
     * 路由名称
     */
    private String routeName;
}
