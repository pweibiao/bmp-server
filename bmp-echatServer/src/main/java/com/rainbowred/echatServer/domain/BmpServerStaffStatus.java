package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.xml.StaffStatusXml;
import lombok.Data;

/**
 * 客服状态
 * @TableName bmp_server_staff_status
 */
@Data
@TableName(value ="bmp_server_staff_status")
public class BmpServerStaffStatus extends BaseBizDomain {

    public BmpServerStaffStatus(){}

    public BmpServerStaffStatus(StaffStatusXml pojo) {
        this.staffStatus = pojo.getStaffStatus();
        this.staffId = pojo.getStaffId();
        this.staffLogname = pojo.getStaffLogname();
        this.staffName = pojo.getStaffName();
    }

    /**
     * 客服状态。1：在线，2：忙碌，3：离开，4：隐身，5：退出
     */
    private Integer staffStatus;

    /**
     * 客服ID
     */
    private Long staffId;

    /**
     * 客服登陆账号
     */
    private String staffLogname;

    /**
     * 客服姓名
     */
    private String staffName;
}
