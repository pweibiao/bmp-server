package com.rainbowred.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Desc: spring工具
 * @Date: 2022/8/2 01:35
 * @Author: pengweibiao
 **/
@Component
//指定Lazy为false,防止junit测试默认全局lazy-init=true时导致未加载
@Lazy(false)
public class SpringUtils implements ApplicationContextAware, DisposableBean {

    private final static Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    /** applicationContext */
    private static ApplicationContext applicationContext;

    /**
     * 不可实例化
     */
    private SpringUtils() {
    }

    @Override
    public void destroy() throws Exception {
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }


    public static Object getAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public static HttpSession getSession() {
        return (HttpSession) getRequest().getSession();
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static Object getBean(String s) {
        return applicationContext.getBean(s);
    }

}
