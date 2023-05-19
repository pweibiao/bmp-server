package com.rainbowred.pojo;

import com.rainbowred.common.util.StringUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * @Desc: 排序参数
 * @Date: 2022/11/25 10:19
 * @Author: pengweibiao
 **/
public class OrderValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段名
     */
    private Map<String, String> fieldNames;

    /**
     * 排序类型
     * 0：升序
     * 1：降序
     */
    private String orderType = "asc";

    /**
     * 转换后的 排序SQL
     */
    private String value;

    public OrderValue() {}

    public OrderValue(String fieldName) {
        this.fieldName = fieldName;
    }

    public OrderValue(String fieldName, String orderType) {
        this.fieldName = fieldName;
        if (StringUtil.nonEmpty(orderType)) {
            this.setOrderType(orderType);
        }
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        if (orderType.equals("1")) {
            this.orderType = "desc";
        }else if (orderType.equals("0")) {
            this.orderType = "asc";
        }else {
            this.orderType = "asc";
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String build() {
        StringBuilder orderSb = new StringBuilder("");
        if(fieldName != null && fieldName.indexOf(".") == -1) {
            orderSb.append("e.").append(fieldName);
        } else {
            orderSb.append(fieldName);
        }
        if (orderSb.length() != 0 && StringUtil.nonEmpty(orderType)) {
            return value = orderSb.append(" ").append(orderType).toString().toLowerCase();
        } else {
            return null;
        }
    }

}
