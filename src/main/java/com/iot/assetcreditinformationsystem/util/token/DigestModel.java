package com.iot.assetcreditinformationsystem.util.token;

import java.util.Date;

public class DigestModel {

    private Integer userId;//用户id

    private Date createdDate;//创建token时间戳

    public DigestModel() {
        this.createdDate = new Date();
    }

    public DigestModel(Integer userId) {
        this.userId = userId;
        this.createdDate = new Date();
    }

    public DigestModel(Integer userId, Date createdDate) {
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
