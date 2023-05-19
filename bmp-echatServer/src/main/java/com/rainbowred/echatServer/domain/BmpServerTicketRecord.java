package com.rainbowred.echatServer.domain;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseBizDomain;

import com.rainbowred.echatServer.data.*;
import com.rainbowred.echatServer.xml.JobCreated;
import com.rainbowred.echatServer.xml.JobEvaluations;
import com.rainbowred.echatServer.xml.JobUpdated;
import lombok.Data;

/**
 * 工单数据
 * @TableName bmp_server_ticket_record
 */
@Data
@TableName(value ="bmp_server_ticket_record")
public class BmpServerTicketRecord extends BaseBizDomain {

    public BmpServerTicketRecord() {}

    /**
     * 创建工单
     */
    public BmpServerTicketRecord(JobCreated pojo) {
        this.setId(pojo.getJobId().toString());
        this.jobId = pojo.getJobId();
        this.jobAttribute = pojo.getJobAttribute();

        // 浏览数据
        VisitorData visitorData = pojo.getVisitorData();
        if (visitorData != null) {
            this.biddingWord = visitorData.getBiddingWord();
            this.browserName = visitorData.getBrowserName();
            this.browserVersion = visitorData.getBrowserVersion();
            this.firstPage = visitorData.getFirstPage();
            this.firstPageTitle = visitorData.getFirstPageTitle();
            this.firstPageAlias = visitorData.getFirstPageAliae();
            if (StringUtil.nonEmpty(visitorData.getFirstTime())) {
                this.firstTime = StringUtil.dateStringTransfer(visitorData.getFirstTime());
            }
            this.keyword = visitorData.getKeyword();
            if (StringUtil.nonEmpty(visitorData.getKeywordType())) {
                this.keywordType = new Integer(visitorData.getKeywordType());
            }
            this.lastChatStaffId = visitorData.getLastChatStaffId();
            this.lastChatStaffLogname = visitorData.getLastChatStaffLogName();
            this.lastChatStaffName = visitorData.getLastChatStaffName();
            if (StringUtil.nonEmpty(visitorData.getLastChatTime())) {
                this.lastChatTime = StringUtil.dateStringTransfer(visitorData.getLastChatTime());
            }
            this.osName = visitorData.getOsName();
            this.osVersion = visitorData.getOsVersion();
            this.referPage = visitorData.getReferPage();
            this.screenResolution = visitorData.getScreenResolution();
            this.se = visitorData.getSe();
            this.visitTimes = visitorData.getVisitTimes();
            this.visitorCity = visitorData.getVisitorCity();
            this.visitorCountry = visitorData.getVisitorCountry();
            if (StringUtil.nonEmpty(visitorData.getVisitorEnterTime())) {
                this.visitorEnterTime = StringUtil.dateStringTransfer(visitorData.getVisitorEnterTime());
            }
            this.visitorId = visitorData.getVisitorId();
            this.visitorIp = visitorData.getVisitorIp();
            this.visitorLan = visitorData.getVisitorLan();
            this.visitorMedia = visitorData.getVisitorMedia();
            this.visitorName = visitorData.getVisitorName();
            this.visitorPhoto = visitorData.getVisitorPhoto();
            this.visitorProvince = visitorData.getVisitorProvince();
            this.visitorType = visitorData.getVisitorType();
        }

        // 路由数据
        RouteData routeData = pojo.getRouteData();
        if (routeData != null) {
            this.routeId = routeData.getRouteId();
            this.routeName = routeData.getRouteName();
            this.chatDepartmentId = routeData.getChatDepartmentId();
            this.chatDepartmentName = routeData.getChatDepartmentName();
            this.styleId = routeData.getStyleId();
            this.styleName = routeData.getStyleName();
        }

        JobData jobData = pojo.getJobData();
        if (jobData != null) {
            this.title = jobData.getTitle();
            this.content = jobData.getContent();
            this.jobTopic = jobData.getJobTopic();
            this.requesterLan = jobData.getRequesterLan();
            this.requesterUserId = jobData.getRequesterUserId();
            this.requesterUserType = jobData.getRequesterUserType();
            this.requesterUserName = jobData.getRequesterUserName();
            this.styleId = jobData.getStyleId();
            this.jobType = jobData.getJobType();
            this.departmentId = jobData.getDepartmentId();
            this.departmentName = jobData.getDepartmentName();
            this.distributeUserId = jobData.getDistributeUserId();
            this.jobFollowerIds = jobData.getJobFollowerIds();
            this.jobFollowerNames = jobData.getJobFollowerNames();
            this.priority = jobData.getPriority();
            this.jobTemplateId = jobData.getJobTemplateId();
            this.status = jobData.getStatus();
            this.replyEmail = jobData.getReplyEmail();
            this.replyPhone = jobData.getReplyPhone();
            this.jobMemo = jobData.getJobMemo();
            this.attachments = JSONObject.toJSONString(jobData.getAttachments());
            this.crmId = jobData.getCrmId();
            this.address = jobData.getAddress();
            if (jobData.getAge() != null) {
                this.age = jobData.getAge().toString();
            }
            this.birthday = jobData.getBirthday();
            this.category = jobData.getCategory();
            this.city = jobData.getCity();
            this.email = jobData.getEmail();
            this.gender = jobData.getGender();
            this.maritalStatus = jobData.getMaritalStatus();
            this.memo = jobData.getMemo();
            this.name = jobData.getName();
            this.nation = jobData.getNation();
            this.nickName = jobData.getNickName();
            this.phone = jobData.getPhone();
            this.photo = jobData.getPhoto();
            this.province = jobData.getProvince();
            this.qq = jobData.getQq();
            this.wechat = jobData.getWechat();
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
            this.c1 = jobData.getC1();
            this.c2 = jobData.getC2();
            this.c3 = jobData.getC3();
            this.c4 = jobData.getC4();
            this.c5 = jobData.getC5();
            this.c6 = jobData.getC6();
            this.c7 = jobData.getC7();
            this.c8 = jobData.getC8();
            this.c9 = jobData.getC9();
            this.c10 = jobData.getC10();
            this.c11 = jobData.getC11();
            this.c12 = jobData.getC12();
            this.c13 = jobData.getC13();
            this.c14 = jobData.getC14();
            this.c15 = jobData.getC15();
            this.c16 = jobData.getC16();
            this.c17 = jobData.getC17();
            this.c18 = jobData.getC18();
            this.c19 = jobData.getC19();
            this.c20 = jobData.getC20();
        }
    }

