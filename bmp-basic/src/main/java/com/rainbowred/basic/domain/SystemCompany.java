package com.rainbowred.basic.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司配置
 * @TableName bmp_basic_system_company
 */
@TableName(value = "bmp_basic_system_company")
@Data
public class SystemCompany extends BaseBizDomain {

    /**
     * 公司名称
     */
    private String name;

    /**
     * appid
     */
    private String appid;

    /**
     * aeskey
     */
    private String aeskey;

    /**
     * token
     */
    private String token;

    /**
     * 服务端地址
     */
    private String serverUrl;

    /**
     * 访客端地址
     */
    private String visitorUrl;

    /**
     * 服务器接口地址
     */
    private String apiUrl;

    /**
     * 日志保留天数
     */
    private Integer logData;

    public Map<String, String> getAesCodeMap() {
        Map<String, String> aesInfoMap = new HashMap<>();
        aesInfoMap.put("token", token);
        aesInfoMap.put("aeskey", aeskey);
        aesInfoMap.put("appid", appid);
        return aesInfoMap;
    }

}
