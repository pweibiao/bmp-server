package com.rainbowred.echatServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowred.echatServer.domain.BmpServerChatRecord;
import com.rainbowred.echatServer.domain.BmpServerStaffStatus;
import com.rainbowred.echatServer.domain.BmpServerTicketRecord;

import java.util.List;

/**
* @author pengweibiao
* @description 针对表【bmp_server_chat_record(对话数据)】的数据库操作Service
* @createDate 2023-05-17 10:19:46
*/
public interface BmpServerChatRecordService extends IService<BmpServerChatRecord> {

    void insertOrUpdate(BmpServerChatRecord pojo);

    List<BmpServerChatRecord> dateList(BmpServerTicketRecord pojo);

}