    /**
     * 更新工单
     */
    public BmpServerTicketRecord(JobUpdated pojo) {
        this.setId(pojo.getJobId().toString());
        this.jobId = pojo.getJobId();
        this.jobAttribute = pojo.getJobAttribute();
        JobData jobData = pojo.getJobData();
        if (jobData != null) {
            Topic topic = jobData.getTopic();
            if (topic != null) {
                this.jobTopic = topic.getTopicId();
                this.jobTopicName = topic.getTopicName();
            }
            DistributeUser distributeUser = jobData.getDistributeUser();
            if (distributeUser != null) {
                this.distributeUserId = distributeUser.getStaffId();
                this.distributeUserName = distributeUser.getStaffName();
                this.distributeUserRole = distributeUser.getStaffRole();
                this.distributeUserLogname = distributeUser.getStaffLogName();
            }
            JobUpdator jobUpdator = jobData.getJobUpdator();
            if (jobUpdator != null) {
                this.updatorType = jobUpdator.getType();
                this.updatorId = jobUpdator.getUpdaterId();
                this.updatorName = jobUpdator.getUpdaterName();
            }
            this.styleId = jobData.getStyleId();
            this.jobType = jobData.getJobType();
            this.departmentId = jobData.getDepartmentId();
            this.departmentName = jobData.getDepartmentName();
            this.jobFollowerIds = jobData.getJobFollowerIds();
            this.jobFollowerNames = jobData.getJobFollowerNames();
            this.priority = jobData.getPriority();
            this.jobTemplateId = jobData.getJobTemplateId();
            this.status = jobData.getStatus();
            this.replyEmail = jobData.getReplyEmail();
            this.replyPhone = jobData.getReplyPhone();
            this.jobMemo = jobData.getJobMemo();
            this.attachments = JSONObject.toJSONString(jobData.getAttachments());
//            this.crmId = jobData.getCrmId();
            this.address = jobData.getAddress();
            if(jobData.getAge() != null) {
                this.age = jobData.getAge().toString();
            }
            this.birthday = jobData.getBirthday();
            this.category = jobData.getCategory();
            this.city = jobData.getCity();
            this.email = jobData.getEmail();
            this.gender = jobData.getGender();
            this.maritalStatus = jobData.getMaritalStatus();
            this.memo = jobData.getMemo();
            this.name = jobData.getName();
            this.nation = jobData.getNation();
            this.nickName = jobData.getNickName();
            this.phone = jobData.getPhone();
            this.photo = jobData.getPhoto();
            this.province = jobData.getProvince();
            this.qq = jobData.getQq();
            this.wechat = jobData.getWechat();
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
            this.c1 = jobData.getC1();
            this.c2 = jobData.getC2();
            this.c3 = jobData.getC3();
            this.c4 = jobData.getC4();
            this.c5 = jobData.getC5();
            this.c6 = jobData.getC6();
            this.c7 = jobData.getC7();
            this.c8 = jobData.getC8();
            this.c9 = jobData.getC9();
            this.c10 = jobData.getC10();
            this.c11 = jobData.getC11();
            this.c12 = jobData.getC12();
            this.c13 = jobData.getC13();
            this.c14 = jobData.getC14();
            this.c15 = jobData.getC15();
            this.c16 = jobData.getC16();
            this.c17 = jobData.getC17();
            this.c18 = jobData.getC18();
            this.c19 = jobData.getC19();
            this.c20 = jobData.getC20();
        }
    }

