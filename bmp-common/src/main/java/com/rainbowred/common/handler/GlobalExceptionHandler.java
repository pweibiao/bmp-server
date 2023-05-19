package com.rainbowred.common.handler;

import com.rainbowred.common.exception.BusinessException;
import com.rainbowred.common.service.SystemBaseConfigService;
import com.rainbowred.common.util.aes.AesException;
import com.rainbowred.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @Desc: 异常统一处理
 * @Date: 2022/8/26 14:54
 * @Author: pengweibiao
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    private SystemBaseConfigService baseConfigService;

    /**
     * 处理自定义异常 异常统一处理
     */
    @ExceptionHandler(AesException.class)
    @ResponseStatus(HttpStatus.CHECKPOINT)
    public CommonResult<?> handleAesException(AesException e) {
        log.info("=====GlobalExceptionHandler-handleAesException=====解密失败=====" + e.getLocalizedMessage());
        return CommonResult.error("解密失败："+e.toString());
    }

    /**
     * 处理自定义异常 异常统一处理
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    public CommonResult<?> parameterErrorHandler(BusinessException e) {
        if (Objects.nonNull(e.getCode())) {
            return CommonResult.error(e.getCode(), e.getMessage());
        }
        return CommonResult.error(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(), e.getMessage());
    }

    /**
     * 业务异常 异常统一处理
     * @param e
     * @return
     */
//    @ExceptionHandler(BusinessException.class)
//    public CommonResult<?> businessException(BusinessException e) {
//        log.info("=====GlobalExceptionHandler-businessException=====" + e.getLocalizedMessage());
//        return CommonResult.error(e.getLocalizedMessage());
//    }

    /**
     * 空指针 异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public CommonResult<?> nullPointException(NullPointerException e) {
        log.info("=====GlobalExceptionHandler-nullPointException=====" + e.getLocalizedMessage());
        return CommonResult.error("数据部分为空");
    }

    /**
     * 数据库索引约束 存在重复
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public CommonResult<?> duplicateKeyException(DuplicateKeyException e) {
        log.info("=====GlobalExceptionHandler-duplicateKeyException====="+ e.getLocalizedMessage());
        return CommonResult.error("数据重复，请检查");
    }

    /**
     * 数据库不支持emoji字符
     */
    @ExceptionHandler(UncategorizedSQLException.class)
    public CommonResult<?> uncategorizedSQLException(UncategorizedSQLException e) {
        log.info("=====GlobalExceptionHandler-uncategorizedSQLException====="+ e.getMessage());
        return CommonResult.error("内容可能包含emoji等非法字符，请重试");
    }

    /**
     * 其余异常 异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public CommonResult<?> handleException(Exception e) {
        log.info("=====GlobalExceptionHandler-handleException=====操作失败=====" + e.toString());
        return CommonResult.error(e.getMessage());
    }

}
