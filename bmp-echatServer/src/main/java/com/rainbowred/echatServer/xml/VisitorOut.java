package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.TrackData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 11:51
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class VisitorOut extends BaseData {

    /**
     * 路由状态
     */
    @XmlElement(name = "routeStatus")
    private Integer routeStatus;

    /**
     * 浏览轨迹数据
     */
    private TrackData trackData;

    @XmlTransient
    public Integer getRouteStatus() {
        return routeStatus;
    }
}
