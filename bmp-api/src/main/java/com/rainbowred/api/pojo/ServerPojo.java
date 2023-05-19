package com.rainbowred.api.pojo;


import com.rainbowred.echatServer.domain.BmpServerApiLog;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc: 服务器接收数据类型
 * @Date: 2022/4/13 18:56
 * @Author: pengweibiao
 **/
@Data
public class ServerPojo implements Serializable{
    private static final long serialVersionUID = -1;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 一洽加密签名
     */
    private String signature;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 请求的数据类型
     */
    private String dataType;

    /**
     * 请求体中的xml文本
     */
    private String xml;

    /**
     * 返回一洽服务器参数
     */
    private String echostr;

    /**
     * 返回一洽服务器参数( 知识库接口 不一致字段名 )
     */
    private String echoStr;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 加密内容
     */
    private String cipherContent;

    /**
     * 渠道id
     */
    private String mediaId;

    /**
     * 接收参数转ApiLog对象
     * @return
     */
    public BmpServerApiLog toApiLog() {
        return new BmpServerApiLog(companyId, dataType, timestamp);
    }

}
