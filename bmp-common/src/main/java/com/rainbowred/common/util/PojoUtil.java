package com.rainbowred.common.util;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbowred.common.domain.SystemBaseConfig;
import com.rainbowred.common.enums.ConfigCode;
import com.rainbowred.common.service.SystemBaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Description: pojo工具
 * @Author: pwb
 * @Date: Created in 2022/1/23 15:54
 */
@Component
public class PojoUtil {

    private static final int UUIDLENGTH = 10;

    /**
     * 功能页
     */
    public static final String UTIL_ELE_ID = "7CD5F6223C";

    /**
     * 内容页
     */
    public static final String CONT_ELE_ID = "41C59B0575";

    @Autowired
    private SystemBaseConfigService baseConfigService;

    /**
     * 生成uuid
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        int length = uuid.length();
        int index = length - 1;
        return uuid.substring(index - UUIDLENGTH, index).toUpperCase();
    }

//    /**
//     * 获取用户登录信息
//     * @return
//     */
//    public static String getUsername() {
//        // 从SpringSecurity上下文中获取 当前登录用户信息
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (Objects.isNull(principal)) {
//            return null;
//        }
//        String username;
//        try {
//            // 获取用户账号
//            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(principal));
//            username = jsonObject.get("username").toString();
//        }catch (Exception e) {
//            username = "anyoneVisitor";
//        }
//        return username;
//    }

    /**
     * 获取管理员 （todo：临时方案）
     * @param username
     * @return true 管理员 false 非管理员
     */
    public boolean validAdmin(String username){
        // 查询配置
        QueryWrapper<SystemBaseConfig> sbQw = new QueryWrapper<>();
        sbQw.eq("main_code", ConfigCode.ADMIN_MAIN_CODE.getValue())
                        .eq("sub_code", ConfigCode.ADMIN_SUB_CODE.getValue());
        List<SystemBaseConfig> list = baseConfigService.list(sbQw);
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        // 配置了管理员的账号
        List<String> usernames = list.stream().map(SystemBaseConfig::getDataValue).collect(Collectors.toList());
        if (usernames.contains(username)) {
            return true;
        }
        return false;
    }

}