    /**
     * 工单满意度评价
     */
    public BmpServerTicketRecord(JobEvaluations pojo) {
        JobEvaluation jobEvaluation = pojo.getJobEvaluation();
        if (jobEvaluation != null) {
            this.setId(jobEvaluation.getJobId().toString());
            this.jobId = jobEvaluation.getJobId();
            this.evaluateDatetime = jobEvaluation.getEvaluateDatetime();
            this.mainItem = jobEvaluation.getMainItem();
            this.comment = jobEvaluation.getComment();
            this.subItems = JSONObject.toJSONString(jobEvaluation.getSubItems());
        }
    }

    /**
     * 开发者自定义扩展数据
     */
    private String myData;

    /**
     * 工单ID
     */
    private Long jobId;

    /**
     * 工单属性。1：内部工单，2：外部工单
     */
    private Integer jobAttribute;

    /**
     * 访客进入网站的时间
     */
    private Date visitorEnterTime;

    /**
     * 访客端的媒介。1：电脑端网页，2：移动端网页，5：微信，6：Android SDK，9：自定义渠道，11：邮箱渠道
     */
    private Integer visitorMedia;

    /**
     * 访客类型。-1：未知，0：游客，1：会员，4：微信公众号渠道，5：自定义渠道，8：邮箱渠道
     */
    private Integer visitorType;

    /**
     * 自定义渠道的渠道ID
     */
    private String mediaId;

    /**
     * 访客ID
     */
    private String visitorId;

    /**
     * 访客的姓名
     */
    private String visitorName;

    /**
     * 访客的头像地址
     */
    private String visitorPhoto;

    /**
     * 访客的来访次数
     */
    private Integer visitTimes;

