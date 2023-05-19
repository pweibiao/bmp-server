package com.rainbowred.echatServer.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rainbowred.domain.BaseBizDomain;
import com.rainbowred.echatServer.xml.SkillStatusXml;
import lombok.Data;

/**
 * 接待组状态
 * @TableName bmp_server_skill_status
 */
@Data
@TableName(value ="bmp_server_skill_status")
public class BmpServerSkillStatus extends BaseBizDomain {

    public BmpServerSkillStatus(){}

    public BmpServerSkillStatus(SkillStatusXml pojo) {
        this.skillStatus = pojo.getSkillStatus();
        this.skillId = pojo.getSkillId();
        this.skillName = pojo.getSkillName();
    }

    /**
     * 接待组状态。1：在线，2：离线
     */
    private Integer skillStatus;

    /**
     * 接待组ID
     */
    private Long skillId;

    /**
     * 接待组名称
     */
    private String skillName;
}
