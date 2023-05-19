package com.rainbowred.common.controller;

import com.rainbowred.common.enums.ErrorCode;
import com.rainbowred.common.exception.BusinessException;
import com.rainbowred.common.service.RedisService;
import com.rainbowred.common.util.JwtTokenUtil;
import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.common.util.SpringUtils;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.common.util.aes.SHA1;
import com.rainbowred.domain.BaseDomain;
import com.rainbowred.pojo.CommonResult;
import com.rainbowred.pojo.PageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc: 控制层基类
 * @Date: 2022/7/6 16:23
 * @Author: pengweibiao
 **/
@Slf4j
public class BaseController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.token-head}")
    private String tokenHead;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PojoUtil pojoUtil;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    protected <T> CommonResult<T> success() {
        return CommonResult.success();
    }

    protected <T> CommonResult<T> success(T entity) {
        return CommonResult.success(entity);
    }

    protected <T> CommonResult<T> success(String message) {
        return CommonResult.success(message);
    }

    protected <T> CommonResult<T> success(String message, T entity) {
        return CommonResult.success(message, entity);
    }

    protected <T> CommonResult<T> error() {
        return error("请求异常");
    }

    protected <T> CommonResult<T> error(T entity) {
        return CommonResult.error(entity);
    }

    protected <T> CommonResult<T> error(ErrorCode errorCode) {
        return CommonResult.error(errorCode);
    }

    protected <T> CommonResult<T> error(String msg) {
        return CommonResult.error(msg);
    }

    protected <T> CommonResult<T> error(String msg, T entity) {
        return CommonResult.error(msg, entity);
    }

    protected <T> CommonResult<T> result(boolean b) {
        if (b) {
            return CommonResult.success();
        } else {
            return CommonResult.error();
        }
    }

    protected <T> CommonResult<T> error(HttpStatus httpStatus) {
        String reasonPhrase = httpStatus.getReasonPhrase();
        int value = httpStatus.value();
        return CommonResult.error(value, reasonPhrase);
    }


    /**
     * 获取请求路径参数
     * @param request 请求
     * @return 参数
     */
    protected Map<String, String> getParamMap(HttpServletRequest request) {
        Map<String, String> parameterMaps = new HashMap<String, String>();
        for(Enumeration<String> names = request.getParameterNames(); names.hasMoreElements();){
            String name = names.nextElement();
            parameterMaps.put(name, request.getParameter(name));
        }
        if (CollectionUtils.isEmpty(parameterMaps)) {
            throw new BusinessException(ErrorCode.E416, "参数为空");
        }
        return parameterMaps;
    }

    /**
     * 分页参数校验
     * @param pageParam
     */
    protected void validatePageParam(PageParam pageParam) {
        validatePojo(pageParam, "分页参数");
        Integer pageNum = pageParam.getPageNum();
        Integer pageSize = pageParam.getPageSize();
        if (Objects.isNull(pageNum)) {
            throw new BusinessException(ErrorCode.E416, "分页参数错误，页码为空");
        }
        if (Objects.isNull(pageSize)) {
            throw new BusinessException(ErrorCode.E416, "分页参数错误，每页数量为空");
        }
        if (pageNum < 0 || pageSize <= 0) {
            throw new BusinessException(ErrorCode.E400, "分页参数错误，数量为负数");
        }

    }

    /**
     * 校验请求参数
     * @param pojo
     * @param <T>
     */
    protected <T> void validatePojo(T pojo, String description) {
        if (Objects.isNull(pojo)) {
            throw new BusinessException(ErrorCode.E416, description + "为空");
        }
    }

    /**
     * 校验实体 id
     * @param pojo
     * @param <T>
     */
    protected <T extends BaseDomain> void validateId(T pojo, String description) {
        validatePojo(pojo, description);
        if (StringUtil.isEmpty(pojo.getId())) {
            throw new BusinessException(ErrorCode.E416, "id为空");
        }
    }

    /**
     * 获取当前登录用户账号
     */
    protected String getUsername() {
        HttpServletRequest request = SpringUtils.getRequest();
        // 获取 请求头
        String authorization = request.getHeader(tokenHeader);

        if (Objects.nonNull(authorization) && authorization.startsWith(tokenHead)) {
            // 解析请求头内容, 获取token
            String authToken = authorization.substring(tokenHead.length()+1);
            // 解析token，获取用户名
            String username = jwtTokenUtil.getClaimKeyUsername(authToken);
            if (StringUtil.nonEmpty(username)) {
                return username;
            }
        }
        return null;
    }

    /**
     * 管理员权限
     */
    protected void validAdmin() {
        if (!pojoUtil.validAdmin(getUsername())) {
            throw new BusinessException(ErrorCode.E405);
        }
    }

    /**
     * 语种类型赋值
     */
    protected String validCompanyId(String companyId) {
        if (StringUtil.isEmpty(companyId)) {
            throw new BusinessException("传入的语种类型为空，请联系管理员");
        }
        return companyId;
    }

    /**
     * 校验Signature
     */
    protected boolean validSignature(String token, String signature, String timestamp, String nonce) {
        if (StringUtil.nonEmpty(signature)) {
            String sha1 = getSignature(token, timestamp, nonce);
            return sha1.equals(signature);
        }
        return false;
    }

    /**
     * 生成 Signature
     */
    protected String getSignature(String token, String timestamp, String nonce) {
        if (StringUtil.nonEmpty(token) &&
                StringUtil.nonEmpty(timestamp) &&
                StringUtil.nonEmpty(nonce)) {
            return SHA1.getSHA1(token, timestamp, nonce);
        }
        return new String();
    }

}
