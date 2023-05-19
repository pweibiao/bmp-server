package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/25 20:57
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class StaffStatusXml extends BaseData {

    @XmlElement(name = "staffStatus")
    private int staffStatus;

    @XmlElement(name = "staffId")
    private Long staffId;

    @XmlElement(name = "staffName")
    private String staffName;

    @XmlElement(name = "staffLogname")
    private String staffLogname;

    @XmlTransient
    public int getStaffStatus() {
        return staffStatus;
    }

    @XmlTransient
    public Long getStaffId() {
        return staffId;
    }

    @XmlTransient
    public String getStaffName() {
        return staffName;
    }

    @XmlTransient
    public String getStaffLogname() {
        return staffLogname;
    }
}
