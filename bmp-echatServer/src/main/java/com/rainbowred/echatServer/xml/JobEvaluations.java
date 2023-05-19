package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.JobEvaluation;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Desc:
 * @Date: 2022/7/12 12:06
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class JobEvaluations extends BaseData {

    private JobEvaluation jobEvaluation;

}
