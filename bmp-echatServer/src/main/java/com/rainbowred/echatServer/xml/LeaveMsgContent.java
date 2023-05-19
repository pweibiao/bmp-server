package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.ChatData;
import com.rainbowred.echatServer.data.CrmData;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Desc:
 * @Date: 2022/7/8 01:20
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class LeaveMsgContent extends BaseData {

    /**
     * 对话数据
     */
    private ChatData chatData;

    /**
     * 客户数据
     */
    private CrmData crmData;

}
