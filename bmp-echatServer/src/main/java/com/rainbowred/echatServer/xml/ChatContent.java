package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.ChatData;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Desc:
 * @Date: 2022/7/8 01:04
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class ChatContent extends BaseData {

    /**
     * 对话数据
     */
    private ChatData chatData;

}
