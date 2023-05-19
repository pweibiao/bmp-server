package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/8 00:57
 * @Author: pengweibiao
 **/
@Data
public class TransferData extends BaseData{

    /**
     * 对话记录的ID
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 对话转接时间
     */
    @XmlElement(name = "transferTime")
    private String transferTime;

    /**
     * 发起转接的客服ID
     */
    @XmlElement(name = "fromStaffId")
    private String fromStaffId;

    /**
     * 发起转接请求的客服登录名
     */
    @XmlElement(name = "fromStaffLogname")
    private String fromStaffLogname;

    /**
     * 发起转接请求的客服名称
     */
    @XmlElement(name = "fromStaffName")
    private String fromStaffName;

    /**
     * 接受转接的客服ID
     */
    @XmlElement(name = "toStaffId")
    private String toStaffId;

    /**
     * 接受转接的客服登陆名
     */
    @XmlElement(name = "toStaffLogname")
    private String toStaffLogName;

    /**
     * 接受转接的客服名称
     */
    @XmlElement(name = "toStaffName")
    private String toStaffName;

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public String getTransferTime() {
        return transferTime;
    }

    @XmlTransient
    public String getFromStaffId() {
        return fromStaffId;
    }

    @XmlTransient
    public String getFromStaffLogname() {
        return fromStaffLogname;
    }

    @XmlTransient
    public String getFromStaffName() {
        return fromStaffName;
    }

    @XmlTransient
    public String getToStaffId() {
        return toStaffId;
    }

    @XmlTransient
    public String getToStaffLogName() {
        return toStaffLogName;
    }

    @XmlTransient
    public String getToStaffName() {
        return toStaffName;
    }

}
