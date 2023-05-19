package com.rainbowred.common.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.common.domain.CommonElement;
import com.rainbowred.common.mapper.CommonElementMapper;
import com.rainbowred.common.service.CommonElementService;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_base_common_element(通用层级表)】的数据库操作Service实现
* @createDate 2022-11-21 12:23:11
*/
@Service
public class CommonElementServiceImpl extends ServiceImpl<CommonElementMapper, CommonElement>
implements CommonElementService {
}
