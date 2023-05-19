package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.OwnerData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/7 21:09
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class LeaveMsgOwner extends BaseData {

    /**
     * 访客唯一值。身份描述+ID
     */
    @XmlElement(name = "visitorId")
    private String visitorId;

    /**
     * 对话记录的ID
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 分配者客服ID
     */
    @XmlElement(name = "staffId")
    private Long staffId;

    /**
     * 分配者客服账号
     */
    @XmlElement(name = "staffLogname")
    private String staffLogName;

    /**
     * 分配者客服姓名
     */
    @XmlElement(name = "staffName")
    private String staffName;

    /**
     * 留言分配的客服
     */
    private OwnerData ownerData;

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public Long getStaffId() {
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

}
