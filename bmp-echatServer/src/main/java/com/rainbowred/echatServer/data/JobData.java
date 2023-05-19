package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc: 工单数据
 * @Date: 2022/7/11 20:45
 * @Author: pengweibiao
 **/
@Data
public class JobData extends BaseData{

    /**
     * 工单标题
     */
	@XmlElement(name = "title")
    private String title;

    /**
     * 工单内容
     */
	@XmlElement(name = "content")
    private String content;

    /**
     * 工单主题ID
     */
    @XmlElement(name = "jobTopic")
    private Long jobTopic;

    /**
     * 工单主题名称。工单更新时，主题产生变化才会有值
     */
    @XmlElement(name = "jobTopicName")
    private String jobTopicName;

    /**
     * 工单请求语言
     */
    @XmlElement(name = "requesterLan")
    private String requesterLan;

    /**
     * 请求者ID。访客vipId或客服ID
     */
    @XmlElement(name = "requesterUserId")
    private String requesterUserId;

    /**
     * 请求者类型。—1：客服 0：访客
     */
    @XmlElement(name = "requesterUserType")
    private Integer requesterUserType;

    /**
     * 请求者姓名
     */
    @XmlElement(name = "requesterUserName")
    private String requesterUserName;

    /**
     * 样式ID
     */
    @XmlElement(name = "styleId")
    private Long styleId;

    /**
     * 工单类型。1：问题 2：事务 3：故障 4：任务
     */
    @XmlElement(name = "jobType")
    private Integer jobType;

    /**
     * 工单指派分组ID
     */
    @XmlElement(name = "departmentId")
    private Long departmentId;

    /**
     * 工单指派分组名称
     */
    @XmlElement(name = "departmentName")
    private String departmentName;

    /**
     * 工单指派客服ID
     */
    @XmlElement(name = "distributeUserId")
    private Long distributeUserId;

    /**
     * 工单指派客服姓名
     */
    @XmlElement(name = "distributeUserName")
    private String distributeUserName;

    /**
     * 工单跟踪者ID列表
     */
    @XmlElement(name = "jobFollowerIds")
    private String jobFollowerIds;

    /**
     * 工单跟踪者名称列表
     */
    @XmlElement(name = "jobFollowerNames")
    private String jobFollowerNames;

    /**
     * 工单优先级。1：低 2：正常 3：高 4：紧急
     */
    @XmlElement(name = "priority")
    private Integer priority;

    /**
     * 工单模版ID
     */
    @XmlElement(name = "jobTemplateId")
    private Long jobTemplateId;

    /**
     * 工单状态。1：新建 2：已开启 3：待回应 4：已挂起 5：已解决 6：已关闭
     */
    @XmlElement(name = "status")
    private Integer status;

    /**
     * 回复邮箱地址
     */
    @XmlElement(name = "replyEmail")
    private String replyEmail;

    /**
     * 回复邮箱地址
     */
    @XmlElement(name = "replyPhone")
    private String replyPhone;

    /**
     * 回复内容
     */
    @XmlElement(name = "replyContent")
    private String replyContent;

    /**
     * 回复类型
     */
    @XmlElement(name = "replyType")
    private Integer replyType;

    /**
     * 工单备注
     */
    @XmlElement(name = "jobMemo")
    private String jobMemo;

    /**
     * 工单自定义字段1
     */
    @XmlElement(name = "t1")
    private String t1;

    /**
     * 工单自定义字段2
     */
    @XmlElement(name = "t2")
    private String t2;

    /**
     * 工单自定义字段3
     */
    @XmlElement(name = "t3")
    private String t3;

    /**
     * 工单自定义字段4
     */
    @XmlElement(name = "t4")
    private String t4;

    /**
     * 工单自定义字段5
     */
    @XmlElement(name = "t5")
    private String t5;

    /**
     * 工单自定义字段6
     */
    @XmlElement(name = "t6")
    private String t6;

    /**
     * 工单自定义字段7
     */
    @XmlElement(name = "t7")
    private String t7;

    /**
     * 工单自定义字段8
     */
    @XmlElement(name = "t8")
    private String t8;

    /**
     * 工单自定义字段9
     */
    @XmlElement(name = "t9")
    private String t9;

    /**
     * 工单自定义字段10
     */
    @XmlElement(name = "t10")
    private String t10;

    /**
     * 工单自定义字段11
     */
    @XmlElement(name = "t11")
    private String t11;

    /**
     * 工单自定义字段12
     */
    @XmlElement(name = "t12")
    private String t12;

    /**
     * 工单自定义字段13
     */
    @XmlElement(name = "t13")
    private String t13;

    /**
     * 工单自定义字段14
     */
    @XmlElement(name = "t14")
    private String t14;

    /**
     * 工单自定义字段15
     */
    @XmlElement(name = "t15")
    private String t15;

    /**
     * 工单自定义字段16
     */
    @XmlElement(name = "t16")
    private String t16;

    /**
     * 工单自定义字段17
     */
    @XmlElement(name = "t17")
    private String t17;

    /**
     * 工单自定义字段18
     */
    @XmlElement(name = "t18")
    private String t18;

