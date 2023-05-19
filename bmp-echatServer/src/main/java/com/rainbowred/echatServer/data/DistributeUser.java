package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/12 11:32
 * @Author: pengweibiao
 **/
@Data
public class DistributeUser extends BaseData{

    @XmlElement(name = "staffId")
    private Long staffId;

    @XmlElement(name = "staffName")
    private String staffName;

    @XmlElement(name = "staffRole")
    private String staffRole;

    @XmlElement(name = "staffLogname")
    private String staffLogName;

    @XmlTransient
    public Long getStaffId() {
        return staffId;
    }

    @XmlTransient
    public String getStaffName() {
        return staffName;
    }

    @XmlTransient
    public String getStaffRole() {
        return staffRole;
    }

    @XmlTransient
    public String getStaffLogName() {
        return staffLogName;
    }
}
