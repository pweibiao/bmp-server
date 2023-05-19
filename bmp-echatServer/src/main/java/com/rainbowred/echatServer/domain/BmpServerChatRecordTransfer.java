package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.data.TransferData;
import com.rainbowred.echatServer.xml.ChatTransfer;
import lombok.Data;

import java.util.Date;

/**
 * 对话转接
 * @TableName bmp_server_chat_record_transfer
 */
@Data
@TableName(value ="bmp_server_chat_record_transfer")
public class BmpServerChatRecordTransfer extends BaseBizDomain {

    public BmpServerChatRecordTransfer() {}

    public BmpServerChatRecordTransfer(ChatTransfer pojo) {
        TransferData transferData = pojo.getTransferData();
        if (transferData != null) {
            this.chatRecordId = transferData.getChatRecordId();
            if (StringUtil.nonEmpty(transferData.getTransferTime())) {
                this.transferTime = StringUtil.dateStringTransfer(transferData.getTransferTime());
            }
            this.fromStaffId = transferData.getFromStaffId();
            this.fromStaffLogname = transferData.getFromStaffLogname();
            this.fromStaffName = transferData.getFromStaffName();
            this.toStaffId = transferData.getToStaffId();
            this.toStaffLogname = transferData.getToStaffLogName();
            this.toStaffName = transferData.getToStaffName();
        }
    }

    /**
     * 对话记录ID
     */
    private String chatRecordId;

    /**
     * 转接时间
     */
    private Date transferTime;

    /**
     * 发起转接的客服ID
     */
    private String fromStaffId;

    /**
     * 发起转接的客服账号
     */
    private String fromStaffLogname;

    /**
     * 发起转接的客服姓名
     */
    private String fromStaffName;

    /**
     * 接受转接的客服ID
     */
    private String toStaffId;

    /**
     * 接受转接的客服账号
     */
    private String toStaffLogname;

    /**
     * 接受转接的客服姓名
     */
    private String toStaffName;
}
