package com.limovue.common;

/**
 * 返回实体
 */
public class ReturnDTO {
    /**
     * 返回码  200 成功  其他都是失败
     */
    private String resCode;
    /**
     * 返回状态
     */
    private boolean success;
    /**
     * 接口返回成功的实体类
     */
    private Object obj;
    /**
     * 错误的具体消息
     */
    private String errMsg;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
