package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/8 00:12
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class ChatSubject extends BaseData {

    /**
     * 对话记录的ID
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 对话评估的主题
     */
    @XmlElement(name = "chatSubject")
    private String chatSubject;

    /**
     * 对话评估备注
     */
    @XmlElement(name = "chatSubjectMemo")
    private String chatSubjectMemo;

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public String getChatSubject() {
        return chatSubject;
    }

    @XmlTransient
    public String getChatSubjectMemo() {
        return chatSubjectMemo;
    }
}
