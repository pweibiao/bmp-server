package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.data.*;
import com.rainbowred.echatServer.xml.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * 对话数据
 * @TableName bmp_server_chat_record
 */
@Data
@TableName(value ="bmp_server_chat_record")
public class BmpServerChatRecord extends BaseBizDomain {

    public BmpServerChatRecord(){}

    /**
     * ===== xml映射 =====
     */

    /**
     * 对话开始
     */
    public BmpServerChatRecord(ChatStart pojo) {
        // 无转接
        this.isTransfer = 0;
        // 对话类型
        int chatStatus = pojo.getChatStatus();
        this.chatStatus = chatStatus;
        if (chatStatus == 1) {
            this.chatRecordType = 1;
        }else if (chatStatus == 3) {
            this.chatRecordType = 3;
        }else if (chatStatus == 5) {
            this.chatRecordType = 2;
        }

        this.myData = pojo.getMyData();

        // 对话数据
        ChatData chatData = pojo.getChatData();
        if (Objects.nonNull(chatData)) {
            // 对话id
            this.setId(chatData.getChatRecordId());
            // 对话接通时间
            if (StringUtil.nonEmpty(chatData.getChatAnswerTime())) {
                this.chatAnswerTime = StringUtil.dateStringTransfer(chatData.getChatAnswerTime());
            }
            // 对话请求时间
            if (StringUtil.nonEmpty(chatData.getChatRequestTime())) {
                this.chatRequestTime = StringUtil.dateStringTransfer(chatData.getChatRequestTime());
            }
            this.chatEntrance = chatData.getChatEntrance();
            this.chatPage = chatData.getChatPage();
            this.chatPageTitle = chatData.getChatPageTitle();
            this.chatRecordId = chatData.getChatRecordId();
            this.chatStaffId = chatData.getChatStaffId();
            this.chatStaffLogname = chatData.getChatStaffLogName();
            this.chatStaffName = chatData.getChatStaffName();
            this.chatStaffRole = chatData.getChatStaffRole();
            this.chatTimes = chatData.getChatTimes();
            this.chatEvent = chatData.getChatEvent();
            this.chatType =chatData.getChatType();
        }

        // 会员数据
        MetaData metaData = pojo.getMetaData();
        if (Objects.nonNull(metaData)) {
            this.uid = metaData.getUid();
            if ( metaData.getGrade() != null ) {
                this.grade = new Integer(metaData.getGrade());
            }
            if ( metaData.getGender() != null ) {
                this.gender = new Integer(metaData.getGender());
            }
            if ( metaData.getMaritalStatus() != null ) {
                this.maritalStatus = new Integer(metaData.getMaritalStatus());
            }
            this.category = metaData.getCategory();
            this.name = metaData.getName();
            this.nickName = metaData.getNickName();
            this.age = metaData.getAge();
            this.birthday = metaData.getBirthday();
            this.phone = metaData.getPhone();
            this.qq = metaData.getQq();
            this.wechat = metaData.getWechat();
            this.email = metaData.getEmail();
            this.nation = metaData.getNation();
            this.province = metaData.getProvince();
            this.city = metaData.getCity();
            this.address = metaData.getAddress();
            this.photo = metaData.getPhoto();
            this.memo = metaData.getMemo();
            this.c1 = metaData.getC1();
            this.c2 = metaData.getC2();
            this.c3 = metaData.getC3();
            this.c4 = metaData.getC4();
            this.c5 = metaData.getC5();
            this.c6 = metaData.getC6();
            this.c7 = metaData.getC7();
            this.c8 = metaData.getC8();
            this.c9 = metaData.getC9();
            this.c10 = metaData.getC10();
            this.c11 = metaData.getC11();
            this.c12 = metaData.getC12();
            this.c13 = metaData.getC13();
            this.c14 = metaData.getC14();
            this.c15 = metaData.getC15();
            this.c16 = metaData.getC16();
            this.c17 = metaData.getC17();
            this.c18 = metaData.getC18();
            this.c19 = metaData.getC19();
            this.c20 = metaData.getC20();

        }

        // 路由数据
        RouteData routeData = pojo.getRouteData();
        if (routeData != null) {
            this.routeId = routeData.getRouteId();
            this.routeName = routeData.getRouteName();
            this.routeChatDepartmentId = routeData.getChatDepartmentId();
            this.routeChatDepartmentName = routeData.getChatDepartmentName();
            this.styleId = routeData.getStyleId();
            this.styleName = routeData.getStyleName();
        }

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
    }

