package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 20:47
 * @Author: pengweibiao
 **/
@Data
public class Attachment extends BaseData{

    @XmlElement(name = "type")
    private Integer type;

    @XmlElement(name = "value")
    private String value;

    private FileValue fileValue;

    @XmlTransient
    public Integer getType() {
        return type;
    }

    @XmlTransient
    public String getValue() {
        return value;
    }
}
