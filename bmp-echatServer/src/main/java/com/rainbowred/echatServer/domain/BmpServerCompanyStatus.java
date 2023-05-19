package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.xml.CompanyStatusXml;
import lombok.Data;

/**
 * 公司状态
 * @TableName bmp_server_company_status
 */
@Data
@TableName(value ="bmp_server_company_status")
public class BmpServerCompanyStatus extends BaseBizDomain {

    public BmpServerCompanyStatus(){}

    public BmpServerCompanyStatus(CompanyStatusXml companyStatusXml) {
        this.companyStatus = companyStatusXml.getCompanyStatus();
    }

    /**
     * 公司状态。1：在线，2：离线
     */
    private Integer companyStatus;
}
