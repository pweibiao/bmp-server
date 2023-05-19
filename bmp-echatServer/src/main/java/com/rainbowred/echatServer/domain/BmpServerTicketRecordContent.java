package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.data.DistributeUser;
import com.rainbowred.echatServer.data.JobData;
import com.rainbowred.echatServer.data.JobUpdator;
import com.rainbowred.echatServer.data.Topic;
import com.rainbowred.echatServer.xml.JobUpdated;
import lombok.Data;

/**
 * 工单更新内容
 * @TableName bmp_server_ticket_record_content
 */
@Data
@TableName(value ="bmp_server_ticket_record_content")
public class BmpServerTicketRecordContent extends BaseBizDomain {

    public BmpServerTicketRecordContent() {}

    /**
     * 工单内容
     */
    public BmpServerTicketRecordContent(JobUpdated pojo) {
        this.jobId = pojo.getJobId();
        this.jobAttribute = pojo.getJobAttribute();
        JobData jobData = pojo.getJobData();
        if (jobData != null) {
            this.status = jobData.getStatus();
            this.replyType = jobData.getReplyType();
            this.priority = jobData.getPriority();
            this.jobType = jobData.getJobType();
            Topic topic = jobData.getTopic();
            if (topic != null) {
                this.topicId = topic.getTopicId();
                this.topicName = topic.getTopicName();
            }
            DistributeUser distributeUser = jobData.getDistributeUser();
            if (distributeUser != null) {
                this.distributeStaffId = distributeUser.getStaffId();
                this.distributeStaffName = distributeUser.getStaffName();
                this.distributeStaffRole = distributeUser.getStaffRole();
                this.distributeStaffLogname = distributeUser.getStaffLogName();
            }
            JobUpdator jobUpdator = jobData.getJobUpdator();
            if (jobUpdator != null) {
                this.updaterType = jobUpdator.getType();
                this.updaterId = jobUpdator.getUpdaterId();
                this.updaterName = jobUpdator.getUpdaterName();
            }
            this.replyContent = jobData.getReplyContent();
            this.replyPhone = jobData.getReplyPhone();
            this.replyEmail = jobData.getReplyEmail();
            this.t1 = jobData.getT1();
            this.t2 = jobData.getT2();
            this.t3 = jobData.getT3();
            this.t4 = jobData.getT4();
            this.t5 = jobData.getT5();
            this.t6 = jobData.getT6();
            this.t7 = jobData.getT7();
            this.t8 = jobData.getT8();
            this.t9 = jobData.getT9();
            this.t10 = jobData.getT10();
            this.t11 = jobData.getT11();
            this.t12 = jobData.getT12();
            this.t13 = jobData.getT13();
            this.t14 = jobData.getT14();
            this.t15 = jobData.getT15();
            this.t16 = jobData.getT16();
            this.t17 = jobData.getT17();
            this.t18 = jobData.getT18();
            this.t19 = jobData.getT19();
            this.t20 = jobData.getT20();
        }
    }

    /**
     * 工单ID
     */
    private Long jobId;

    /**
     * 工单属性。1：内部工单，2：外部工单
     */
    private Integer jobAttribute;

    /**
     * 工单状态。1：新建，2：已开启，3：待回应，4：已挂起，5：已解决，6：已关闭
     */
    private Integer status;

    /**
     * 回复类型。1：内部回复，2：外部回复，3：内部回复和外部回复
     */
    private Integer replyType;

    /**
     * 工单优先级。1：低，2：正常，3：高，4：紧急
     */
    private Integer priority;

    /**
     * 工单类型。1：问题，2：事务，3：故障，4：任务
     */
    private Integer jobType;

    /**
     * 工单主题ID
     */
    private Long topicId;

    /**
     * 工单主题名称
     */
    private String topicName;

    /**
     * 工单指派客服ID
     */
    private Long distributeStaffId;

    /**
     * 工单指派客服姓名
     */
    private String distributeStaffName;

    /**
     * 工单指派客服角色名
     */
    private String distributeStaffRole;

    /**
     * 工单指派客服账号
     */
    private String distributeStaffLogname;

    /**
     * 更新人类型。-1：客服，1：访客
     */
    private Integer updaterType;

    /**
     * 客服ID或访客ID
     */
    private String updaterId;

    /**
     * 客服姓名或访客姓名
     */
    private String updaterName;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 工单回复邮箱
     */
    private String replyEmail;

    /**
     * 工单回复电话
     */
    private String replyPhone;

    /**
     * 工单自定义字段
     */
    private String t1;

    /**
     * 工单自定义字段
     */
    private String t2;

    /**
     * 工单自定义字段
     */
    private String t3;

    /**
     * 工单自定义字段
     */
    private String t4;

    /**
     * 工单自定义字段
     */
    private String t5;

    /**
     * 工单自定义字段
     */
    private String t6;

    /**
     * 工单自定义字段
     */
    private String t7;

    /**
     * 工单自定义字段
     */
    private String t8;

    /**
     * 工单自定义字段
     */
    private String t9;

    /**
     * 工单自定义字段
     */
    private String t10;

    /**
     * 工单自定义字段
     */
    private String t11;

    /**
     * 工单自定义字段
     */
    private String t12;

    /**
     * 工单自定义字段
     */
    private String t13;

    /**
     * 工单自定义字段
     */
    private String t14;

    /**
     * 工单自定义字段
     */
    private String t15;

    /**
     * 工单自定义字段
     */
    private String t16;

    /**
     * 工单自定义字段
     */
    private String t17;

    /**
     * 工单自定义字段
     */
    private String t18;

    /**
     * 工单自定义字段
     */
    private String t19;

    /**
     * 工单自定义字段
     */
    private String t20;
}
