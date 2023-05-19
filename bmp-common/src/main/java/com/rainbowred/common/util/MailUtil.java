package com.rainbowred.common.util;

import com.rainbowred.pojo.EmailPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Date: 2023/2/14 10:04
 * @Author: pengweibiao
 **/
@Component
public class MailUtil {

    @Autowired
    private JavaMailSenderImpl sender;

    @Autowired
    MailProperties mailProperties;

    // 发送优先
    public void sendEmail(EmailPojo emailPojo) {
        // 构建简单邮箱发送对象
        SimpleMailMessage message=new SimpleMailMessage();
        String username = mailProperties.getProperties().get("username");
        if (StringUtil.isEmpty(username)) {
            username = "kathmikkel@163.com";
        }
        message.setFrom(username);
        message.setTo(emailPojo.getTo());
        message.setSubject(emailPojo.getSubject());
        message.setText(emailPojo.getContent());
        // 发送
        sender.send(message);
    }

}
