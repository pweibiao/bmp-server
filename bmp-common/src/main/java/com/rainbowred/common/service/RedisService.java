package com.rainbowred.common.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Desc:
 * @Date: 2023/5/15 10:52
 * @Author: pengweibiao
 **/
public interface RedisService {

    /**
     * 设置key-value键值对，并设置有效时间
     * @param key
     * @param value
     * @param time
     */
    void set(String key, Object value, long time);

    /**
     * 设置key-value键值对
     * @param key
     * @param value
     * @return
     */
    void set(String key, Object value);

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    JSONObject get(String key);

    /**
     * 删除缓存
     * @param key
     */
    void del(String key);

    /**
     * 批量删除缓存
     * @param keys
     */
    void del(List<String> keys);

    /**
     * 设置过期时间（单位：秒）
     * @param key
     * @param time
     * @return
     */
    Boolean expire(String key, long time);

    /**
     * 获取过期时间
     */
    Long getExpire(String key);


}