    /**
     * 访客的浏览器语言
     */
    private String visitorLan;

    /**
     * 访客的来源IP
     */
    private String visitorIp;

    /**
     * 访客的来源国家
     */
    private String visitorCountry;

    /**
     * 访客的来源省份
     */
    private String visitorProvince;

    /**
     * 访客的来源城市
     */
    private String visitorCity;

    /**
     * 访客的浏览器名称
     */
    private String browserName;

    /**
     * 访客的浏览器版本号
     */
    private String browserVersion;

    /**
     * 访客电脑的分辨率
     */
    private String screenResolution;

    /**
     * 访客电脑的操作系统
     */
    private String osName;

    /**
     * 访客电脑的操作系统版本
     */
    private String osVersion;

    /**
     * 访客来源的搜索引擎
     */
    private String se;

    /**
     * 访客来源的关键词
     */
    private String keyword;

    /**
     * 推广词
     */
    private String biddingWord;

    /**
     * 关键字类型。0：未区分SEO、推广，1：自然优化，2：付费推广
     */
    private Integer keywordType;

    /**
     * 访客进入网站的来源页
     */
    private String referPage;

    /**
     * 进入网站的时间
     */
    private Date firstTime;

    /**
     * 访客落地页面的URL
     */
    private String firstPage;

    /**
     * 访客落地页面的标题
     */
    private String firstPageTitle;

    /**
     * 访客落地页面的别名
     */
    private String firstPageAlias;

    /**
     * 上次对话的时间
     */
    private Date lastChatTime;

    /**
     * 上次对话的客服ID.0：首次对话
     */
    private Long lastChatStaffId;

    /**
     * 上次对话的客服账号
     */
    private String lastChatStaffLogname;

    /**
     * 上次对话的客服姓名
     */
    private String lastChatStaffName;

    /**
     * 接入对话的路由ID。-1：web访客的默认路由，-2：微信公众号对话的默认路由，-3：SDK对话的默认路由，-7：自定义渠道的默认路由
     */
    private Long routeId;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 路由所使用的样式ID
     */
    private Long routeStyleId;

    /**
     * 路由所使用样式的名称
     */
    private String styleName;

    /**
     * 本次分配对话的接待组ID。0：全部人员可接待
     */
    private Long chatDepartmentId;

    /**
     * 本地分配对话的接待组名称
     */
    private String chatDepartmentName;

    /**
     * 工单标题
     */
    private String title;

    /**
     * 工单内容
     */
    private String content;

    /**
     * 工单主题ID
     */
    private Long jobTopic;

    /**
     * 工单主题名称
     */
    private String jobTopicName;

    /**
     * 请求者语言
     */
    private String requesterLan;

    /**
     * 请求者ID
     */
    private String requesterUserId;

    /**
     * 请求者类型。-1：客服，1：访客
     */
    private Integer requesterUserType;

    /**
     * 请求者姓名
     */
    private String requesterUserName;

    /**
     * 样式ID
     */
    private Long styleId;

    /**
     * 工单类型。1：问题，2：事务，3：故障，4：任务
     */
    private Integer jobType;

    /**
     * 工单指派分组ID。0：客服创建时，选择处理人为“全部部门”
     */
    private Long departmentId;

    /**
     * 工单指派分组
     */
    private String departmentName;

    /**
     * 工单指派客服ID。0：由客服创建时，没有指定处理人；由访客创建时，工单自动分配为“手动分配”，即没有指定处理人
     */
    private Long distributeUserId;

    /**
     * 工单指派客服姓名
     */
    private String distributeUserName;

    /**
     * 工单指派客服角色名
     */
    private String distributeUserRole;

    /**
     * 工单指派客服账号
     */
    private String distributeUserLogname;

    /**
     * 更新人类型。-1：客服，1：访客
     */
    private Integer updatorType;

    /**
     * 工单更新人ID
     */
    private String updatorId;

