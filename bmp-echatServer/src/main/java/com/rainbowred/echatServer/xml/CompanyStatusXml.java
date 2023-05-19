package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/25 19:51
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class CompanyStatusXml extends BaseData {

    @XmlElement(name = "companyStatus")
    private int companyStatus;

    @XmlTransient
    public int getCompanyStatus() {
        return companyStatus;
    }
}
