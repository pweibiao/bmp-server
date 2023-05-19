package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/25 20:44
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class SkillStatusXml extends BaseData {

    @XmlElement(name = "skillStatus")
    private int skillStatus;

    @XmlElement(name = "skillId")
    private Long skillId;

    @XmlElement(name = "skillName")
    private String skillName;

    @XmlTransient
    public int getSkillStatus() {
        return skillStatus;
    }

    @XmlTransient
    public Long getSkillId() {
        return skillId;
    }

    @XmlTransient
    public String getSkillName() {
        return skillName;
    }
}
