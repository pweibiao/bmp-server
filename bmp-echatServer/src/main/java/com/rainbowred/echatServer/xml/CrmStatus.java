package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.CrmData;
import com.rainbowred.echatServer.data.OwnerData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/26 22:01
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class CrmStatus extends BaseData {

    @XmlElement(name = "visitorId")
    private String visitorId;

    @XmlElement(name = "crmStatus")
    private String crmStatus;

    @XmlElement(name = "staffId")
    private Long staffId;

    @XmlElement(name = "staffLogname")
    private String staffLogname;

    @XmlElement(name = "staffName")
    private String staffName;

    private CrmData crmData;

    private OwnerData ownerData;

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public String getCrmStatus() {
        return crmStatus;
    }

    @XmlTransient
    public Long getStaffId() {
        return staffId;
    }

    @XmlTransient
    public String getStaffLogname() {
        return staffLogname;
    }

    @XmlTransient
    public String getStaffName() {
        return staffName;
    }
}
