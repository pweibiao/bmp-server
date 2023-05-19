package com.rainbowred.echatServer.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.domain.BaseBizDomain;

import com.rainbowred.echatServer.data.MetaData;
import com.rainbowred.echatServer.data.RouteData;
import com.rainbowred.echatServer.data.TrackData;
import com.rainbowred.echatServer.data.VisitorData;
import com.rainbowred.echatServer.xml.VisitorEnter;
import com.rainbowred.echatServer.xml.VisitorOut;
import lombok.Data;

/**
 * 浏览数据
 * @TableName bmp_server_track_record
 */
@Data
@TableName(value ="bmp_server_track_record")
public class BmpServerTrackRecord extends BaseBizDomain {

    public BmpServerTrackRecord() {}

    /**
     * 访客进入
     */
    public BmpServerTrackRecord(VisitorEnter pojo) {

        // 开发者自定义扩展数据
        this.myData = pojo.getMyData();

        // 会员数据
        MetaData metaData = pojo.getMetaData();
        if (metaData != null) {
            this.address = metaData.getAddress();
            this.age = metaData.getAge();
            this.birthday = metaData.getBirthday();
            this.category = metaData.getCategory();
            this.city = metaData.getCity();
            this.email = metaData.getEmail();
            if (StringUtil.nonEmpty(metaData.getGender())) {
                this.gender = new Integer(metaData.getGender());
            }
            if (StringUtil.nonEmpty(metaData.getMaritalStatus())) {
                this.maritalStatus = new Integer(metaData.getMaritalStatus());
            }
            this.memo = metaData.getMemo();
            this.name = metaData.getName();
            this.nation = metaData.getNation();
            this.nickName = metaData.getNickName();
            this.phone = metaData.getPhone();
            this.photo = metaData.getPhoto();
            this.province = metaData.getProvince();
            this.qq = metaData.getQq();
            this.uid = metaData.getUid();
            this.wechat = metaData.getWechat();
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
            // 访客进入时的路由状态
            this.enterRouteStatus = routeData.getRouteStatus();
        }

        TrackData trackData = pojo.getTrackData();
        if (trackData != null) {
            this.setId(trackData.getTrackRecordId().toString());
            this.trackRecordId = trackData.getTrackRecordId();
        }
    }

    /**
     * 访客退出
     */
    public BmpServerTrackRecord(VisitorOut pojo) {
        this.outRouteStatus = pojo.getRouteStatus();
        TrackData trackData = pojo.getTrackData();
        if (trackData != null) {
            this.setId(trackData.getTrackRecordId().toString());
            this.trackRecordId = trackData.getTrackRecordId();
            this.visitPageCount = trackData.getVisitPageCount();
            this.visitTotalTime = trackData.getVisitTotalTime();
            this.chatRecordId = trackData.getChatRecordId();
            this.giveupRecordId = trackData.getGiveUpRecordId();
            if (StringUtil.nonEmpty(trackData.getVisitorOutTime())) {
                this.visitorOutTime = StringUtil.dateStringTransfer(trackData.getVisitorOutTime());
            }
        }
    }

    /**
     * 开发者自定义扩展数据
     */
    private String myData;

    /**
     * 访客进入时的路由状态。1：在线，2：离线
     */
    private Integer enterRouteStatus;

    /**
     * 访客退出时的路由状态。1：在线，2：离线
     */
    private Integer outRouteStatus;

    /**
     * 会员唯一值
     */
    private String uid;

    /**
     * 会员级别。大于0的数字
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
     * 访客进入网站的时间
     */
    private Date visitorEnterTime;

    /**
     * 访客端的媒介。1：电脑端网页，2：移动端网页
     */
    private Integer visitorMedia;

    /**
     * 访客类型。-1：未知，0：游客，1：会员
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
     * 当前访客此次是第几次来访
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
     * 上次对话的客服ID。0：首次对话
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
     * 访客本次会话浏览总页面数量
     */
    private Integer visitPageCount;

    /**
     * 访客本次会话浏览总时长。单位：毫秒
     */
    private Long visitTotalTime;

    /**
     * 访客本次会话产生的人工对话记录ID、机器人对话记录ID、留言对话记录ID
     */
    private String chatRecordId;

    /**
     * 访客本次会话点击对话，弹出信息收集框，放弃的记录ID
     */
    private String giveupRecordId;

    /**
     * 访客离开时间
     */
    private Date visitorOutTime;

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
    private Long chatDepartmentId;

    /**
     * 本地分配对话的接待组名称
     */
    private String chatDepartmentName;

    /**
     * 访客本次会话ID
     */
    private Long trackRecordId;

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
}