    /**
     * 工单更新人姓名
     */
    private String updatorName;

    /**
     * 工单跟踪人ID
     */
    private String jobFollowerIds;

    /**
     * 工单跟踪人姓名
     */
    private String jobFollowerNames;

    /**
     * 工单优先级。1：低，2：正常 ，3：高，4：紧急
     */
    private Integer priority;

    /**
     * 工单模版ID
     */
    private Long jobTemplateId;

    /**
     * 工单状态。1：新建，2：已开启，3：待回应，4：已挂起，5：已解决，6：已关闭
     */
    private Integer status;

    /**
     * 工单回复邮箱
     */
    private String replyEmail;

    /**
     * 工单回复电话
     */
    private String replyPhone;

    /**
     * 工单备注
     */
    private String jobMemo;

    /**
     * 工单附件信息，JSON字符串
     */
    private String attachments;

    /**
     * CRM字段-客户ID
     */
    private Long crmId;

    /**
     * CRM字段-客户姓名
     */
    private String name;

    /**
     * CRM字段-客户类别
     */
    private String category;

    /**
     * CRM字段-客户昵称
     */
    private String nickName;

    /**
     * CRM字段-客户性别。0：未知，1：男，2：女
     */
    private Integer gender;

    /**
     * CRM字段-客户年龄
     */
    private String age;

    /**
     * CRM字段-客户生日
     */
    private String birthday;

    /**
     * CRM字段-客户婚姻状况。0：未知，1：未婚，2：已婚
     */
    private Integer maritalStatus;

    /**
     * CRM字段-客户电话
     */
    private String phone;

    /**
     * CRM字段-客户qq
     */
    private String qq;

    /**
     * CRM字段-客户微信
     */
    private String wechat;

    /**
     * CRM字段-客户邮箱
     */
    private String email;

    /**
     * CRM字段-客户所在国家
     */
    private String nation;

    /**
     * CRM字段-客户所在省份
     */
    private String province;

    /**
     * CRM字段-客户所在城市
     */
    private String city;

    /**
     * CRM字段-客户地址
     */
    private String address;

    /**
     * CRM字段-客户头像地址
     */
    private String photo;

    /**
     * CRM字段-备注
     */
    private String memo;

    /**
     * CRM自定义字段
     */
    private String c1;

    /**
     * CRM自定义字段
     */
    private String c2;

    /**
     * CRM自定义字段
     */
    private String c3;

    /**
     * CRM自定义字段
     */
    private String c4;

    /**
     * CRM自定义字段
     */
    private String c5;

    /**
     * CRM自定义字段
     */
    private String c6;

    /**
     * CRM自定义字段
     */
    private String c7;

    /**
     * CRM自定义字段
     */
    private String c8;

    /**
     * CRM自定义字段
     */
    private String c9;

    /**
     * CRM自定义字段
     */
    private String c10;

    /**
     * CRM自定义字段
     */
    private String c11;

    /**
     * CRM自定义字段
     */
    private String c12;

    /**
     * CRM自定义字段
     */
    private String c13;

    /**
     * CRM自定义字段
     */
    private String c14;

    /**
     * CRM自定义字段
     */
    private String c15;

    /**
     * CRM自定义字段
     */
    private String c16;

    /**
     * CRM自定义字段
     */
    private String c17;

    /**
     * CRM自定义字段
     */
    private String c18;

    /**
     * CRM自定义字段
     */
    private String c19;

    /**
     * CRM自定义字段
     */
    private String c20;

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

    /**
     * 用户评价时间。时间戳格式
     */
    private Long evaluateDatetime;

    /**
     * 评价满意度。1：非常差评，2：不满意 ，3：一般 ，4：满意 ，5：非常满意
     */
    private Integer mainItem;

    /**
     * 访客评价备注内容
     */
    private String comment;

    /**
     * 评价子项
     */
    private String subItems;
}
