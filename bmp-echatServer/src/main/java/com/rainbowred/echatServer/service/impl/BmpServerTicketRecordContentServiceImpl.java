package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerTicketRecordContent;
import com.rainbowred.echatServer.service.BmpServerTicketRecordContentService;
import com.rainbowred.echatServer.mapper.BmpServerTicketRecordContentMapper;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_ticket_record_content(工单更新内容)】的数据库操作Service实现
* @createDate 2023-05-17 10:27:07
*/
@Service
public class BmpServerTicketRecordContentServiceImpl extends ServiceImpl<BmpServerTicketRecordContentMapper, BmpServerTicketRecordContent>
implements BmpServerTicketRecordContentService{

}
