package com.rainbowred.pojo;

import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.domain.BaseDomain;
import lombok.Data;

/**
 * @Desc: 加解密实体对象
 * @Date: 2022/8/22 15:38
 * @Author: pengweibiao
 **/
@Data
public class EncryptPojo extends BaseBizDomain {

    public EncryptPojo() {}

    public EncryptPojo(String tm, String nonce, String msgSignature, String code) {
        this.tm = tm;
        this.nonce = nonce;
        this.msgSignature = msgSignature;
        this.code = code;
    }

    /**
     * 时间戳
     */
    private String tm;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 签名
     */
    private String msgSignature;

    /**
     * 应用id
     */
    private String appId;

    /**
     * aes加密
     */
    private String aesKey;

    /**
     * 身份凭证
     */
    private String token;

    /**
     * 加密数据
     */
    private String code;


}
