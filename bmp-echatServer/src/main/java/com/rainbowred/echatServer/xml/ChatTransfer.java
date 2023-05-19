package com.rainbowred.echatServer.xml;


import com.rainbowred.echatServer.data.BaseData;
import com.rainbowred.echatServer.data.TransferData;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Desc:
 * @Date: 2022/7/8 00:34
 * @Author: pengweibiao
 **/
@Data
@XmlRootElement(name = "xml")
public class ChatTransfer extends BaseData {

    /**
     * 转接数据
     */
    private TransferData transferData;

}
