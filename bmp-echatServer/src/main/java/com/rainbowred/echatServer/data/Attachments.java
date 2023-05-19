package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @Desc:
 * @Date: 2022/7/11 20:46
 * @Author: pengweibiao
 **/
@Data
public class Attachments extends BaseData{

    /**
     * 附件
     */
    @XmlElement(name = "attachment")
    private List<Attachment> attachment;

    @XmlTransient
    public List<Attachment> getAttachment() {
        return attachment;
    }
}
