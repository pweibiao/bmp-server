package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import lombok.Data;

/**
 * 一洽客服表
 * @TableName bmp_server_echat_staff
 */
@Data
@TableName(value ="bmp_server_echat_staff")
public class BmpServerEchatStaff extends BaseBizDomain {

    /**
     * 客服姓名
     */
    private String name;

    /**
     * 客服账号
     */
    private String loginName;

    /**
     * 客服昵称
     */
    private String nickName;

    /**
     * 客服角色
     */
    private String role;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * wechat openId
     */
    private String openId;

    /**
     * 邮箱
     */
    private String email;
}