    /**
     * 工单自定义字段19
     */
    @XmlElement(name = "t19")
    private String t19;

    /**
     * 工单自定义字段20
     */
    @XmlElement(name = "t20")
    private String t20;

    /**
     * CRM客户ID
     */
    @XmlElement(name = "crmId")
    private Long crmId;

    /**
     * 客户姓名
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * CRM字段-客户类别
     */
    @XmlElement(name = "category")
    private String category;

    /**
     * 客户电话号码
     */
    @XmlElement(name = "phone")
    private String phone;

    /**
     * 客户qq号码
     */
    @XmlElement(name = "qq")
    private String qq;

    /**
     * 客户微信号
     */
    @XmlElement(name = "wechat")
    private String wechat;

    /**
     * 客户邮箱地址
     */
    @XmlElement(name = "email")
    private String email;

    /**
     * CRM字段-客户所在国家
     */
    @XmlElement(name = "nation")
    private String nation;

    /**
     * CRM字段-客户所在省份
     */
    @XmlElement(name = "province")
    private String province;

    /**
     * CRM字段-客户所在城市
     */
    @XmlElement(name = "city")
    private String city;

    /**
     * 客户地址
     */
    @XmlElement(name = "address")
    private String address;

    /**
     * 客户的昵称
     */
    @XmlElement(name = "nickName")
    private String nickName;

    /**
     * 性别。0：未知 1：男 2：女
     */
    @XmlElement(name = "gender")
    private Integer gender;

    /**
     * CRM字段-客户头像地址
     */
    @XmlElement(name = "photo")
    private String photo;

    /**
     * 客户信息备注
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * 婚姻状况。0：未知 1：未婚 2：已婚
     */
    @XmlElement(name = "maritalStatus")
    private Integer maritalStatus;

    /**
     * 年龄
     */
    @XmlElement(name = "age")
    private Integer age;

    /**
     * 客户生日
     */
    @XmlElement(name = "birthday")
    private String birthday;

    /**
     * 自定义字段1
     */
    @XmlElement(name = "c1")
    private String c1;

    /**
     * 自定义字段2
     */
    @XmlElement(name = "c2")
    private String c2;

    /**
     * 自定义字段3
     */
    @XmlElement(name = "c3")
    private String c3;

    /**
     * 自定义字段4
     */
    @XmlElement(name = "c4")
    private String c4;

    /**
     * 自定义字段5
     */
    @XmlElement(name = "c5")
    private String c5;

    /**
     * 自定义字段6
     */
    @XmlElement(name = "c6")
    private String c6;

    /**
     * 自定义字段7
     */
    @XmlElement(name = "c7")
    private String c7;

    /**
     * 自定义字段8
     */
    @XmlElement(name = "c8")
    private String c8;

    /**
     * 自定义字段9
     */
    @XmlElement(name = "c9")
    private String c9;

    /**
     * 自定义字段10
     */
    @XmlElement(name = "c10")
    private String c10;

    /**
     * 自定义字段11
     */
    @XmlElement(name = "c11")
    private String c11;

    /**
     * 自定义字段12
     */
    @XmlElement(name = "c12")
    private String c12;

    /**
     * 自定义字段13
     */
    @XmlElement(name = "c13")
    private String c13;

    /**
     * 自定义字段14
     */
    @XmlElement(name = "c14")
    private String c14;

    /**
     * 自定义字段15
     */
    @XmlElement(name = "c15")
    private String c15;

    /**
     * 自定义字段16
     */
    @XmlElement(name = "c16")
    private String c16;

    /**
     * 自定义字段17
     */
    @XmlElement(name = "c17")
    private String c17;

    /**
     * 自定义字段18
     */
    @XmlElement(name = "c18")
    private String c18;

    /**
     * 自定义字段19
     */
    @XmlElement(name = "c19")
    private String c19;

    /**
     * 自定义字段20
     */
    @XmlElement(name = "c20")
    private String c20;

    /**
     * 工单链接
     */
    @XmlElement(name = "jobLink")
    private String jobLink;

    private Attachments attachments;

    private Topic topic;

    private DistributeUser distributeUser;

    private JobUpdator jobUpdator;

    @XmlTransient
    public String getTitle() {
        return title;
    }

    @XmlTransient
    public String getContent() {
        return content;
    }

    @XmlTransient
    public Long getJobTopic() {
        return jobTopic;
    }

    @XmlTransient
    public String getJobTopicName() {
        return jobTopicName;
    }

    @XmlTransient
    public String getRequesterLan() {
        return requesterLan;
    }

    @XmlTransient
    public String getRequesterUserId() {
        return requesterUserId;
    }

    @XmlTransient
    public Integer getRequesterUserType() {
        return requesterUserType;
    }

    @XmlTransient
    public String getRequesterUserName() {
        return requesterUserName;
    }

    @XmlTransient
    public Long getStyleId() {
        return styleId;
    }

    @XmlTransient
    public Integer getJobType() {
        return jobType;
    }

    @XmlTransient
    public Long getDepartmentId() {
        return departmentId;
    }

