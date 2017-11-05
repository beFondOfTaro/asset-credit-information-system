package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 图片类型
 */
@Entity
public class PicClassify {

    @Id
    @GeneratedValue
    private Integer id;

    private String classify;//图片类别

    public PicClassify() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
