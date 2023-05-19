package com.rainbowred.echatServer.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseBizDomain;

import com.rainbowred.echatServer.data.PageData;
import lombok.Data;

/**
 * 浏览轨迹
 * @TableName bmp_server_track_record_page
 */
@Data
@TableName(value ="bmp_server_track_record_page")
public class BmpServerTrackRecordPage extends BaseBizDomain {

    public BmpServerTrackRecordPage() {}

    /**
     * 访客浏览数据
     */
    public BmpServerTrackRecordPage(PageData pojo) {
        if (StringUtil.nonEmpty(pojo.getVisitTime())) {
            this.visitTime = StringUtil.dateStringTransfer(pojo.getVisitTime());
        }
        this.pageUrl = pojo.getPageUrl();
        this.pageTitle = pojo.getPageTitle();
    }

    /**
     * 访客ID
     */
    private String visitorId;

    /**
     * 访客本次会话ID
     */
    private Long trackRecordId;

    /**
     * 访问时间
     */
    private Date visitTime;

    /**
     * 页面路径
     */
    private String pageUrl;

    /**
     * 页面标题
     */
    private String pageTitle;
}
