package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc: 浏览数据
 * @Date: 2022/7/11 11:17
 * @Author: pengweibiao
 **/
@Data
public class TrackData extends BaseData{

    /**
     * 访客ID。身份描述+ID
     */
    @XmlElement(name = "visitorId")
    private String visitorId;

    /**
     * 此次浏览轨迹的ID
     */
    @XmlElement(name = "trackRecordId")
    private Long trackRecordId;

    /**
     * 访客退出时此次浏览页面的数量
     */
    @XmlElement(name = "visitPageCount")
    private Integer visitPageCount;

    /**
     * 此次浏览页面访客的总浏览时长 单位：秒
     */
    @XmlElement(name = "visitTotalTime")
    private Long visitTotalTime;

    /**
     * 整个会话范围过程产生的人工对话的ID、机器人对话的ID、留言对话的ID列表
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 整个会话范围过程中，访客点击对话，弹出信息收集框但访客最终未进入对话的，放弃的记录ID，记录ID是点击的ID，和对话记录留言记录的ID不是同一个数据
     */
    @XmlElement(name = "giveUpRecordId")
    private String giveUpRecordId;

    /**
     * 访客的离开的时间
     */
    @XmlElement(name = "visitorOutTime")
    private String visitorOutTime;

    /**
     * 浏览轨迹
     */
    private VisitorPageDatas visitPageDatas;

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public Long getTrackRecordId() {
        return trackRecordId;
    }

    @XmlTransient
    public Integer getVisitPageCount() {
        return visitPageCount;
    }

    @XmlTransient
    public Long getVisitTotalTime() {
        return visitTotalTime;
    }

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public String getGiveUpRecordId() {
        return giveUpRecordId;
    }

    @XmlTransient
    public String getVisitorOutTime() {
        return visitorOutTime;
    }

}
