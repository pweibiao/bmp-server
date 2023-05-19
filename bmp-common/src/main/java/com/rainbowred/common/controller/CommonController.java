package com.rainbowred.common.controller;

import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: 通用类接口
 * @Date: 2022/11/25 15:01
 * @Author: pengweibiao
 **/
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController{

    /**
     * 获取随机id
     * @return
     */
    @GetMapping("/uuid")
    public CommonResult<String> getUUID() {
        return success(PojoUtil.getUUID());
    }

}
