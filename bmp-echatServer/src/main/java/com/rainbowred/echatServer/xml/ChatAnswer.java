package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.ChatData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/8 01:12
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class ChatAnswer extends BaseData {

    /**
     * 对话开始类型。1：人工对话开始 2：人工对话结束 3：留言开始 4：留言结束 5：机器人对话开始 6：机器人对话结束
     */
    @XmlElement(name = "chatStatus")
    private int chatStatus;

    /**
     * 对话数据
     */
    private ChatData chatData;

    @XmlTransient
    public int getChatStatus() {
        return chatStatus;
    }
}
