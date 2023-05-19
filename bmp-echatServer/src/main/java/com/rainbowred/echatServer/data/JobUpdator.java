package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/12 11:34
 * @Author: pengweibiao
 **/
@Data
public class JobUpdator extends BaseData{

    @XmlElement(name = "type")
    private Integer type;

    @XmlElement(name = "updaterId")
    private String updaterId;

    @XmlElement(name = "updaterName")
    private String updaterName;

    @XmlTransient
    public Integer getType() {
        return type;
    }

    @XmlTransient
    public String getUpdaterId() {
        return updaterId;
    }

    @XmlTransient
    public String getUpdaterName() {
        return updaterName;
    }
}
