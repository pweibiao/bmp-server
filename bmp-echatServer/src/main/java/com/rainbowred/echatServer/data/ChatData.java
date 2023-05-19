package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/7 20:12
 * @Author: pengweibiao
 **/
@Data
public class ChatData extends BaseData{
    /**
     * 对话页面
     */
    @XmlElement(name = "chatPage")
    private String chatPage;

    /**
     * 对话标题
     */
    @XmlElement(name = "chatPageTitle")
    private String chatPageTitle;

    /**
     * 对话次数
     */
    @XmlElement(name = "chatTimes")
    private Integer chatTimes;

    /**
     * 对话发起的方式。1：点击图标 2：接受邀请对话 3：客服主动对话 4：微信输入任意文字接入对话 5：微信点击菜单接入 6：微信输入指定文字接入 7：微信机器人转人工 11：机器人转人工 12：机器人转留言 14：web自动弹屏自动接入 15：web自动弹屏访客输入消息接入 16：商户留言转平台接入 17：微信开发者接入 18：自定义渠道事件接入 19：自定义渠道发送消息接入
     */
    @XmlElement(name = "chatEvent")
    private Integer chatEvent;

    /**
     * 请求对话的时间
     */
    @XmlElement(name = "chatRequestTime")
    private String chatRequestTime;

    /**
     * 对话接通时间
     */
    @XmlElement(name = "chatAnswerTime")
    private String chatAnswerTime;

    /**
     * 会话类型。1：在线对话 2：忙碌对话3：离线消息 5：机器人对话
     */
    @XmlElement(name = "chatType")
    private Integer chatType;

    /**
     * 接待对话的客服ID
     */
    @XmlElement(name = "chatStaffId")
    private Long chatStaffId;

    /**
     * 接待对话的客服登录名
     */
    @XmlElement(name = "chatStaffLogname")
    private String chatStaffLogName;

    /**
     * 接待对话的客服姓名
     */
    @XmlElement(name = "chatStaffName")
    private String chatStaffName;

    /**
     * 接待对话的客服的内部角色名称
     */
    @XmlElement(name = "chatStaffRole")
    private String chatStaffRole;

    /**
     * 对话入口
     */
    @XmlElement(name = "chatEntrance")
    private String chatEntrance;

    /**
     * 对话记录的ID
     */
    @XmlElement(name = "chatRecordId")
    private String chatRecordId;

    /**
     * 访客等待时长。单位：秒
     */
    @XmlElement(name = "chatWaitTime")
    private Long chatWaitTime;

    /**
     * 本次分配对话的分组ID。如果是全部人员可接待则ID为0
     */
    @XmlElement(name = "chatDepartmentId")
    private Long chatDepartmentId;

    /**
     * 本地分配对话的分组名称。如果是全部人员可接待则为空
     */
    @XmlElement(name = "chatDepartmentName")
    private String chatDepartmentName;

    /**
     * 访客唯一值。身份描述+ID
     */
    @XmlElement(name = "visitorId")
    private String visitorId;

    /**
     * 对话结束时间
     */
    @XmlElement(name = "chatEndTime")
    private String chatEndTime;

    /**
     * 对话结束方式。0：未知 1：访客结束对话 2：客服结束对话 3：访客超时 5：客服退出 6：系统关闭 8：访客长时间未回复结束 12：忙碌放弃结束 14：留言超时结束 15：机器人自动转人工结束 16：机器人手动转人工结束 18：客服主动对话后留言/机器人对话结束
     */
    @XmlElement(name = "chatEndType")
    private Integer chatEndType;

    /**
     * 通话时长。单位：毫秒
     */
    @XmlElement(name = "chatTotalTime")
    private Long chatTotalTime;

    /**
     * 首次响应时长。单位：毫秒
     */
    @XmlElement(name = "firstAnswerTime")
    private Long firstAnswerTime;

    /**
     * 平均响应时长。单位：毫秒
     */
    @XmlElement(name = "avgAnswerTime")
    private Long avgAnswerTime;

    /**
     * 访客发送消息条数
     */
    @XmlElement(name = "visitorSendMsg")
    private Integer visitorSendMsg;

