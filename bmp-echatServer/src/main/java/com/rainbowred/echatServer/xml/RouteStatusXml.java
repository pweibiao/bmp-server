package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/25 20:40
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class RouteStatusXml extends BaseData {

    @XmlElement(name = "routeStatus")
    private int routeStatus;

    @XmlElement(name = "routeId")
    private Long routeId;

    @XmlElement(name = "routeName")
    private String routeName;

    @XmlTransient
    public int getRouteStatus() {
        return routeStatus;
    }

    @XmlTransient
    public Long getRouteId() {
        return routeId;
    }

    @XmlTransient
    public String getRouteName() {
        return routeName;
    }
}
