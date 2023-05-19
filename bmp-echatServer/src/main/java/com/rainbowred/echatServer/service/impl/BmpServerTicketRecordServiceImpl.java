package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerTicketRecord;
import com.rainbowred.echatServer.mapper.BmpServerTicketRecordMapper;
import com.rainbowred.echatServer.service.BmpServerTicketRecordService;
import org.springframework.stereotype.Service;

/**
* @author pengweibiao
* @description 针对表【bmp_server_ticket_record(工单数据)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerTicketRecordServiceImpl extends ServiceImpl<BmpServerTicketRecordMapper, BmpServerTicketRecord>
implements BmpServerTicketRecordService{

}
