package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.data.CrmData;
import com.rainbowred.echatServer.data.OwnerData;
import com.rainbowred.echatServer.xml.CrmStatus;
import lombok.Data;

import java.util.Date;

/**
 * 客户数据
 * @TableName bmp_server_crm_data
 */
@Data
@TableName(value ="bmp_server_crm_data")
public class BmpServerCrmData extends BaseBizDomain {

    public BmpServerCrmData() {}

    /**
     * 客户数据，客户分配
     */
    public BmpServerCrmData(CrmStatus pojo) {
        Date now = new Date();
        this.crmStatus = pojo.getCrmStatus();
        String visitorId = pojo.getVisitorId();
        Long staffId = pojo.getStaffId();
        String staffName = pojo.getStaffName();
        String staffLogname = pojo.getStaffLogname();
        this.setId(visitorId);
        this.visitorId = visitorId;
        this.createStaffId = staffId;
        this.createStaffName = staffName;
        this.createStaffLogname = staffLogname;
        this.createCrmDate = now;
        this.updateStaffId = staffId;
        this.updateStaffName = staffName;
        this.updateStaffLogname = staffLogname;
        this.updateCrmDate = now;
        this.distributeStaffId = staffId;
        this.distributeStaffName = staffName;
        this.distributeStaffLogname = staffLogname;
        this.distributeCrmDate = now;

        CrmData crmData = pojo.getCrmData();
        if (crmData != null) {
            this.category = crmData.getCategory();
            this.name = crmData.getName();
            this.nickName = crmData.getNickName();
            this.gender = crmData.getGender();
            this.age = crmData.getAge().toString();
            this.birthday = crmData.getBirthday();
            this.maritalStatus = crmData.getMaritalStatus();
            this.phone = crmData.getPhone();
            this.qq = crmData.getQq();
            this.wechat = crmData.getWechat();
            this.email = crmData.getEmail();
            this.nation = crmData.getNation();
            this.province = crmData.getProvince();
            this.city = crmData.getCity();
            this.address = crmData.getAddress();
            this.photo = crmData.getPhoto();
            this.memo = crmData.getMemo();
            this.c1 = crmData.getC1();
            this.c2 = crmData.getC2();
            this.c3 = crmData.getC3();
            this.c4 = crmData.getC4();
            this.c5 = crmData.getC5();
            this.c6 = crmData.getC6();
            this.c7 = crmData.getC7();
            this.c8 = crmData.getC8();
            this.c9 = crmData.getC9();
            this.c10 = crmData.getC10();
            this.c11 = crmData.getC11();
            this.c12 = crmData.getC12();
            this.c13 = crmData.getC13();
            this.c14 = crmData.getC14();
            this.c15 = crmData.getC15();
            this.c16 = crmData.getC16();
            this.c17 = crmData.getC17();
            this.c18 = crmData.getC18();
            this.c19 = crmData.getC19();
            this.c20 = crmData.getC20();
        }

        OwnerData ownerData = pojo.getOwnerData();
        if (ownerData != null) {
            this.ownerId = ownerData.getOwnerId();
            this.ownerLogname = ownerData.getOwnerLogName();
            this.ownerName = ownerData.getOwnerName();
            // 此次更新不改修改者
            this.updateCrmDate = null;
            this.updateStaffId = null;
            this.updateStaffName = null;
            this.updateStaffLogname = null;
        }
    }

    /**
     * 访客ID
     */
    private String visitorId;

    /**
     * 客户信息状态。1：访客在信息收集窗口填写了数据，对话开始后自动触发，2：客服手动在一洽CRM系统填写了客户信息，3：客服分配客户
     */
    private String crmStatus;

    /**
     * 创建数据的客服ID"
     */
    private Long createStaffId;

    /**
     * 创建数据的客服账号
     */
    private String createStaffLogname;

    /**
     * 创建数据的客服姓名
     */
    private String createStaffName;

    /**
     * 创建数据的时间
     */
    private Date createCrmDate;

    /**
     * 修改数据的客服ID"
     */
    private Long updateStaffId;

    /**
     * 修改数据的客服账号
     */
    private String updateStaffLogname;

    /**
     * 修改数据的客服姓名
     */
    private String updateStaffName;

    /**
     * 修改数据的时间
     */
    private Date updateCrmDate;

    /**
     * 分配数据的客服ID"
     */
    private Long distributeStaffId;

    /**
     * 分配数据的客服账号
     */
    private String distributeStaffLogname;

    /**
     * 分配数据的客服姓名
     */
    private String distributeStaffName;

    /**
     * 分配数据的时间
     */
    private Date distributeCrmDate;

    /**
     * 客户类别
     */
    private String category;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户昵称
     */
    private String nickName;

    /**
     * 客户性别。0：未知，1：男，2：女"
     */
    private Integer gender;

    /**
     * 客户年龄
     */
    private String age;

    /**
     * 客户生日
     */
    private String birthday;

    /**
     * 婚姻状况。0：未知，1：未婚，2：已婚"
     */
    private Integer maritalStatus;

    /**
     * 客户电话
     */
    private String phone;

    /**
     * 客户qq
     */
    private String qq;

    /**
     * 客户微信
     */
    private String wechat;

    /**
     * 客户邮箱
     */
    private String email;

    /**
     * 客户所在国家
     */
    private String nation;

    /**
     * 客户所在省份
     */
    private String province;

    /**
     * 客户所在城市
     */
    private String city;

    /**
     * 客户所在地址
     */
    private String address;

    /**
     * 客户头像地址
     */
    private String photo;

    /**
     * 客户备注
     */
    private String memo;

    /**
     * 自定义字段
     */
    private String c1;

    /**
     * 自定义字段
     */
    private String c2;

    /**
     * 自定义字段
     */
    private String c3;

    /**
     * 自定义字段
     */
    private String c4;

    /**
     * 自定义字段
     */
    private String c5;

    /**
     * 自定义字段
     */
    private String c6;

    /**
     * 自定义字段
     */
    private String c7;

    /**
     * 自定义字段
     */
    private String c8;

    /**
     * 自定义字段
     */
    private String c9;

    /**
     * 自定义字段
     */
    private String c10;

    /**
     * 自定义字段
     */
    private String c11;

    /**
     * 自定义字段
     */
    private String c12;

    /**
     * 自定义字段
     */
    private String c13;

    /**
     * 自定义字段
     */
    private String c14;

    /**
     * 自定义字段
     */
    private String c15;

    /**
     * 自定义字段
     */
    private String c16;

    /**
     * 自定义字段
     */
    private String c17;

    /**
     * 自定义字段
     */
    private String c18;

    /**
     * 自定义字段
     */
    private String c19;

    /**
     * 自定义字段
     */
    private String c20;

    /**
     * 数据所有者的客服ID
     */
    private Long ownerId;

    /**
     * 数据所有者的客服账号
     */
    private String ownerLogname;

    /**
     * 数据所有者的客服姓名
     */
    private String ownerName;
}