    /**
     * 客服发送消息条数
     */
    @XmlElement(name = "staffSendMsg")
    private Integer staffSendMsg;

    /**
     * 是否邀评。1：是 2：否
     */
    @XmlElement(name = "activelyInviteEvaluating")
    private Integer activelyInviteEvaluating;

    /**
     * 完美匹配数。机器人对话有效
     */
    @XmlElement(name = "perfectMatchs")
    private Integer perfectMatchs;

    /**
     * 精准匹配数。机器人对话有效
     */
    @XmlElement(name = "exactMatchs")
    private Integer exactMatchs;

    /**
     * 相似匹配数。机器人对话有效
     */
    @XmlElement(name = "similarityMatchs")
    private Integer similarityMatchs;

    /**
     * 未命中数。机器人对话有效
     */
    @XmlElement(name = "misMatchCount")
    private Integer misMatchCount;

    /**
     * 点击解决数。机器人对话有效
     */
    @XmlElement(name = "solvedCount")
    private Integer solvedCount;

    /**
     * 点击未解决数。机器人对话有效
     */
    @XmlElement(name = "unsolvedCount")
    private Integer unsolvedCount;

    /**
     * 对话内通
     */
    @XmlElement(name = "chatContent")
    private String chatContent;

    @XmlTransient
    public String getChatPage() {
        return chatPage;
    }

    @XmlTransient
    public String getChatPageTitle() {
        return chatPageTitle;
    }

    @XmlTransient
    public Integer getChatTimes() {
        return chatTimes;
    }

    @XmlTransient
    public Integer getChatEvent() {
        return chatEvent;
    }

    @XmlTransient
    public String getChatRequestTime() {
        return chatRequestTime;
    }

    @XmlTransient
    public String getChatAnswerTime() {
        return chatAnswerTime;
    }

    @XmlTransient
    public Integer getChatType() {
        return chatType;
    }

    @XmlTransient
    public Long getChatStaffId() {
        return chatStaffId;
    }

    @XmlTransient
    public String getChatStaffLogName() {
        return chatStaffLogName;
    }

    @XmlTransient
    public String getChatStaffName() {
        return chatStaffName;
    }

    @XmlTransient
    public String getChatStaffRole() {
        return chatStaffRole;
    }

    @XmlTransient
    public String getChatEntrance() {
        return chatEntrance;
    }

    @XmlTransient
    public String getChatRecordId() {
        return chatRecordId;
    }

    @XmlTransient
    public Long getChatWaitTime() {
        return chatWaitTime;
    }

    @XmlTransient
    public Long getChatDepartmentId() {
        return chatDepartmentId;
    }

    @XmlTransient
    public String getChatDepartmentName() {
        return chatDepartmentName;
    }

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public String getChatEndTime() {
        return chatEndTime;
    }

    @XmlTransient
    public Integer getChatEndType() {
        return chatEndType;
    }

    @XmlTransient
    public Long getChatTotalTime() {
        return chatTotalTime;
    }

    @XmlTransient
    public Long getFirstAnswerTime() {
        return firstAnswerTime;
    }

    @XmlTransient
    public Long getAvgAnswerTime() {
        return avgAnswerTime;
    }

    @XmlTransient
    public Integer getVisitorSendMsg() {
        return visitorSendMsg;
    }

    @XmlTransient
    public Integer getStaffSendMsg() {
        return staffSendMsg;
    }

    @XmlTransient
    public Integer getActivelyInviteEvaluating() {
        return activelyInviteEvaluating;
    }

    @XmlTransient
    public Integer getPerfectMatchs() {
        return perfectMatchs;
    }

    @XmlTransient
    public Integer getExactMatchs() {
        return exactMatchs;
    }

    @XmlTransient
    public Integer getSimilarityMatchs() {
        return similarityMatchs;
    }

    @XmlTransient
    public Integer getMisMatchCount() {
        return misMatchCount;
    }

    @XmlTransient
    public Integer getSolvedCount() {
        return solvedCount;
    }

    @XmlTransient
    public Integer getUnsolvedCount() {
        return unsolvedCount;
    }

    @XmlTransient
    public String getChatContent() {
        return chatContent;
    }
}