    /**
     * 对话接通
     */
    public BmpServerChatRecord(ChatAnswer pojo) {
        // 是否转接 默认为0：无转接
        this.isTransfer = 0;
        // 对话类型
        int chatStatus = pojo.getChatStatus();
        if (chatStatus == 1) {
            this.chatRecordType = 1;
        }else if (chatStatus == 3) {
            this.chatRecordType = 3;
        }else if (chatStatus == 5) {
            this.chatRecordType = 2;
        }
        this.chatStatus = chatStatus;

        // 对话数据
        ChatData chatData = pojo.getChatData();
        if (chatData != null) {
            this.setId(chatData.getChatRecordId());
            if (StringUtil.nonEmpty(chatData.getChatAnswerTime())) {
                this.chatAnswerTime = StringUtil.dateStringTransfer(chatData.getChatAnswerTime());
            }
            this.chatDepartmentId = chatData.getChatDepartmentId();
            this.chatDepartmentName = chatData.getChatDepartmentName();
            this.chatRecordId = chatData.getChatRecordId();
            this.chatStaffId = chatData.getChatStaffId();
            this.chatStaffLogname = chatData.getChatStaffLogName();
            this.chatStaffName = chatData.getChatStaffName();
            this.chatStaffRole = chatData.getChatStaffRole();
            this.chatType = chatData.getChatType();
            this.chatWaitTime = chatData.getChatWaitTime();
        }
    }

    /**
     * 对话满意度评价
     */
    public BmpServerChatRecord(ChatScore pojo) {
        this.setId(pojo.getChatRecordId());
        this.chatRecordId = pojo.getChatRecordId();
        this.chatScore = pojo.getChatScore();
        this.scoreChatStaffId = pojo.getChatScoreStaffId();
        this.scoreChatStaffLogname = pojo.getChatScoreStaffLogName();
        this.scoreChatStaffName = pojo.getChatScoreStaffName();
        this.scoreDimension = pojo.getScoreDimension();
        this.scoreSuggest = pojo.getScoreSuggest();
    }

    /**
     * 对话评估数据
     */
    public BmpServerChatRecord(ChatSubject pojo) {
        this.setId(pojo.getChatRecordId());
        this.chatRecordId = pojo.getChatRecordId();
        this.chatSubject = pojo.getChatSubject();
        this.chatSubjectMemo = pojo.getChatSubjectMemo();
    }

    /**
     * 对话结束
     */
    public BmpServerChatRecord(ChatEnd pojo) {
        // 对话数据
        this.chatStatus = pojo.getChatStatus();
        ChatData chatData = pojo.getChatData();
        if (chatData != null) {
            this.setId(chatData.getChatRecordId());
            this.activelyinviteEvaluating = chatData.getActivelyInviteEvaluating();
            this.avgAnswerTime = chatData.getAvgAnswerTime();
            if (StringUtil.nonEmpty(chatData.getChatEndTime())) {
                this.chatEndTime = StringUtil.dateStringTransfer(chatData.getChatEndTime());
            }
            this.chatEndType = chatData.getChatEndType();
            this.chatRecordId = chatData.getChatRecordId();
            this.chatTotalTime = chatData.getChatTotalTime();
            this.chatWaitTime = chatData.getChatWaitTime();
            this.firstAnswerTime = chatData.getFirstAnswerTime();
            this.staffSendMsg = chatData.getStaffSendMsg();
            this.visitorId = chatData.getVisitorId();
            this.visitorSendMsg = chatData.getVisitorSendMsg();
            this.perfectMatchs = chatData.getPerfectMatchs();
            this.exactMatchs = chatData.getExactMatchs();
            this.similarityMatchs = chatData.getSimilarityMatchs();
            this.solvedCount = chatData.getSolvedCount();
            this.unsolvedCount = chatData.getUnsolvedCount();
        }
    }

    /**
     * 对话内容数据
     */
    public BmpServerChatRecord(ChatContent pojo) {
        // 对话数据
        ChatData chatData = pojo.getChatData();
        if (chatData != null) {
            this.setId(chatData.getChatRecordId());
            this.chatRecordId = chatData.getChatRecordId();
            this.chatContent = chatData.getChatContent();
        }
    }

    /**
     * 留言内容数据
     */
    public BmpServerChatRecord(LeaveMsgContent pojo) {
        // 对话数据
        ChatData chatData = pojo.getChatData();
        if (chatData != null) {
            this.setId(chatData.getChatRecordId());
            this.chatRecordId = chatData.getChatRecordId();
            this.chatContent = chatData.getChatContent();
        }

        // 客户数据
        CrmData crmData = pojo.getCrmData();
        if (crmData != null) {
            this.visitorId = crmData.getVisitorId();
            this.name = crmData.getName();
        }
    }

