package com.iot.assetcreditinformationsystem.util;

/**
 * 向客户端响应的数据模版
 */
public class ResponseModel {

    public static final String SUCCESS_MSG = "success";

    public static final String FAILED_MSG = "failed";

    private Integer status;

    private String msg;

    private Object data;

    public ResponseModel() {
        this.status = 200;
        this.msg = SUCCESS_MSG;
    }

    public ResponseModel(String msg, Object data) {
        this.status = 200;
        this.msg = msg;
        this.data = data;
    }

    public ResponseModel(Object data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResponseModel(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseModel(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
