package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc: 留言分配的客服
 * @Date: 2022/7/7 21:04
 * @Author: pengweibiao
 **/
@Data
public class OwnerData extends BaseData{

    /**
     * 被分配客服ID
     */
    @XmlElement(name = "ownerId")
    private Long ownerId;

    /**
     * 被分配客服账号
     */
    @XmlElement(name = "ownerLogname")
    private String ownerLogName;

    /**
     * 被分配客服姓名
     */
    @XmlElement(name = "ownerName")
    private String ownerName;

    @XmlTransient
    public Long getOwnerId() {
        return ownerId;
    }

    @XmlTransient
    public String getOwnerLogName() {
        return ownerLogName;
    }

    @XmlTransient
    public String getOwnerName() {
        return ownerName;
    }
}
