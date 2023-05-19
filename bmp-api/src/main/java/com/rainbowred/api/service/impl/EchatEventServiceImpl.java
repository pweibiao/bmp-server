package com.rainbowred.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.collect.Lists;
import com.rainbowred.api.pojo.ServerPojo;
import com.rainbowred.common.util.PojoUtil;
import com.rainbowred.echatServer.data.PageData;
import com.rainbowred.echatServer.data.TrackData;
import com.rainbowred.echatServer.data.VisitorPageDatas;
import com.rainbowred.echatServer.domain.*;
import com.rainbowred.echatServer.service.*;
import com.rainbowred.echatServer.xml.*;
import com.rainbowred.api.service.EchatEventService;
import com.rainbowred.basic.domain.SystemCompany;
import com.rainbowred.basic.service.SystemCompanyCacheService;
import com.rainbowred.common.util.EchatUtil;
import com.rainbowred.common.util.StringUtil;
import com.rainbowred.common.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @Date: 2023/5/15 17:03
 * @Author: pengweibiao
 **/
@Service
@Slf4j
public class EchatEventServiceImpl implements EchatEventService {

    @Autowired
    private SystemCompanyCacheService cacheService;

    @Autowired
    private BmpServerApiLogService logService;

    @Autowired
    private BmpServerCompanyStatusService companyStatusService;

    @Autowired
    private BmpServerRouteStatusService routeStatusService;

    @Autowired
    private BmpServerSkillStatusService skillStatusService;

    @Autowired
    private BmpServerStaffStatusService staffStatusService;

    @Autowired
    private BmpServerChatRecordService chatRecordService;

    @Autowired
    private BmpServerChatRecordTransferService chatRecordTransferService;

    @Autowired
    private BmpServerTrackRecordService trackRecordService;

    @Autowired
    private BmpServerTrackRecordPageService trackRecordPageService;

    @Autowired
    private BmpServerTicketRecordService ticketRecordService;

    @Autowired
    private BmpServerTicketRecordContentService ticketRecordContentService;

    @Autowired
    private BmpServerCrmDataService crmDataService;

