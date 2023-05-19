package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.JobData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 21:08
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class JobUpdated extends BaseData {

    @XmlElement(name = "jobId")
    private Long jobId;

    @XmlElement(name = "jobAttribute")
    private Integer jobAttribute;

    private JobData jobData;

    @XmlTransient
    public Long getJobId() {
        return jobId;
    }

    @XmlTransient
    public Integer getJobAttribute() {
        return jobAttribute;
    }

}
