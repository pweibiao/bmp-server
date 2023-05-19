package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/7 20:07
 * @Author: pengweibiao
 **/
@Data
public class RouteData extends BaseData{

    /**
     * 接入对话的路由ID。—1：web访客的默认路由 —2：微信对话的默认路由 —3：SDK对话的默认路由
     */
    @XmlElement(name = "routeId")
    private Long routeId;

    /**
     * 路由名称
     */
    @XmlElement(name = "routeName")
    private String routeName;

    /**
     * 路由所使用的样式ID
     */
    @XmlElement(name = "styleId")
    private Long styleId;

    /**
     * 路由所使用样式的名称
     */
    @XmlElement(name = "styleName")
    private String styleName;

    /**
     * 本次分配对话的分组ID。如果是全部人员可接待则ID为0
     */
    @XmlElement(name = "chatDepartmentId")
    private Long chatDepartmentId;

    /**
     * 本地分配对话的分组名称。如果是全部人员可接待则为空
     */
    @XmlElement(name = "chatDepartmentName")
    private String chatDepartmentName;

    /**
     * 指定路由的状态。1：在线 2：离线
     */
    @XmlElement(name = "routeStatus")
    private Integer routeStatus;

    @XmlTransient
    public Long getRouteId() {
        return routeId;
    }

    @XmlTransient
    public String getRouteName() {
        return routeName;
    }

    @XmlTransient
    public Long getStyleId() {
        return styleId;
    }

    @XmlTransient
    public String getStyleName() {
        return styleName;
    }

    @XmlTransient
    public Long getChatDepartmentId() {
        return chatDepartmentId;
    }

    @XmlTransient
    public String getChatDepartmentName() {
        return chatDepartmentName;
    }

    @XmlTransient
    public Integer getRouteStatus() {
        return routeStatus;
    }
}