    /**
     * 留言分配数据
     */
    public BmpServerChatRecord(LeaveMsgOwner pojo) {
        this.setId(pojo.getChatRecordId());
        this.chatRecordId = pojo.getChatRecordId();
        this.visitorId = pojo.getVisitorId();
        this.staffId = pojo.getStaffId();
        this.staffLogname = pojo.getStaffLogName();
        this.staffName = pojo.getStaffName();

        // 留言分配的客服
        OwnerData ownerData = pojo.getOwnerData();
        if (ownerData != null) {
            this.ownerId = ownerData.getOwnerId();
            this.ownerLogname = ownerData.getOwnerLogName();
            this.ownerName = ownerData.getOwnerName();
        }
    }

    /**
     * 对话记录类型。1：人工对话 2：机器人对话 3：留言 4：推送
     */
    private Integer chatRecordType;

    /**
     * 开发者自定义扩展数据
     */
    private String myData;

    /**
     * 对话状态。1：人工对话开始，2：人工对话结束，3：留言开始，4：留言结束，5：机器人对话开始，6：机器人对话结束
     */
    private Integer chatStatus;

    /**
     * 对话是否存在转接。0：无转接，1：有转接
     */
    private Integer isTransfer;

    /**
     * 会员唯一值
     */
    private String uid;

    /**
     * 会员级别。大于“0”的数字
     */
    private Integer grade;

    /**
     * 会员类别
     */
    private String category;

    /**
     * 会员姓名
     */
    private String name;

    /**
     * 会员昵称
     */
    private String nickName;

    /**
     * 会员性别。0：未知，1：男，2：女
     */
    private Integer gender;

    /**
     * 会员年龄
     */
    private String age;

    /**
     * 会员生日
     */
    private String birthday;

    /**
     * 会员婚姻状况。0：未知，1：未婚，2：已婚
     */
    private Integer maritalStatus;

    /**
     * 会员联系电话
     */
    private String phone;

    /**
     * 会员QQ
     */
    private String qq;

    /**
     * 会员微信
     */
    private String wechat;

    /**
     * 会员邮箱
     */
    private String email;

    /**
     * 会员国家
     */
    private String nation;

    /**
     * 会员省份
     */
    private String province;

    /**
     * 会员城市
     */
    private String city;

    /**
     * 会员地址
     */
    private String address;

    /**
     * 会员头像地址
     */
    private String photo;

    /**
     * 会员备注信息
     */
    private String memo;

    /**
     * 会员自定义字段
     */
    private String c1;

    /**
     * 会员自定义字段
     */
    private String c2;

    /**
     * 会员自定义字段
     */
    private String c3;

    /**
     * 会员自定义字段
     */
    private String c4;

    /**
     * 会员自定义字段
     */
    private String c5;

    /**
     * 会员自定义字段
     */
    private String c6;

    /**
     * 会员自定义字段
     */
    private String c7;

    /**
     * 会员自定义字段
     */
    private String c8;

    /**
     * 会员自定义字段
     */
    private String c9;

    /**
     * 会员自定义字段
     */
    private String c10;

    /**
     * 会员自定义字段
     */
    private String c11;

    /**
     * 会员自定义字段
     */
    private String c12;

    /**
     * 会员自定义字段
     */
    private String c13;

    /**
     * 会员自定义字段
     */
    private String c14;

    /**
     * 会员自定义字段
     */
    private String c15;

    /**
     * 会员自定义字段
     */
    private String c16;

    /**
     * 会员自定义字段
     */
    private String c17;

    /**
     * 会员自定义字段
     */
    private String c18;

    /**
     * 会员自定义字段
     */
    private String c19;

    /**
     * 会员自定义字段
     */
    private String c20;

    /**
     * 访客进入网站的时间
     */
    private Date visitorEnterTime;

    /**
     * 访客端的媒介。1：电脑端网页，2：移动端网页，5：微信，6：Android SDK，9：自定义渠道，11：邮箱渠
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
     * 推广
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
     * 上次对话的客服ID
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
    private Long styleId;

    /**
     * 路由所使用样式的名称
     */
    private String styleName;

    /**
     * 本次分配对话的接待组ID。0：全部人员可接待
     */
    private Long routeChatDepartmentId;

    /**
     * 本地分配对话的接待组名称
     */
    private String routeChatDepartmentName;

    /**
     * 对话页面
     */
    private String chatPage;