    @XmlTransient
    public String getDepartmentName() {
        return departmentName;
    }

    @XmlTransient
    public Long getDistributeUserId() {
        return distributeUserId;
    }

    @XmlTransient
    public String getDistributeUserName() {
        return distributeUserName;
    }

    @XmlTransient
    public String getJobFollowerIds() {
        return jobFollowerIds;
    }

    @XmlTransient
    public String getJobFollowerNames() {
        return jobFollowerNames;
    }

    @XmlTransient
    public Integer getPriority() {
        return priority;
    }

    @XmlTransient
    public Long getJobTemplateId() {
        return jobTemplateId;
    }

    @XmlTransient
    public Integer getStatus() {
        return status;
    }

    @XmlTransient
    public String getReplyEmail() {
        return replyEmail;
    }

    @XmlTransient
    public String getReplyPhone() {
        return replyPhone;
    }

    @XmlTransient
    public String getReplyContent() {
        return replyContent;
    }

    @XmlTransient
    public Integer getReplyType() {
        return replyType;
    }

    @XmlTransient
    public String getJobMemo() {
        return jobMemo;
    }

    @XmlTransient
    public String getT1() {
        return t1;
    }

    @XmlTransient
    public String getT2() {
        return t2;
    }

    @XmlTransient
    public String getT3() {
        return t3;
    }

    @XmlTransient
    public String getT4() {
        return t4;
    }

    @XmlTransient
    public String getT5() {
        return t5;
    }

    @XmlTransient
    public String getT6() {
        return t6;
    }

    @XmlTransient
    public String getT7() {
        return t7;
    }

    @XmlTransient
    public String getT8() {
        return t8;
    }

    @XmlTransient
    public String getT9() {
        return t9;
    }

    @XmlTransient
    public String getT10() {
        return t10;
    }

    @XmlTransient
    public String getT11() {
        return t11;
    }

    @XmlTransient
    public String getT12() {
        return t12;
    }

    @XmlTransient
    public String getT13() {
        return t13;
    }

    @XmlTransient
    public String getT14() {
        return t14;
    }

    @XmlTransient
    public String getT15() {
        return t15;
    }

    @XmlTransient
    public String getT16() {
        return t16;
    }

    @XmlTransient
    public String getT17() {
        return t17;
    }

    @XmlTransient
    public String getT18() {
        return t18;
    }

    @XmlTransient
    public String getT19() {
        return t19;
    }

    @XmlTransient
    public String getT20() {
        return t20;
    }

    @XmlTransient
    public Long getCrmId() {
        return crmId;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    @XmlTransient
    public String getPhone() {
        return phone;
    }

    @XmlTransient
    public String getQq() {
        return qq;
    }

    @XmlTransient
    public String getWechat() {
        return wechat;
    }

    @XmlTransient
    public String getEmail() {
        return email;
    }

    @XmlTransient
    public String getAddress() {
        return address;
    }

    @XmlTransient
    public String getNickName() {
        return nickName;
    }

    @XmlTransient
    public Integer getGender() {
        return gender;
    }

    @XmlTransient
    public String getMemo() {
        return memo;
    }

    @XmlTransient
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    @XmlTransient
    public Integer getAge() {
        return age;
    }

    @XmlTransient
    public String getBirthday() {
        return birthday;
    }

    @XmlTransient
    public String getC1() {
        return c1;
    }

    @XmlTransient
    public String getC2() {
        return c2;
    }

    @XmlTransient
    public String getC3() {
        return c3;
    }

    @XmlTransient
    public String getC4() {
        return c4;
    }

    @XmlTransient
    public String getC5() {
        return c5;
    }

    @XmlTransient
    public String getC6() {
        return c6;
    }

    @XmlTransient
    public String getC7() {
        return c7;
    }

    @XmlTransient
    public String getC8() {
        return c8;
    }

    @XmlTransient
    public String getC9() {
        return c9;
    }

    @XmlTransient
    public String getC10() {
        return c10;
    }

    @XmlTransient
    public String getC11() {
        return c11;
    }

    @XmlTransient
    public String getC12() {
        return c12;
    }

    @XmlTransient
    public String getC13() {
        return c13;
    }

    @XmlTransient
    public String getC14() {
        return c14;
    }

    @XmlTransient
    public String getC15() {
        return c15;
    }

    @XmlTransient
    public String getC16() {
        return c16;
    }

    @XmlTransient
    public String getC17() {
        return c17;
    }

    @XmlTransient
    public String getC18() {
        return c18;
    }

    @XmlTransient
    public String getC19() {
        return c19;
    }

    @XmlTransient
    public String getC20() {
        return c20;
    }

    @XmlTransient
    public String getJobLink() {
        return jobLink;
    }

    @XmlTransient
    public String getCategory() {
        return category;
    }

    @XmlTransient
    public String getNation() {
        return nation;
    }

    @XmlTransient
    public String getProvince() {
        return province;
    }

    @XmlTransient
    public String getCity() {
        return city;
    }

    @XmlTransient
    public String getPhoto() {
        return photo;
    }
}
