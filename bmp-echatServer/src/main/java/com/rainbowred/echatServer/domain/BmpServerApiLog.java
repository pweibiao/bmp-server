package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.pojo.BasePojo;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 服务器交互日志
 * @TableName bmp_server_api_log
 */
@Data
@TableName(value ="bmp_server_api_log")
public class BmpServerApiLog extends BasePojo {

    public BmpServerApiLog() {}

    public BmpServerApiLog(String companyId, String dataType, Long postTime) {
        this.companyId = companyId;
        this.dataType = dataType;
        this.postTime = postTime;
    }

    /**
     * 消息ID，服务器交互数据消息唯一id
     */
    private String msgId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 时间产生时间
     */
    private Long timestamp;

    /**
     * 事件类型
     */
    private String dataType;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 密文
     */
    private String ciphertext;

    /**
     * 明文
     */
    private String plaintext;

    /**
     * 服务器接收POST数据时间
     */
    private Long postTime;

    /**
     * 请求参数
     */
    private String debug;

    /**
     * 时间格式化
     */
    @TableField(exist = false)
    private String createDateStr;

    public void setCreateDateStr(SimpleDateFormat simpleDateFormat) {
        this.createDateStr = simpleDateFormat.format(new Date(this.timestamp));
    }

    /**
     * 请求时间差
     */
    @TableField(exist = false)
    private Long timeEd;

    public void setTimeEd() {
        this.timeEd = new BigDecimal(timestamp).subtract(new BigDecimal(postTime)).longValue();
    }

}