    @Async("asyncEchatEvent")
    @Override
    public void saveEchatEvent(HttpServletRequest request, ServerPojo pojo) {
        Date now = new Date();
        String xml = pojo.getXml();
        String companyId = pojo.getCompanyId();
        String dataType = pojo.getDataType();

        // 构建api对象
        BmpServerApiLog bmpServerApiLog = pojo.toApiLog();
        bmpServerApiLog.setUrl(request.getRequestURI());
        bmpServerApiLog.setMethod(request.getMethod());
        bmpServerApiLog.setDebug(JSONObject.toJSONString(pojo));

        if (StringUtil.nonEmpty(xml)) {
            bmpServerApiLog.setCiphertext(xml);
            // 缓存获取公司配置
            SystemCompany systemCompanyConfig = cacheService.getSystemCompanyConfig(companyId);
            if (Objects.nonNull(systemCompanyConfig)) {
                // 明文
                String plainText = EchatUtil.xmlDecoding(xml, systemCompanyConfig.getAesCodeMap());
                bmpServerApiLog.setPlaintext(plainText);

                Object[] msgIds = XMLUtil.getXMLValue(plainText, "msgId");
                bmpServerApiLog.setMsgId(msgIds[1].toString());
                Object[] tms = XMLUtil.getXMLValue(plainText, "tm");
                bmpServerApiLog.setTimestamp(new Long(tms[1].toString()));

                logService.insertOrUpdate(bmpServerApiLog);

                // 判断服务器交互事件了类型
                switch (dataType) {
                    case "companyStatus" :
                        // 公司状态
                        CompanyStatusXml companyStatusXml = (CompanyStatusXml) XMLUtil.convertXmlStrToObject(CompanyStatusXml.class, plainText);
                        BmpServerCompanyStatus companyStatus = new BmpServerCompanyStatus(companyStatusXml);
                        companyStatus.setId(PojoUtil.getUUID());
                        companyStatus.setCompanyId(companyId);
                        companyStatus.setCreateDate(now);
                        companyStatus.setCreateBy(dataType);
                        companyStatus.setUpdateDate(now);
                        companyStatus.setUpdateBy(dataType);
                        companyStatusService.insertOrUpdate(companyStatus);
                        break;
                    case "routeStatus" :
                        // 路由状态
                        RouteStatusXml routeStatusXml = (RouteStatusXml) XMLUtil.convertXmlStrToObject(RouteStatusXml.class, plainText);
                        BmpServerRouteStatus routeStatus = new BmpServerRouteStatus(routeStatusXml);
                        routeStatus.setId(PojoUtil.getUUID());
                        routeStatus.setCompanyId(companyId);
                        routeStatus.setCreateDate(now);
                        routeStatus.setCreateBy(dataType);
                        routeStatus.setUpdateDate(now);
                        routeStatus.setUpdateBy(dataType);
                        routeStatusService.insertOrUpdate(routeStatus);
                        break;
                    case "skillStatus" :
                        // 分组状态
                        SkillStatusXml skillStatusXml = (SkillStatusXml) XMLUtil.convertXmlStrToObject(SkillStatusXml.class, plainText);
                        BmpServerSkillStatus skillStatus = new BmpServerSkillStatus(skillStatusXml);
                        skillStatus.setId(PojoUtil.getUUID());
                        skillStatus.setCompanyId(companyId);
                        skillStatus.setCreateDate(now);
                        skillStatus.setCreateBy(dataType);
                        skillStatus.setUpdateDate(now);
                        skillStatus.setUpdateBy(dataType);
                        skillStatusService.insertOrUpdate(skillStatus);
                        break;
                    case "staffStatus" :
                        // 客服状态
                        StaffStatusXml staffStatusXml = (StaffStatusXml) XMLUtil.convertXmlStrToObject(StaffStatusXml.class, plainText);
                        BmpServerStaffStatus staffStatus = new BmpServerStaffStatus(staffStatusXml);
                        staffStatus.setId(PojoUtil.getUUID());
                        staffStatus.setCompanyId(companyId);
                        staffStatus.setCreateDate(now);
                        staffStatus.setCreateBy(dataType);
                        staffStatus.setUpdateDate(now);
                        staffStatus.setUpdateBy(dataType);
                        staffStatusService.insertOrUpdate(staffStatus);
                        break;
                    case "chatStart" : case "robotChatStart":
                        // 对话数据
                        ChatStart chatStart = (ChatStart) XMLUtil.convertXmlStrToObject(ChatStart.class, plainText);
                        BmpServerChatRecord chatStartData = new BmpServerChatRecord(chatStart);
//                        chatStartData.setId(PojoUtil.getUUID());
                        chatStartData.setCompanyId(companyId);
                        chatStartData.setCreateDate(now);
                        chatStartData.setCreateBy(dataType);
                        chatStartData.setUpdateDate(now);
                        chatStartData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatStartData);
                        break;
                    case "chatAnswer" :
                        // 对话接通
                        ChatAnswer chatAnswer = (ChatAnswer) XMLUtil.convertXmlStrToObject(ChatAnswer.class, plainText);
                        BmpServerChatRecord chatAnswerData = new BmpServerChatRecord(chatAnswer);
//                        chatAnswerData.setId(PojoUtil.getUUID());
                        chatAnswerData.setCompanyId(companyId);
                        chatAnswerData.setCreateDate(now);
                        chatAnswerData.setCreateBy(dataType);
                        chatAnswerData.setUpdateDate(now);
                        chatAnswerData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatAnswerData);
                        break;
                    case "chatScore" :
                        // 满意度评价
                        ChatScore chatScore = (ChatScore) XMLUtil.convertXmlStrToObject(ChatScore.class, plainText);
                        BmpServerChatRecord chatScoreData = new BmpServerChatRecord(chatScore);
//                        chatScoreData.setId(PojoUtil.getUUID());
                        chatScoreData.setCompanyId(companyId);
                        chatScoreData.setCreateDate(now);
                        chatScoreData.setCreateBy(dataType);
                        chatScoreData.setUpdateDate(now);
                        chatScoreData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatScoreData);
                        break;
                    case "chatSubject" :
                        // 对话主题评估
                        ChatSubject chatSubject = (ChatSubject) XMLUtil.convertXmlStrToObject(ChatSubject.class, plainText);
                        BmpServerChatRecord chatSubjectData = new BmpServerChatRecord(chatSubject);
//                        chatSubjectData.setId(PojoUtil.getUUID());
                        chatSubjectData.setCompanyId(companyId);
                        chatSubjectData.setCreateDate(now);
                        chatSubjectData.setCreateBy(dataType);
                        chatSubjectData.setUpdateDate(now);
                        chatSubjectData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatSubjectData);
                        break;
                    case "chatEnd" : case "robotChatEnd":
                        // 对话数据
                        ChatEnd chatEnd = (ChatEnd) XMLUtil.convertXmlStrToObject(ChatEnd.class, plainText);
                        BmpServerChatRecord chatEndData = new BmpServerChatRecord(chatEnd);
//                        chatEndData.setId(PojoUtil.getUUID());
                        chatEndData.setCompanyId(companyId);
                        chatEndData.setCreateDate(now);
                        chatEndData.setCreateBy(dataType);
                        chatEndData.setUpdateDate(now);
                        chatEndData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatEndData);
                        break;
                    case "chatContent" : case "robotChatContent":
                        // 对话内容
                        ChatContent chatContent = (ChatContent) XMLUtil.convertXmlStrToObject(ChatContent.class, plainText);
                        BmpServerChatRecord chatContentData = new BmpServerChatRecord(chatContent);
