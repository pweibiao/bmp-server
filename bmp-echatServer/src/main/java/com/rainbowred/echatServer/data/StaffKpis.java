package com.rainbowred.echatServer.data;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @Desc:
 * @Date: 2022/7/10 10:59
 * @Author: pengweibiao
 **/
@Data
public class StaffKpis extends BaseData {

    @XmlElement(name = "staffKpi")
    private List<StaffKpiData> staffKpi;

    @XmlTransient
    public List<StaffKpiData> getStaffKpi() {
        return staffKpi;
    }
}
