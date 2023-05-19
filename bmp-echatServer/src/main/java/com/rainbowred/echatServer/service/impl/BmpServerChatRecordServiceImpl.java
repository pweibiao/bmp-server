package com.rainbowred.echatServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowred.echatServer.domain.BmpServerChatRecord;
import com.rainbowred.echatServer.domain.BmpServerTicketRecord;
import com.rainbowred.echatServer.mapper.BmpServerChatRecordMapper;
import com.rainbowred.echatServer.service.BmpServerChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author pengweibiao
* @description 针对表【bmp_server_chat_record(对话数据)】的数据库操作Service实现
* @createDate 2023-05-17 10:19:46
*/
@Service
public class BmpServerChatRecordServiceImpl extends ServiceImpl<BmpServerChatRecordMapper, BmpServerChatRecord>
implements BmpServerChatRecordService{

    @Autowired
    private BmpServerChatRecordMapper mapper;

    /**
     * 服务器交互事件，新增或更新数据
     * @param pojo
     */
    @Override
    public void insertOrUpdate(BmpServerChatRecord pojo) {
        mapper.insertOrUpdate(pojo);
    }

    @Override
    public List<BmpServerChatRecord> dateList(BmpServerTicketRecord pojo) {
        return null;
    }
}