//                        chatContentData.setId(PojoUtil.getUUID());
                        chatContentData.setCompanyId(companyId);
                        chatContentData.setCreateDate(now);
                        chatContentData.setCreateBy(dataType);
                        chatContentData.setUpdateDate(now);
                        chatContentData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(chatContentData);
                        break;
                    case "leaveMsgContent" :
                        // 留言数据
                        LeaveMsgContent leaveMsgContent = (LeaveMsgContent) XMLUtil.convertXmlStrToObject(LeaveMsgContent.class, plainText);
                        BmpServerChatRecord leaveMsgContentData = new BmpServerChatRecord(leaveMsgContent);
//                        leaveMsgContentData.setId(PojoUtil.getUUID());
                        leaveMsgContentData.setCompanyId(companyId);
                        leaveMsgContentData.setCreateDate(now);
                        leaveMsgContentData.setCreateBy(dataType);
                        leaveMsgContentData.setUpdateDate(now);
                        leaveMsgContentData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(leaveMsgContentData);
                        break;
                    case "leaveMsgOwner" :
                        // 留言分配
                        LeaveMsgOwner leaveMsgOwner = (LeaveMsgOwner) XMLUtil.convertXmlStrToObject(LeaveMsgOwner.class, plainText);
                        BmpServerChatRecord leaveMsgOwnerData = new BmpServerChatRecord(leaveMsgOwner);