    /**
     * 对话页面标题
     */
    private String chatPageTitle;

    /**
     * 访客的对话次数
     */
    private Integer chatTimes;

    /**
     * 对话发起的方式。1：点击图标，2：接受邀请对话，3：客服主动对话，4：微信输入任意文字接入对话，5：微信点击菜单接入，6：微信输入指定文字接入，7：微信机器人转人工，11：机器人转人工，12：机器人转留言，14：web自动弹屏自动接入，15：web自动弹屏访客输入消息接入，16：商户留言转平台接入，17：微信开发者接入，18：自定义渠道事件接入，19：自定义渠道发送消息接入，21：微信指定路由接入，26：邮箱渠道发送留言接入
     */
    private Integer chatEvent;

    /**
     * 请求对话的时间
     */
    private Date chatRequestTime;

    /**
     * 对话接通的时间
     */
    private Date chatAnswerTime;

    /**
     * 会话类型。1：在线对话，2：忙碌对话，3：离线消息，5：机器人对话
     */
    private Integer chatType;

    /**
     * 接待对话的客服ID
     */
    private Long chatStaffId;

    /**
     * 接待对话的客服账号
     */
    private String chatStaffLogname;

    /**
     * 接待对话的客服姓名
     */
    private String chatStaffName;

    /**
     * 接待对话的客服的内部角色名称
     */
    private String chatStaffRole;

    /**
     * 对话入口
     */
    private String chatEntrance;

    /**
     * 对话记录的ID
     */
    private String chatRecordId;

    /**
     * 访客等待时长。单位：毫秒
     */
    private Long chatWaitTime;

    /**
     * 本次分配对话的分组ID。0：全部人员可接
     */
    private Long chatDepartmentId;

    /**
     * 本次分配对话的分组名
     */
    private String chatDepartmentName;

    /**
     * 满意度评价。1：非常不满意，2：不满意，3：一般，4：满意，5：非常满
     */
    private Integer chatScore;

    /**
     * 评价维度
     */
    private String scoreDimension;

    /**
     * 评价的内容
     */
    private String scoreSuggest;

    /**
     * 评价发生时，正在接待对话的客服ID
     */
    private String scoreChatStaffId;

    /**
     * 评价发生时，正在接待对话的客服账号
     */
    private String scoreChatStaffLogname;

    /**
     * 评价发生时，正在接待对话的客服姓名
     */
    private String scoreChatStaffName;

    /**
     * 对话评估主题
     */
    private String chatSubject;

    /**
     * 对话评估备注
     */
    private String chatSubjectMemo;

    /**
     * 对话结束时间
     */
    private Date chatEndTime;

    /**
     * 对话结束方式。0：未知，1：访客结束对话，2：客服结束对话，3：访客超时，5：客服退出，6：系统关闭，8：访客长时间未回复结束，12：忙碌放弃结束，14：留言超时结束，15：机器人自动转人工结束，16：机器人手动转人工结束，18：客服主动对话后留言/机器人对话结束，19：机器人超时结束
     */
    private Integer chatEndType;

    /**
     * 通话时长。单位：毫秒
     */
    private Long chatTotalTime;

    /**
     * 首次响应时长。单位：毫秒
     */
    private Long firstAnswerTime;

    /**
     * 平均响应时长。单位：毫秒
     */
    private Long avgAnswerTime;

    /**
     * 访客发送消息条数
     */
    private Integer visitorSendMsg;

    /**
     * 客服发送消息条数
     */
    private Integer staffSendMsg;

    /**
     * 是否邀评。0：没有邀评，1：有邀评
     */
    private Integer activelyinviteEvaluating;

    /**
     * 对话内容
     */
    private String chatContent;

    /**
     * 客服ID
     */
    private Long staffId;

    /**
     * 客服账
     */
    private String staffLogname;

    /**
     * 客服姓
     */
    private String staffName;

    /**
     * 所有者ID
     */
    private Long ownerId;

    /**
     * 所有者账号
     */
    private String ownerLogname;

    /**
     * 所有者姓名
     */
    private String ownerName;

    /**
     * 完全匹配数
     */
    private Integer perfectMatchs;

    /**
     * 精准匹配数
     */
    private Integer exactMatchs;

    /**
     * 相似匹配数
     */
    private Integer similarityMatchs;

    /**
     * 未命中数
     */
    private Integer misMatchCount;

    /**
     * 点击解决数
     */
    private Integer solvedCount;

    /**
     * 点击未解决数
     */
    private Integer unsolvedCount;
}
