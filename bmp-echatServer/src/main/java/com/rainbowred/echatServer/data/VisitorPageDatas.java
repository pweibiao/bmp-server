package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @Desc:
 * @Date: 2022/7/11 11:34
 * @Author: pengweibiao
 **/
@Data
public class VisitorPageDatas extends BaseData {

    /**
     * 浏览轨迹
     */
    @XmlElement(name = "pageData")
    private List<PageData> pageData;

    @XmlTransient
    public List<PageData> getPageData() {
        return pageData;
    }
}
