package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc: leaveMsgContent 事件中产生
 * @Date: 2022/7/7 20:58
 * @Author: pengweibiao
 **/
@Data
public class CrmData extends BaseData{

    /**
     * 访客的唯一值
     */
    @XmlElement(name = "visitorId")
    private String visitorId;

    /**
     * 客户类别
     */
    @XmlElement(name = "category")
    private String category;

    /**
     * 客户姓名
     */
    @XmlElement(name = "name")
    private String name;

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
     * 婚姻状况。0：未知 1：未婚 2：已婚
     */
    @XmlElement(name = "maritalStatus")
    private Integer maritalStatus;

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
     * 客户所在国家
     */
    @XmlElement(name = "nation")
    private String nation;

    /**
     * 客户所在省份
     */
    @XmlElement(name = "province")
    private String province;

    /**
     * 客户所在城市
     */
    @XmlElement(name = "city")
    private String city;

    /**
     * 客户地址
     */
    @XmlElement(name = "address")
    private String address;

    /**
     * 客户头像地址
     */
    @XmlElement(name = "photo")
    private String photo;

    /**
     * 客户信息备注
     */
    @XmlElement(name = "memo")
    private String memo;

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

    @XmlTransient
    public String getVisitorId() {
        return visitorId;
    }

    @XmlTransient
    public String getCategory() {
        return category;
    }

    @XmlTransient
    public String getName() {
        return name;
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
    public Integer getAge() {
        return age;
    }

    @XmlTransient
    public String getBirthday() {
        return birthday;
    }

    @XmlTransient
    public Integer getMaritalStatus() {
        return maritalStatus;
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
    public String getAddress() {
        return address;
    }

    @XmlTransient
    public String getPhoto() {
        return photo;
    }

    @XmlTransient
    public String getMemo() {
        return memo;
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
}
