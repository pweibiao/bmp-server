package com.rainbowred.common.util.aes;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

/**
 * @Desc: AES加密工具类
 *  todo: 暂时使用map存储公司对应的关键信息方案
 * @Date: 2022/4/13 18:08
 * @Author: pengweibiao
 **/
@Slf4j
public class AESEncodingUtil {

    static Base64 base64 = new Base64();

    static Charset CHARSET = Charset.forName("utf-8");

    /**
     * 用于随机选的数字
     */
    public static final String BASE_NUMBER = "0123456789";

    /**
     * 用于随机选的字符
     */
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 用于随机选的字符和数字
     */
    public static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;


    /**
     * 对一洽服务器下发的密文解密
     * @param postDate 加密数据
     * @return
     * @throws Exception
     */
    public static String getDecrypt(String postDate, Map<String, String> compInfo) throws AesException {
        String token = compInfo.get("token");
        String aesKey = compInfo.get("aeskey");
        String appId = compInfo.get("appid");
        // 提取密文
        WXBizMsgCrypt crypt = new WXBizMsgCrypt(token, aesKey, appId);
        return crypt.decrypt(postDate);
    }


    /**
     * 对一洽服务器下发的服务器交互XML密文解密
     * @param postDate xml 数据
     * @return
     * @throws Exception
     */
    public static String getXMLDecrypt(String msgSignature, String timeStamp, String nonce, String postDate, Map<String, String> compInfo) throws AesException {
        String token = compInfo.get("token");
        String aesKey = compInfo.get("aeskey");
        String appId = compInfo.get("appid");
        // 提取密文
        WXBizMsgCrypt crypt = new WXBizMsgCrypt(token, aesKey, appId);
        return crypt.decryptMsg(msgSignature, timeStamp, nonce, postDate);
    }

    /**
     * 对一洽服务器下发的服务器交互XML密文解密
     * @param postDate xml 数据
     * @return
     * @throws Exception
     */
    public static String getWechatXMLDecrypt(String msgSignature, String timeStamp, String nonce, String postDate, Map<String, String> compInfo) throws AesException {
        String token = compInfo.get("token");
        String aesKey = compInfo.get("aeskey");
        String appId = compInfo.get("appid");
        // 提取密文
        WXBizMsgCrypt crypt = new WXBizMsgCrypt(token, aesKey, appId);
        return crypt.DecryptMsg(msgSignature, timeStamp, nonce, postDate);
    }

    /**
     * 对明文进行加密
     * @param msg 明文
     * @return
     */
    public static String encodeEncrypt(String msg, Map<String, String> compInfo) throws Exception{
        String nonce = getNonce();
        String timestamp = new Long(new Date().getTime()).toString();
        return encodeEncrypt(nonce, timestamp, msg, compInfo);
    }

    /**
     * 对明文进行加密
     * @param nonce 随机字符
     * @param msg 明文
     * @return
     */
    public static String encodeEncrypt(String nonce, String timestamp, String msg, Map<String, String> compInfo) throws Exception{
        String token = compInfo.get("token");
        String aesKey = compInfo.get("aeskey");
        String appId = compInfo.get("appid");
        WXBizMsgCrypt pc = new WXBizMsgCrypt(token, aesKey, appId);
        return pc.xmlEncryptMsg(msg, timestamp, nonce);
    }

    /**
     * 明文加密封装XMl格式
     * @param body
     * @param compInfo
     * @return
     * @throws Exception
     */
    public static String encodeXml(String body, Map<String, String> compInfo) throws Exception {
        // 对请求体加密
        String encrypt = encodeEncrypt(body, compInfo);
        // 封装xml
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(encrypt);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);
        Element root = document.getDocumentElement();
        NodeList nodelist1 = root.getElementsByTagName("Encrypt");
        String code = nodelist1.item(0).getTextContent();
        String postBody = "{\"\":\""+ code +"\"}";
        return postBody;
    }

    /**
     * 生成用于加密的随机数
     * @return
     */
    public static String getNonce(){
        return RandomUtil.randomString(BASE_CHAR_NUMBER,8);
    }

}
