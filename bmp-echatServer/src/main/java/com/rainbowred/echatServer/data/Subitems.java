package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @Desc:
 * @Date: 2022/7/12 12:30
 * @Author: pengweibiao
 **/
@Data
public class Subitems extends BaseData{

    @XmlElement(name = "string")
    public List<String> string;

    @XmlTransient
    public List<String> getString() {
        return string;
    }
}
