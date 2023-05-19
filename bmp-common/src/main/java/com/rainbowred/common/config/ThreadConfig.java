package com.rainbowred.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Desc:
 * @Date: 2023/5/15 17:43
 * @Author: pengweibiao
 **/
@Configuration
@Slf4j
@EnableAsync
@EnableScheduling
public class ThreadConfig {

    @Bean
    public ThreadPoolTaskExecutor asyncEchatEvent(){
        log.info("=====ThreadConfig-asyncCommon=====start asyncCommon=====");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(10);
        //配置最大线程数
        executor.setMaxPoolSize(15);
        //配置队列大小
        executor.setQueueCapacity(1000);
        //线程的名称前缀
        executor.setThreadNamePrefix("async-echatServerEventService-");
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //执行初始化
        executor.initialize();
        return executor;
    }

}
