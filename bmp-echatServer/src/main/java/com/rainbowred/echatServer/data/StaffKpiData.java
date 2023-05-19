package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/8 18:41
 * @Author: pengweibiao
 **/
@Data
public class StaffKpiData extends BaseData {

    /**
     * 接待对话的客服ID
     */
    @XmlElement(name = "staffId")
    private String staffId;

    /**
     * 接待对话的客服登录名
     */
    @XmlElement(name = "staffLogname")
    private String staffLogName;

    /**
     * 接待对话的客服姓名
     */
    @XmlElement(name = "staffName")
    private String staffName;

    /**
     * 首次响应时长。单位：秒
     */
    @XmlElement(name = "firstAnswerTime")
    private String firstAnswerTime;

    /**
     * 平均响应时长。单位：秒
     */
    @XmlElement(name = "avgAnswerTime")
    private String avgAnswerTime;

    /**
     * 访客发送消息条数
     */
    @XmlElement(name = "visitorSendMsg")
    private String visitorSendMsg;

    /**
     * 客服发送消息条数
     */
    @XmlElement(name = "staffSendMsg")
    private String staffSendMsg;

    /**
     * 总通话时长
     */
    @XmlElement(name = "duration")
    private String duration;

    @XmlTransient
    public String getStaffId() {
        return staffId;
    }

    @XmlTransient
    public String getStaffLogName() {
        return staffLogName;
    }

    @XmlTransient
    public String getStaffName() {
        return staffName;
    }

    @XmlTransient
    public String getFirstAnswerTime() {
        return firstAnswerTime;
    }

    @XmlTransient
    public String getAvgAnswerTime() {
        return avgAnswerTime;
    }

    @XmlTransient
    public String getVisitorSendMsg() {
        return visitorSendMsg;
    }

    @XmlTransient
    public String getStaffSendMsg() {
        return staffSendMsg;
    }

    @XmlTransient
    public String getDuration() {
        return duration;
    }
}
