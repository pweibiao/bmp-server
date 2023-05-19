package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import lombok.Data;


/**
 * 客服Kpi数据
 * @TableName bmp_server_chat_record_staff_kpi
 */
@Data
@TableName(value ="bmp_server_chat_record_staff_kpi")
public class BmpServerChatRecordStaffKpi extends BaseBizDomain {

    /**
     * 客服ID
     */
    private String staffId;

    /**
     * 客服账号
     */
    private String staffLogname;

    /**
     * 客服姓名
     */
    private String staffName;

    /**
     * 首次响应时长。单位：秒
     */
    private Integer firstAnswerTime;

    /**
     * 平均响应时长。单位：秒
     */
    private Integer avgAnswerTime;

    /**
     * 访客发送消息条数
     */
    private Integer visitorSendMsg;

    /**
     * 客服发送消息条数
     */
    private Integer staffSendMsg;

    /**
     * 总通话时长。单位：秒
     */
    private Integer duration;

    /**
     * 对话记录ID
     */
    private String chatRecordId;
}
