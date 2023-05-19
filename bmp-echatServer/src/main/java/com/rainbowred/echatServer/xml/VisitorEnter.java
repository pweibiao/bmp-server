package com.rainbowred.echatServer.xml;

import com.rainbowred.echatServer.data.*;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 11:14
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class VisitorEnter extends BaseData {

    /**
     * 开发者自定义扩展数据
     */
    @XmlElement(name = "myData")
    private String myData;

    /**
     * 会员数据
     */
    private MetaData metaData;

    /**
     * 访客数据
     */
    private VisitorData visitorData;

    /**
     * 路由数据
     */
    private RouteData routeData;

    /**
     * 轨迹数据
     */
    private TrackData trackData;

    @XmlTransient
    public String getMyData() {
        return myData;
    }
}
