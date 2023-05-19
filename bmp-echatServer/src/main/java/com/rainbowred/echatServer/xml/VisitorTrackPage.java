package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.TrackData;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Desc:
 * @Date: 2022/7/11 11:54
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class VisitorTrackPage extends BaseData {

    private TrackData trackData;

}
