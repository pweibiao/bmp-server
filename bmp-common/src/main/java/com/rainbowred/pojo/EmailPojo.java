package com.rainbowred.pojo;

import lombok.Data;

/**
 * @Desc: 邮件发送实体
 * @Date: 2023/2/14 10:06
 * @Author: pengweibiao
 **/
@Data
public class EmailPojo extends BasePojo{

    public EmailPojo(){}

    public EmailPojo(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    /**
     * 接受邮箱
     */
    private String to;

    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

}
