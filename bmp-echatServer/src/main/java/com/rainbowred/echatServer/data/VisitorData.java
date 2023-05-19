package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/7 19:35
 * @Author: pengweibiao
 **/
@Data
public class VisitorData extends BaseData {

    /**
     * 访客进入的时间
     */
    @XmlElement(name = "visitorEnterTime")
    private String visitorEnterTime;

    /**
     * 客户端媒介。1：PC网页 2：手机网页 5：微信 6：sdk 9：自定义渠道
     */
    @XmlElement(name = "visitorMedia")
    private Integer visitorMedia;

    /**
     * 访客身份类型。—1：未知 0：游客(web) 1：会员(vip) 2：SDK游客(sdk) 4：微信(wechat) 5：自定义接口(custom)
     */
    @XmlElement(name = "visitorType")
    private Integer visitorType;

    /**
     * 访客唯一值。身份描述+ID
     */
    @XmlElement(name = "visitorId")
    private String visitorId;

    /**
     * 渠道ID。type=5，自定义渠道时有效
     */
    @XmlElement(name = "mediaId")
    private String mediaId;

    /**
     * 访客姓名
     */
    @XmlElement(name = "visitorName")
    private String visitorName;

    /**
     * 访客头像
     */
    @XmlElement(name = "visitorPhoto")
    private String visitorPhoto;

    /**
     * 访客来访次数
     */
    @XmlElement(name = "visitTimes")
    private Integer visitTimes;

    /**
     * 访客语言
     */
    @XmlElement(name = "visitorLan")
    private String visitorLan;

    /**
     * 访客来访IP
     */
    @XmlElement(name = "visitorIp")
    private String visitorIp;

    /**
     * 访客所在国家
     */
    @XmlElement(name = "visitorCountry")
    private String visitorCountry;

    /**
     * 访客所在省份
     */
    @XmlElement(name = "visitorProvince")
    private String visitorProvince;

    /**
     * 访客所在城市
     */
    @XmlElement(name = "visitorCity")
    private String visitorCity;

    /**
     * 访客的浏览器
     */
    @XmlElement(name = "browserName")
    private String browserName;

    /**
     * 访客的浏览器版本
     */
    @XmlElement(name = "browserVersion")
    private String browserVersion;

    /**
     * 访客的屏幕分辨率
     */
    @XmlElement(name = "screenResolution")
    private String screenResolution;

    /**
     * 访客操作系统
     */
    @XmlElement(name = "osName")
    private String osName;

    /**
     * 操作系统版本
     */
    @XmlElement(name = "osVersion")
    private String osVersion;

    /**
     * 访客来访的搜索引擎
     */
    @XmlElement(name = "se")
    private String se;

    /**
     * 访客来访的搜索关键字
     */
    @XmlElement(name = "keyword")
    private String keyword;

    /**
     * 推广词
     */
    @XmlElement(name = "biddingWord")
    private String biddingWord;

    /**
     * 关键词类型。0：未区分SEO、推广 1：自然优化 2： 推广
     */
    @XmlElement(name = "keywordType")
    private String keywordType;

    /**
     * 访客来源的URL。如果是微信，就是公众号名
     */
    @XmlElement(name = "referPage")
    private String referPage;

    /**
     * 进入网站的时间
     */
    @XmlElement(name = "firstTime")
    private String firstTime;

    /**
     * 落地页
     */
    @XmlElement(name = "firstPage")
    private String firstPage;

    /**
     * 落地页面标题
     */
    @XmlElement(name = "firstPageTitle")
    private String firstPageTitle;

    /**
     * 落地页面别名
     */
    @XmlElement(name = "firstPageAliae")
    private String firstPageAliae;

    /**
     * 上次对话时间
     */
    @XmlElement(name = "lastChatTime")
    private String lastChatTime;

    /**
     * 上次对话客服ID
     */
    @XmlElement(name = "lastChatStaffId")
    private Long lastChatStaffId;

    /**
     * 上次对话客服账号
     */
    @XmlElement(name = "lastChatStaffLogname")
    private String lastChatStaffLogName;

    /**
     * 上次对话客服姓名
     */
    @XmlElement(name = "lastChatStaffName")
    private String lastChatStaffName;

    @XmlTransient
    public String getVisitorEnterTime() {
        return visitorEnterTime;
    }

    @XmlTransient
    public Integer getVisitorMedia() {
        return visitorMedia;
    }

    @XmlTransient
    public Integer getVisitorType() {
        return visitorType;
    }

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public String getMediaId() {
        return mediaId;
    }

    @XmlTransient
    public String getVisitorName() {
        return visitorName;
    }

    @XmlTransient
    public String getVisitorPhoto() {
        return visitorPhoto;
    }

    @XmlTransient
    public Integer getVisitTimes() {
        return visitTimes;
    }

    @XmlTransient
    public String getVisitorLan() {
        return visitorLan;
    }

    @XmlTransient
    public String getVisitorIp() {
        return visitorIp;
    }

    @XmlTransient
    public String getVisitorCountry() {
        return visitorCountry;
    }

    @XmlTransient
    public String getVisitorProvince() {
        return visitorProvince;
    }

    @XmlTransient
    public String getVisitorCity() {
        return visitorCity;
    }

    @XmlTransient
    public String getBrowserName() {
        return browserName;
    }

    @XmlTransient
    public String getBrowserVersion() {
        return browserVersion;
    }

    @XmlTransient
    public String getScreenResolution() {
        return screenResolution;
    }

    @XmlTransient
    public String getOsName() {
        return osName;
    }

    @XmlTransient
    public String getOsVersion() {
        return osVersion;
    }

    @XmlTransient
    public String getSe() {
        return se;
    }

    @XmlTransient
    public String getKeyword() {
        return keyword;
    }

    @XmlTransient
    public String getBiddingWord() {
        return biddingWord;
    }

    @XmlTransient
    public String getKeywordType() {
        return keywordType;
    }

    @XmlTransient
    public String getReferPage() {
        return referPage;
    }

    @XmlTransient
    public String getFirstTime() {
        return firstTime;
    }

    @XmlTransient
    public String getFirstPage() {
        return firstPage;
    }

    @XmlTransient
    public String getFirstPageTitle() {
        return firstPageTitle;
    }

    @XmlTransient
    public String getFirstPageAliae() {
        return firstPageAliae;
    }

    @XmlTransient
    public String getLastChatTime() {
        return lastChatTime;
    }

    @XmlTransient
    public Long getLastChatStaffId() {
        return lastChatStaffId;
    }

    @XmlTransient
    public String getLastChatStaffLogName() {
        return lastChatStaffLogName;
    }

    @XmlTransient
    public String getLastChatStaffName() {
        return lastChatStaffName;
    }
}

