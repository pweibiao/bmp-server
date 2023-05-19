package com.rainbowred;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Desc:
 * @Date: 2022/10/31 21:37
 * @Author: pengweibiao
 **/
// 标识启动类
@SpringBootApplication(scanBasePackages = {"com.rainbowred.*.service"})
// 开启事务
@EnableTransactionManagement
// mapper包扫描
@MapperScan("com.rainbowred.*.mapper")
// 开启异步线程
@EnableAsync
// 组件扫描
@ComponentScan(basePackages = {
        "com.rainbowred.*.controller",
        "com.rainbowred.*.service",
        "com.rainbowred.*.config",
        "com.rainbowred.*.util",
        "com.rainbowred.*.handler"})
@Slf4j
@EnableAspectJAutoProxy
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("bmp start successful -- ");
    }
}
