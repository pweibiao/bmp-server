package com.rainbowred.common.util;

import cn.hutool.core.util.URLUtil;
import com.google.common.collect.Maps;
import io.jsonwebtoken.lang.Collections;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc: String工具
 * @Date: 2022/5/20 15:26
 * @Author: pengweibiao
 **/
public class StringUtil {


    // 一洽下发统一事件格式
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean nonEmpty(String s) {
        return !isEmpty(s);
    }

    /**
     * 字符串是否无效
     * @param s 传入的字符串
     * @return true-无效 false-有效
     */
    public static boolean isEmpty(String s) {
        return Objects.isNull(s) || s.equals("");
    }

    /**
     * 解析GET请求中，URL拼接的参数
     */
    public static Map<String, String> getMap(String urlParam) {
        Map<String, String> resultMap = Maps.newHashMap();
        if (nonEmpty(urlParam) && urlParam.contains("&") && urlParam.contains("=")) {
            String[] split = urlParam.split("&");
            for (String s : split) {
                String[] split1 = s.split("=");
                if (split1.length > 1) {
                    resultMap.put(split1[0], split1[1]);
                }
            }
        }
        return resultMap;
    }

    /**
     * 公司-渠道 key 拼接
     * @param compId
     * @param mediaId
     * @return
     */
    public static String packingCompKey(String compId, String mediaId) {
        if (nonEmpty(compId) && nonEmpty(mediaId)) {
            return new StringBuilder(compId).append(":").append(mediaId).toString();
        }
        return new String();
    }

    /**
     * 时间String转Date
     */
    public static Date dateStringTransfer(String datetime) {
        Date date = new Date();
        try {
            date = format.parse(datetime);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 去除html文本 行字符串 中 指定的属性
     * 例如：<div ondblclick="editContent" contenteditable="true"><a>asd</a></div>
     * 去除 contenteditable 属性
     * 结果：<div ondblclick="editContent" ><a>asd</a></div>
     */
    public static String removeHtmlFieldStrs(String htmlText, List<String> aimStrs) {
        if (StringUtil.nonEmpty(htmlText) && !Collections.isEmpty(aimStrs)) {
            // 循环需要移除的目标字符串
            for (String aimStr : aimStrs) {
                StringBuffer sb = new StringBuffer();
                if (htmlText.contains(aimStr)) {
                    // 移除目标字符 切割
                    String[] split = htmlText.split(aimStr);
                    // 切割后 保留头
                    sb.append(split[0]);
                    // 需要循环的删减 后续片段的 属性内容
                    for (int i = 1; i < split.length; i++) {
                        // 去除 "xxx" 属性内容
                        String content = split[i];
                        // 获取第一个 " 位置
                        int i1 = content.indexOf("\"");
                        // 获取第二个 " 位置
                        int i2 = content.indexOf("\"", i1+1);
                        sb.append(content.substring(i2 + 1));
                    }
                }
                // 赋值处理后的结果
                htmlText = sb.toString();
            }
        }
        return htmlText;
    }

    /**
     * 去除 ${ } 标识
     */
    public static String removeHtmlRemarkStr(String htmlText, String remark, String str) {
        // 若存在才执行
        if (htmlText.contains(remark)) {
            // 切割
            String[] split = htmlText.split("\\$\\{"+ remark +"}");
            // 替换目标字符串
            htmlText = split[0] + str + ( split.length > 1 ? split[1] : "");
        }
        return htmlText;
    }

    /**
     * 在文本中找到目标字符并替换成指定字符（以aimStr结尾的不替换）
     * @param text 文本
     * @param aimStr 目标字符
     * @param replaceStr 指定字符
     * @return
     */
    public static String replace(String text, String aimStr, String replaceStr) {
        if (StringUtil.isEmpty(text)
                || StringUtil.isEmpty(aimStr)
                || StringUtil.isEmpty(replaceStr)
                || !text.contains(aimStr)) {
            return text;
        }
        // 根据目标字符拆解
        String[] split = text.split(aimStr);
        StringBuffer sb = new StringBuffer(split[0]);
        if (split.length > 1) {
            for (int i = 1; i < split.length; i++) {
                sb.append(replaceStr).append(split[i]);
            }
        }else {
            sb.append(replaceStr);
        }
        return sb.toString();
    }

    /**
     * 判断两个字符串是否一样
     * 当都为 null 返回 true
     * 1    2
     * 1    1
     * @param aStr
     * @param bStr
     * @return
     */
    public static boolean isEqual(String aStr, String bStr) {
        if (aStr != null && bStr != null) {
            return aStr.equals(bStr);
        }else if (aStr == null && bStr == null){
            return true;
        }else {
            return false;
        }
    }

}
