package com.rainbowred.common.util;

import com.alibaba.fastjson.JSONObject;
import com.rainbowred.common.util.aes.AESEncodingUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Desc: 针对一洽服务器的工具类
 * @Date: 2023/5/15 14:39
 * @Author: pengweibiao
 **/
@Slf4j
public class EchatUtil {

    /**
     * 每次收到post请求后需要返回一洽 success 没有返回一洽会判断为未收到而重新发送
     */
    public static String SUCCESS = "success";


    /**
     * 请求体xml格式密文解密
     * @param encrypt 一洽下的xml格式数据
     * @param aesDecodingInfo 解密所需的token、aeskey、appid
     * @return
     */
    public static String xmlDecoding(String encrypt, Map<String, String> aesDecodingInfo) {
        if (encrypt != null && !encrypt.equals("")) {
            // 请求报文解密
            String decrypt = null;
            try {
                String code = XMLUtil.getEncrypt(encrypt)[1].toString();
                // 解密
                decrypt = AESEncodingUtil.getDecrypt(code, aesDecodingInfo);
            } catch (Exception e) {
                log.info("==========xmlEncoding==========="+encrypt+"\n"+ JSONObject.toJSONString(aesDecodingInfo));
                e.printStackTrace();
            }
            return decrypt;

        }
        return encrypt;
    }

}
