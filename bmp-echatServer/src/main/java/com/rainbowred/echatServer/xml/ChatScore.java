package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/7 20:44
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class ChatScore extends BaseData {

    /**
     * 对话记录的ID
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 满意度评价。1：非常不满意 2：不满意 3：一般 4：满意 5：非常满意
     */
    @XmlElement(name = "chatScore")
    private int chatScore;

    /**
     * 评价维度
     */
    @XmlElement(name = "scoreDimension")
    private String scoreDimension;

    /**
     * 评价的内容
     */
    @XmlElement(name = "scoreSuggest")
    private String scoreSuggest;

    /**
     * 接待对话的客服ID
     */
    @XmlElement(name = "chatStaffId")
    private String chatScoreStaffId;

    /**
     * 接待对话的客服登录名
     */
    @XmlElement(name = "chatStaffLogname")
    private String chatScoreStaffLogName;

    /**
     * 接待对话的客服姓名
     */
    @XmlElement(name = "chatStaffName")
    private String chatScoreStaffName;

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public int getChatScore() {
        return chatScore;
    }

    @XmlTransient
    public String getScoreDimension() {
        return scoreDimension;
    }

    @XmlTransient
    public String getScoreSuggest() {
        return scoreSuggest;
    }

    @XmlTransient
    public String getChatScoreStaffId() {
        return chatScoreStaffId;
    }

    @XmlTransient
    public String getChatScoreStaffLogName() {
        return chatScoreStaffLogName;
    }

    @XmlTransient
    public String getChatScoreStaffName() {
        return chatScoreStaffName;
    }
}
