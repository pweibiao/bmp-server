package com.rainbowred.common.exception;

import com.rainbowred.common.enums.ErrorCode;

/**
 * @Desc: 业务异常
 * @Date: 2022/9/5 09:51
 * @Author: pengweibiao
 **/
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -1L;

    // 错误码
    private ErrorCode resultCode;

    private Integer code;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ErrorCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
        this.code = new Integer(resultCode.getCode().substring(1));
    }

    public BusinessException(ErrorCode resultCode, String message) {
        super(message);
        this.code = new Integer(resultCode.getCode().substring(1));
    }

    public ErrorCode getResultCode() {
        return resultCode;
    }

    public Integer getCode() {
        return code;
    }

}
