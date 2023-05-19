package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 11:35
 * @Author: pengweibiao
 **/
@Data
public class PageData extends BaseData{

    /**
     * 访问时间
     */
    @XmlElement(name = "visitTime")
    private String visitTime;

    /**
     * 访问页面路径
     */
    @XmlElement(name = "pageUrl")
    private String pageUrl;

    /**
     * 访问页面标题
     */
    @XmlElement(name = "pageTitle")
    private String pageTitle;

    /**
     * 访问页面标题
     */
    @XmlElement(name = "pageUrlAlias")
    private String pageUrlAlias;

    private String visitorId;

    private Long trackRecordId;

    @XmlTransient
    public String getVisitTime() {
        return visitTime;
    }

    @XmlTransient
    public String getPageUrl() {
        return pageUrl;
    }

    @XmlTransient
    public String getPageTitle() {
        return pageTitle;
    }

    @XmlTransient
    public String getPageUrlAlias() {
        return pageUrlAlias;
    }
}
