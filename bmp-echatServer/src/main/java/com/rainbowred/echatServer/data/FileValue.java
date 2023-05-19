package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @Desc:
 * @Date: 2022/7/11 20:47
 * @Author: pengweibiao
 **/
@Data
public class FileValue extends BaseData{

    @XmlElement(name = "url")
    private String url;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "size")
    private Long size;

    @XmlElement(name = "fileType")
    private Integer fileType;

    @XmlElement(name = "key")
    private String key;

    @XmlElement(name = "bucket")
    private String bucket;

    @XmlTransient
    public String getUrl() {
        return url;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    @XmlTransient
    public Long getSize() {
        return size;
    }

    @XmlTransient
    public Integer getFileType() {
        return fileType;
    }

    @XmlTransient
    public String getKey() {
        return key;
    }

    @XmlTransient
    public String getBucket() {
        return bucket;
    }
}
