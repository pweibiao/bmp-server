package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/12 11:30
 * @Author: pengweibiao
 **/
@Data
public class Topic extends BaseData{

    @XmlElement(name = "topicId")
    private Long topicId;

    @XmlElement(name = "topicName")
    private String topicName;

    @XmlTransient
    public Long getTopicId() {
        return topicId;
    }

    @XmlTransient
    public String getTopicName() {
        return topicName;
    }
}
