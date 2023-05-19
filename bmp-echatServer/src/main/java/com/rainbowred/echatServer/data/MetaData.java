package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc: 一洽业务结构数据,xml真实字段
 * @Date: 2022/7/7 18:29
 * @Author: pengweibiao
 **/
@Data
public class MetaData extends BaseData{

    /**
     * 会员的唯一值
     */
    @XmlElement(name = "uid")
    private String uid;

    /**
     * 会员级别
     */
    @XmlElement(name = "grade")
    private String grade;

    /**
     * 会员类别
     */
    @XmlElement(name = "category")
    private String category;

    /**
     * 会员姓名
     */
    @XmlElement(name = "name")
    private String name;

    /**
     * 会员昵称
     */
    @XmlElement(name = "nickName")
    private String nickName;

    /**
     * 会员性别
     */
    @XmlElement(name = "gender")
    private String gender;

    /**
     * 会员年龄
     */
    @XmlElement(name = "age")
    private String age;

    /**
     * 会员生日
     */
    @XmlElement(name = "birthday")
    private String birthday;

    /**
     * 会员婚姻状况。0：未知 1：未婚 2：已婚
     */
    @XmlElement(name = "maritalStatus")
    private String maritalStatus;

    /**
     * 会员联系电话
     */
    @XmlElement(name = "phone")
    private String phone;

    /**
     * 会员QQ
     */
    @XmlElement(name = "qq")
    private String qq;

    /**
     * 会员微信
     */
    @XmlElement(name = "wechat")
    private String wechat;

    /**
     * 会员邮件地址
     */
    @XmlElement(name = "email")
    private String email;

    /**
     * 会员国家
     */
    @XmlElement(name = "nation")
    private String nation;

    /**
     * 会员省份
     */
    @XmlElement(name = "province")
    private String province;

    /**
     * 会员城市
     */
    @XmlElement(name = "city")
    private String city;

    /**
     * 会员地址
     */
    @XmlElement(name = "address")
    private String address;

    /**
     * 会员头像地址
     */
    @XmlElement(name = "photo")
    private String photo;

    /**
     * 会员备注信息
     */
    @XmlElement(name = "memo")
    private String memo;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c1")
    private String c1;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c2")
    private String c2;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c3")
    private String c3;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c4")
    private String c4;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c5")
    private String c5;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c6")
    private String c6;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c7")
    private String c7;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c8")
    private String c8;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c9")
    private String c9;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c10")
    private String c10;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c11")
    private String c11;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c12")
    private String c12;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c13")
    private String c13;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c14")
    private String c14;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c15")
    private String c15;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c16")
    private String c16;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c17")
    private String c17;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c18")
    private String c18;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c19")
    private String c19;

    /**
     * 会员自定义字段
     */
    @XmlElement(name = "c20")
    private String c20;


    @XmlTransient
    public String getUid() {
        return uid;
    }

    @XmlTransient
    public String getGrade() {
        return grade;
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
    public String getGender() {
        return gender;
    }

    @XmlTransient
    public String getAge() {
        return age;
    }

    @XmlTransient
    public String getBirthday() {
        return birthday;
    }

    @XmlTransient
    public String getMaritalStatus() {
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
