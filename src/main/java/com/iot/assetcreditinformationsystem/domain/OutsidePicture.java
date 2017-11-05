package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OutsidePicture {

    @Id
    @GeneratedValue
    private Integer id;

    private String pic;//图片路径

    private Integer picClassifyId;//图片类别

    private Integer preAssessmentReportId;//预评报单

    public OutsidePicture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getPicClassifyId() {
        return picClassifyId;
    }

    public void setPicClassifyId(Integer picClassifyId) {
        this.picClassifyId = picClassifyId;
    }

    public Integer getPreAssessmentReportId() {
        return preAssessmentReportId;
    }

    public void setPreAssessmentReportId(Integer preAssessmentReportId) {
        this.preAssessmentReportId = preAssessmentReportId;
    }
}