//                        leaveMsgOwnerData.setId(PojoUtil.getUUID());
                        leaveMsgOwnerData.setCompanyId(companyId);
                        leaveMsgOwnerData.setCreateDate(now);
                        leaveMsgOwnerData.setCreateBy(dataType);
                        leaveMsgOwnerData.setUpdateDate(now);
                        leaveMsgOwnerData.setUpdateBy(dataType);
                        chatRecordService.insertOrUpdate(leaveMsgOwnerData);
                        break;
                    case "chatTransfer" :
                        // 新增对话转接数据
                        ChatTransfer chatTransfer = (ChatTransfer) XMLUtil.convertXmlStrToObject(ChatTransfer.class, plainText);
                        chatTransfer.setDataType(dataType);
                        BmpServerChatRecordTransfer chatRecordTransfer = new BmpServerChatRecordTransfer(chatTransfer);
                        chatRecordTransfer.setId(PojoUtil.getUUID());
                        chatRecordTransfer.setCompanyId(companyId);
                        chatRecordTransfer.setCreateDate(now);
                        chatRecordTransfer.setCreateBy(dataType);
                        chatRecordTransferService.save(chatRecordTransfer);
                        // 更新对话数据
                        UpdateWrapper<BmpServerChatRecord> transferUw = new UpdateWrapper<>();
                        transferUw.set("is_transfer", 1).set("update_date", now).set("update_by", dataType)
                                .eq("id", chatRecordTransfer.getChatRecordId())
                                .eq("company_id", companyId);
                        chatRecordService.update(transferUw);
                        break;
                    case "visitorEnter" :
                        VisitorEnter visitorEnter = (VisitorEnter) XMLUtil.convertXmlStrToObject(VisitorEnter.class, plainText);
                        BmpServerTrackRecord trackRecord = new BmpServerTrackRecord(visitorEnter);
                        trackRecord.setCompanyId(companyId);
                        trackRecord.setCreateDate(now);
                        trackRecord.setCreateBy(dataType);
                        trackRecordService.save(trackRecord);
                        break;
                    case "visitorOut" :
                        VisitorOut visitorOut = (VisitorOut) XMLUtil.convertXmlStrToObject(VisitorOut.class, plainText);
                        BmpServerTrackRecord visitorOutData = new BmpServerTrackRecord(visitorOut);
                        visitorOutData.setCompanyId(companyId);
                        visitorOutData.setUpdateDate(now);
                        visitorOutData.setUpdateBy(dataType);
                        trackRecordService.insertOrUpdate(visitorOutData);
                        break;
                    case "visitorTrackPage" :
                        VisitorTrackPage visitorTrackPage = (VisitorTrackPage) XMLUtil.convertXmlStrToObject(VisitorTrackPage.class, plainText);
                        TrackData trackData = visitorTrackPage.getTrackData();
                        if (trackData != null) {
                            VisitorPageDatas visitPageDatas = trackData.getVisitPageDatas();
                            if (visitPageDatas != null) {
                                List<PageData> pageDatas = visitPageDatas.getPageData();
                                if (CollectionUtils.isEmpty(pageDatas)) {
                                    break;
                                }
                                String visitorId = trackData.getVisitorId();
                                Long trackRecordId = new Long(trackData.getTrackRecordId());
                                List<BmpServerTrackRecordPage> trackRecordDetailDatas = Lists.newArrayList();
                                for (PageData pageData : pageDatas) {
                                    BmpServerTrackRecordPage visitorTrackPageData = new BmpServerTrackRecordPage(pageData);
                                    visitorTrackPageData.setId(PojoUtil.getUUID());
                                    visitorTrackPageData.setCompanyId(companyId);
                                    visitorTrackPageData.setCreateDate(now);
                                    visitorTrackPageData.setCreateBy(dataType);
                                    visitorTrackPageData.setVisitorId(visitorId);
                                    visitorTrackPageData.setTrackRecordId(trackRecordId);
                                    trackRecordDetailDatas.add(visitorTrackPageData);
                                }
                                trackRecordPageService.saveBatch(trackRecordDetailDatas);
                            }
                        }
                        break;
                    case "jobCreated" :
                        JobCreated jobCreated = (JobCreated) XMLUtil.convertXmlStrToObject(JobCreated.class, plainText);
                        BmpServerTicketRecord jobCreateData = new BmpServerTicketRecord(jobCreated);
                        jobCreateData.setCompanyId(companyId);
                        jobCreateData.setCreateDate(now);
                        jobCreateData.setCreateBy(dataType);
                        ticketRecordService.save(jobCreateData);
                        break;
                    case "jobUpdated":
                        JobUpdated jobUpdated = (JobUpdated) XMLUtil.convertXmlStrToObject(JobUpdated.class, plainText);
                        BmpServerTicketRecord jobUpdateData = new BmpServerTicketRecord(jobUpdated);
                        jobUpdateData.setCompanyId(companyId);
                        jobUpdateData.setUpdateDate(now);
                        jobUpdateData.setUpdateBy(dataType);
                        ticketRecordService.updateById(jobUpdateData);

                        BmpServerTicketRecordContent ticketRecordContent = new BmpServerTicketRecordContent(jobUpdated);
                        ticketRecordContent.setId(PojoUtil.getUUID());
                        ticketRecordContent.setCreateBy(dataType);
                        ticketRecordContent.setCreateDate(now);
                        ticketRecordContent.setCompanyId(companyId);
                        ticketRecordContentService.save(ticketRecordContent);
                        break;
                    case "jobEvaluation":
                        JobEvaluations jobEvaluations = (JobEvaluations) XMLUtil.convertXmlStrToObject(JobEvaluations.class, plainText);
                        BmpServerTicketRecord jobEvaluationData = new BmpServerTicketRecord(jobEvaluations);
                        jobEvaluationData.setCompanyId(companyId);
                        jobEvaluationData.setUpdateDate(now);
                        jobEvaluationData.setUpdateBy(dataType);
                        ticketRecordService.updateById(jobEvaluationData);
                        break;
                    case "crmStatus": case "crmOwner":
                        CrmStatus crmStatus = (CrmStatus) XMLUtil.convertXmlStrToObject(CrmStatus.class, plainText);
                        BmpServerCrmData crmData = new BmpServerCrmData(crmStatus);
                        crmData.setCompanyId(companyId);
                        crmData.setCreateDate(now);
                        crmData.setCreateBy(dataType);
                        crmData.setUpdateDate(now);
                        crmData.setUpdateBy(dataType);
                        crmDataService.insertOrUpdate(crmData);
                        break;
                }
            }
        }
    }
}
