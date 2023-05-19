package com.rainbowred.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Desc:
 * @Date: 2023/2/14 09:45
 * @Author: pengweibiao
 **/
@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class EmailConfig {

    @Autowired
    MailProperties mailProperties;

    @Bean
    JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(mailProperties.getHost());
        sender.setPort(mailProperties.getPort());
        sender.setUsername(mailProperties.getUsername());
        sender.setPassword(mailProperties.getPassword());
        return sender;
    }

}
