package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/12 12:08
 * @Author: pengweibiao
 **/
@Data
public class JobEvaluation extends BaseData{

    @XmlElement(name = "jobId")
    private Long jobId;

    @XmlElement(name = "evaluateDatetime")
    private Long evaluateDatetime;

    @XmlElement(name = "mainItem")
    private Integer mainItem;

    @XmlElement(name = "comment")
    private String comment;

    private Subitems subItems;

    @XmlTransient
    public Long getJobId() {
        return jobId;
    }

    @XmlTransient
    public Long getEvaluateDatetime() {
        return evaluateDatetime;
    }

    @XmlTransient
    public Integer getMainItem() {
        return mainItem;
    }

    @XmlTransient
    public String getComment() {
        return comment;
    }
}
